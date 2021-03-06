import skillo.tenant.TenantMeta

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false

grails.databinding.convertEmptyStringsToNull = true
grails.gorm.failOnError = false
grails.gorm.autoFlush = false

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
      all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
      atom:          'application/atom+xml',
      css:           'text/css',
      csv:           'text/csv',
      form:          'application/x-www-form-urlencoded',
      html:          ['text/html','application/xhtml+xml'],
      js:            'text/javascript',
      json:          ['application/json', 'text/json'],
      multipartForm: 'multipart/form-data',
      rss:           'application/rss+xml',
      text:          'text/plain',
      hal:           ['application/hal+json','application/hal+xml'],
      xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000
grails.resources.uri.prefix = 'static'
// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*', '/fonts/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**', '/fonts/**', '/bootstrap/**','/adminLTE/**', '/font-awesome/**', '/select2/**']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false
// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']
// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

def logDirectory = "target"
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
    }
}

log4j = {
    debug 'org.hibernate.SQL'

    trace 'org.hibernate.type',
           'org.springframework.core.env.StandardEnvironment'

    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: "[%d{HH:mm:ss:SSS}] %-5p %c{2}: %m%n")
    }

    error 'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugins',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'net.sf.ehcache.hibernate',
            'org.hibernate'

    info  'grails.app.domain',
           'grails.app.controllers',
           'grails.app.services',
           'org.hibernate.type'

    // to see queries use trace on org.hibernate.type

}

grails.databinding.dateFormats = ['dd/MM/yyyy','MMddyyyy', 'yyyy-MM-dd HH:mm:ss.S', "yyyy-MM-dd'T'hh:mm:ss'Z'"]

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'skillo.user.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'skillo.user.UserRole'
grails.plugins.springsecurity.authority.className = 'skillo.user.Role'
grails.plugins.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugins.springsecurity.interceptUrlMap = [

        '/login/**':     ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/logout/**':    ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/js/**':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/css/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/images/**':    ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/img/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/fonts/**':     ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/about':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/**':           ['IS_AUTHENTICATED_REMEMBERED']
]
// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */

// Added by the JQuery Validation UI plugin:
jqueryValidationUi {
	errorClass = 'error'
	validClass = 'valid'
	onsubmit = true
	renderErrorsOnTop = false
	
	qTip {
		packed = true
        classes = 'ui-tooltip-red ui-tooltip-shadow ui-tooltip-rounded'
	}
	
	/*
	  Grails constraints to JQuery Validation rules mapping for client side validation.
	  Constraint not found in the ConstraintsMap will trigger remote AJAX validation.
	*/
	StringConstraintsMap = [
		blank:'required', // inverse: blank=false, required=true
		creditCard:'creditcard',
		email:'email',
		inList:'inList',
		minSize:'minlength',
		maxSize:'maxlength',
		size:'rangelength',
		matches:'matches',
		notEqual:'notEqual',
		url:'url',
		nullable:'required',
		unique:'unique',
		validator:'validator'
	]
	
	// Long, Integer, Short, Float, Double, BigInteger, BigDecimal
	NumberConstraintsMap = [
		min:'min',
		max:'max',
		range:'range',
		notEqual:'notEqual',
		nullable:'required',
		inList:'inList',
		unique:'unique',
		validator:'validator'
	]
	
	CollectionConstraintsMap = [
		minSize:'minlength',
		maxSize:'maxlength',
		size:'rangelength',
		nullable:'required',
		validator:'validator'
	]
	
	DateConstraintsMap = [
		min:'minDate',
		max:'maxDate',
		range:'rangeDate',
		notEqual:'notEqual',
		nullable:'required',
		inList:'inList',
		unique:'unique',
		validator:'validator'
	]
	
	ObjectConstraintsMap = [
		nullable:'required',
		validator:'validator'
	]
	
	CustomConstraintsMap = [
		phone:'true', // International phone number validation
		phoneUS:'true',
		alphanumeric:'true',
		letterswithbasicpunc:'true',
        lettersonly:'true'
	]	
}


// Added by the MultiTenant plugin
multiTenant {
    tenantClass = TenantMeta

}
