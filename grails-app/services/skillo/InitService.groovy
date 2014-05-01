package skillo

import groovy.sql.Sql

import javax.sql.DataSource

class InitService {

    static transactional = true

    def grailsApplication

    def dataSource

    void setDataSource(dataSource) {
        log.info("setting datasource value $dataSource")
        this.dataSource = dataSource
    }

    def serviceMethod() {

        log.debug("Current Post Codes " + PostCode.count())
        log.debug("Current Qualifications " + Qualification.count())

        if(PostCode.count() == 0 || Qualification.count() == 0){

            Sql sql = new Sql(dataSource)

            List<String> queries = new ArrayList<>();

            queries.add("INSERT INTO qualification (code, name, description, can_be_main_trade, version) SELECT code, name, description, 1 as can_be_main_trade, 0 AS version FROM qualification_temp;")
            queries.add("INSERT INTO post_code (version, code, latitude, longitude, easting, northing, grind_ref, county, district, ward, district_code, ward_code, country, country_code) SELECT   0 AS version, postcode, latitude, longitude, easting, northing, grind_ref, county, district, ward, district_code, ward_code, country,country_code FROM post_code_temp;")
            queries.add("update post_code set grind_ref = null where length(grind_ref) = 0 and grind_ref is not null;")
            queries.add("update post_code set district = null where length(district) = 0 and district is not null;")
            queries.add("update post_code set ward = null where length(ward) = 0 and ward is not null;")
            queries.add("update post_code set district_code = null where length(district_code) = 0 and district_code is not null;")
            queries.add("update post_code set ward_code = null where length(ward_code) = 0 and ward_code is not null;")
            queries.add("update post_code set county = null where length(county) = 0 and county is not null;")
            queries.add("update post_code set country = null where length(country) = 0 and country is not null;")
            queries.add("update post_code set country_code = null where length(country_code) = 0 and country_code is not null;")
            queries.add("insert into payroll_company(name,version) values('ICM',0);")
            queries.add("insert into payroll_company(name,version) values('GUILD',0);")

            queries.each {
                sql.execute(it);
            }

        }

        log.info("Current Post Codes " + PostCode.count())
        log.info("Current Qualifications " + Qualification.count())

    }
}
