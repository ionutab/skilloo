package skillo

class Payroll {
    
    PayrollCompany payrollCompany
    
    Boolean registered = Boolean.FALSE
    Boolean inducted
    
    String referenceNumber
    String nationalInsuranceNumber
    String registrationNumber
    String unqiueTaxReferenceNumber

    static belongsTo = Candidate

    static constraints = {
        inducted nullable: true
        payrollCompany nullable: true
        referenceNumber nullable: true, blank: false
        nationalInsuranceNumber nullable: true, blank: false
        registrationNumber nullable: true, blank: false
        unqiueTaxReferenceNumber nullable: true, blank: false
    }
}
