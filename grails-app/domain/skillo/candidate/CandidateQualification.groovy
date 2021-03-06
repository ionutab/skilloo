package skillo.candidate

import grails.plugin.multitenant.core.annotation.MultiTenant
import org.joda.time.DateTime
import org.joda.time.LocalDate
import skillo.Constants
import skillo.Qualification

@MultiTenant
class CandidateQualification {

    Qualification qualification
    Date expiryDate
    String number

    Boolean isMainTrade
    Boolean active = Boolean.TRUE

    static belongsTo = [candidate:Candidate]

    static constraints = {
        expiryDate nullable: true
        number nullable: true, blank: false, matches: "[a-zA-Z0-9- ]+"
    }

    def Boolean isExpired(){

        if(expiryDate == null){
            return null
        }

        DateTime now = new LocalDate().toDateTimeAtStartOfDay()
        DateTime expDate = new DateTime(expiryDate.getTime())

        return expiryDate == null ? null : expDate.isBefore(now)
    }

    def Boolean willExpireSoonerThanTwoMonths(){
        if (expiryDate == null){
            return null
        }

        DateTime now = new LocalDate().toDateTimeAtStartOfDay()
        DateTime nowPlusMargin = now.plusMonths(Constants.QUALIFICATION_EXPIRE_PERIOD)

        DateTime expDate = new DateTime(expiryDate.getTime())

        return expDate.isBefore(nowPlusMargin)
    }

    def Boolean isMoreThenTwoMonthsValid(){
        return !willExpireSoonerThanTwoMonths()
    }
}
