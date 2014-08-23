dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://localhost/skillo?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = ""
            logSql = true
        }
        hibernate {
            show_sql = true
            format_sql = true
        }
    }

    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_skillo?useUnicode=yes&characterEncoding=UTF-8"
            username = "bb6881f1750d59"
            password = "8208b455"
            pooled = true
            properties {
                initialSize = 2
                maxActive = 4
                maxIdle = 2
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
//                max_allowed_packet=33554432
                validationQuery="SELECT 1"
            }
        }
    }

    production {
        dataSource {
            dbCreate = "update"
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://127.0.0.1:3306/smrskillo?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = ""
            pooled = true
            properties {
                initialSize = 2
                maxActive = 4
                maxIdle = 2
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
            logSql = true
        }
    }

    smrproduction {
        dataSource {
            dbCreate = "update"
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://ec2-176-34-253-124.eu-west-1.compute.amazonaws.com:3306/smrskillo"
            username = "smrskillo"
            password = "smrskillo"
            pooled = true
            properties {
                initialSize = 2
                maxActive = 4
                maxIdle = 2
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
            logSql = true
        }
    }

}
