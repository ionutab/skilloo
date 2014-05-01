<%@ page import="skillo.Candidate" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="admin_light" />
	<g:set var="entityName" value="${message(code: 'candidate.label', default: 'Candidate')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
    <r:require modules="forms"/>
    <r:require modules="candidates"/>
</head>

<body>

<g:form action="save" role="form" class="form-horizontal">
    <div class="row">
        <div class="content-container col-lg-6">
            <g:render template="form"/>
        </div>
    </div>
    <div class="row">
        <div class="content-container col-lg-4">
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-3">
                    <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.save.label', default: 'Save')}" />
                </div>
            </div>
        </div>
    </div>
</g:form>



%{--TODO create special template for these , or form--}%

</body>

</html>
