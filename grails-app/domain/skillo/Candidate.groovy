package skillo

import skillo.history.SkilloDomainModelWithHistory

class Candidate implements SkilloDomainModelWithHistory {

    String firstName
    String lastName
    Date birthDate
    String nationality

    Boolean driver
    Boolean sponsored
    Boolean carOwner

    String telephoneNumber
    String otherTelephoneNumber
    String email

    Consultant consultant
    Address address
    Boolean active = Boolean.TRUE
    Payroll payroll = new Payroll()

    static hasMany = [ candidateQualifications:CandidateQualification, candidateNotes:CandidateNote, jobs:Job, placements:Placement, candidateHistory:CandidateEvent ]

    static constraints = {
        firstName blank: false, matches: "[a-zA-Z-' ]+"
        lastName blank: false, matches: "[a-zA-Z-' ]+"
        nationality nullable: true, blank: false

        telephoneNumber blank: false, nullable:true, minSize: 10, matches: "[0-9]+"
        otherTelephoneNumber nullable: true

        candidateNotes nullable: true

        //temporarily added nullable false to this , althought not necessarily required because apparently there is a little bug that will not make minSize work if nullable is not SPECIFFICALLY set :D
        candidateQualifications nullable: false
        candidateQualifications minSize: 1

        jobs nullable: true
        placements nullable: true
        payroll nullable: true

        email nullable: true, blank: false, email: true
    }

    static mapping = {
        candidateQualifications cascade: "all-delete-orphan"
        candidateHistory cascade: "all-delete-orphan"
    }

    def boolean checkVersion(Long version){
        if(this.version > version){
            return false
        }
        return true
    }

    @Override
    void addInsertEvent(Consultant consultant) {
        def insertEvent = new CandidateEvent()
        insertEvent.candidate = this
        insertEvent.consultant = this.getConsultant()
        skilloHistoryContext.insertHistory(insertEvent)
    }

    @Override
    void addInsertEvent() {
    }

    @Override
    void addUpdateEvent(Consultant eventConsultant) {
    }

    @Override
    void addUpdateEvent() {
    }
}
