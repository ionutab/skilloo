<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="admin_lte_layout"/>
    <g:set var="layout_nocontextbar" value="false" scope="request"/>
    <r:require modules="forms" />
</head>

<body>
<div class="row">
<div class="col-md-3">
    <div class="box box-solid">
        <g:uploadForm controller="consultant" action="uploadPhoto" enctype="multipart/form-data" method="POST">
            <div class="box-body">
                <h4 class="text-center">${consultant.firstName + " " + consultant.lastName}</h4>

                <div class="row">
                    <div class="col-xs-12 text-center">
                        <div class="img-thumbnail">
                            <g:img dir="images/avatar" file="nophoto.png"/>
                        </div>

                        <div class="box-tools text-center">
                            <a class="btn btn-primary btn-md  bg-blue" href="javascript:void(0);">
                                <i class="fa fa-cloud-upload append-icon"></i> Upload
                            </a>
                        </div>

                        <div class="box-tools">
                            <address>
                                <strong>Company Name Inc.</strong><br>
                                Company Address<br>
                                Company Town<br>
                                Company Phone:</abbr>&nbsp;55555-555-555
                            </address>
                        </div>
                        %{--
                        <div class="box-tools">
                            <i class="fa fa-star text-yellow fa-fw"></i><i
                                class="fa fa-star text-success fa-fw"></i><i
                                class="fa fa-star text-green fa-fw"></i><i class="fa fa-star vd_yellow fa-fw"></i><i
                                class="fa fa-star vd_yellow fa-fw"></i>
                        </div>
                        --}%
                    </div>

                </div>

            </div>
        </g:uploadForm>

    </div>
</div>

<div class="col-md-9">
<div class="box box-solid">
    <g:form controller="consultant" action="saveSettings" class="form-horizontal" autocomplete="off">
        <div class="box-body">
            <h4><i class="fa fa-wrench"></i>&nbsp;Account settings</h4>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group ${hasErrors(bean: consultant, field: 'firstName', 'has-error')}">
                        <label for="firstName" class="col-sm-2 control-label">First name</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="firstName" name="consultant.firstName"
                                    value="${consultant.firstName}">
                            <g:eachError var="err" bean="${consultant}" field="firstName">
                                <g:if test="${err.code == 'matches.invalid'}">
                                    <span class="control-label"><g:message
                                            code="custom.invalid.name.message"/></span>
                                </g:if>
                                <g:if test="${err.code == 'nullable'}">
                                    <span class="control-label"><g:message code="custom.null.message"/></span>
                                </g:if>
                            </g:eachError>
                        </div>
                    </div>

                    <div class="form-group ${hasErrors(bean: consultant, field: 'lastName', 'has-error')}">
                        <label for="lastName" class="col-sm-2 control-label">Last name</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="lastName" name="consultant.lastName"
                                    value="${consultant.lastName}">
                            <g:eachError var="err" bean="${consultant}" field="lastName">
                                <g:if test="${err.code == 'matches.invalid'}">
                                    <span class="control-label"><g:message
                                            code="custom.invalid.name.message"/></span>
                                </g:if>
                                <g:if test="${err.code == 'nullable'}">
                                    <span class="control-label"><g:message code="custom.null.message"/></span>
                                </g:if>
                            </g:eachError>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <h4><i class="fa fa-globe"></i>&nbsp;Contact settings</h4>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group ${hasErrors(bean: consultant, field: 'email', 'has-error')}">
                        <label for="email" class="col-sm-2 control-label">Email Address</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="email" name="consultant.email"
                                    value="${consultant.email}">
                            <g:eachError var="err" bean="${consultant}" field="email">
                                <g:if test="${err.code == 'email.invalid'}">
                                    <span class="control-label" ><g:message
                                        code="custom.invalid.email.message"/><span>
                                </g:if>
                                <g:if test="${err.code == 'nullable'}">
                                    <span><g:message code="custom.null.message"/></span>
                                </g:if>
                            </g:eachError>
                        </div>
                    </div>


                    <div class="form-group ${hasErrors(bean: consultant, field: 'telephoneNumber', 'has-error')}">
                        <label for="consultant.telephoneNumber" class="col-sm-2 control-label">Telephone</label>

                        <div class="col-sm-5">
                            <g:textField name="consultant.telephoneNumber" type="tel" class="form-control" id="telephoneNumber" value="${consultant.telephoneNumber}" />
                            <g:hasErrors bean="${consultant}" field="telephoneNumber">
                                <g:eachError var="err" bean="${consultant}" field="telephoneNumber">
                                    <g:if test="${err.code == 'matches.invalid'}">
                                        <span class="control-label"><g:message
                                                code="custom.invalid.telephone.message"/></span>
                                    </g:if>
                                    <g:if test="${err.code == 'blank'}">
                                        <span class="control-label"><g:message code="custom.null.message"/></span>
                                    </g:if>
                                </g:eachError>
                            </g:hasErrors>
                            <g:javascript>
                                $("#telephoneNumber").inputmask("${message(code:'default.telephoneNumber.inputmask')}", {"placeholder": "${message(code:'default.telephoneNumber.placeholder')}"});
                            </g:javascript>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="website" class="col-sm-2 control-label">Website</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="website" name="consultant.website" value="${consultant.website}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="facebook" class="col-sm-2 control-label">Facebook</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="facebook" name="consultant.facebook"
                                   value="${consultant.facebook}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="twitter" class="col-sm-2 control-label">Twitter</label>

                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="twitter" name="consultant.twitter"
                                   autocomplete="off"
                                   value="${consultant.twitter}">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <g:submitButton name="Update" class="btn btn-primary btn"/>
                    <g:link uri="/" class="btn btn-default" name="Cancel">Cancel</g:link>
                </div>
            </div>
        </div>
    </g:form>
</div>

<div class="box box-solid">
    <g:form controller="consultant" action="savePassword" class="form-horizontal"autocomplete="off">
        <div class="box-body ">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                <i class="fa fa-key"></i>&nbsp;Password settings
                            </a>
                        </h4>
                    </div>
                    <div class="row">
                    <div id="collapseOne" class="panel-collapse collapse  in">
                            <div class="panel-body">
                              <div class="col-md-12">
                                    <div class="form-group ${hasErrors(bean: consultant.user, field: 'password', 'has-error')}" >
        <label for="u_password" class="col-sm-2 control-label">Password</label>

        <div class="col-sm-5">
            <input type="password" class="form-control" id="u_password"
                   name="u_password"
                    autocomplete="off">

            <g:eachError var="err" bean="${consultant.user}">
                <g:if test="${err.code == 'password.invalid'}">
                    <span class="control-label" ><g:message
                        code="custom.invalid.authorization"/><span>
                </g:if>
            </g:eachError>

        </div>
        </div>

        <div class="form-group ${hasErrors(bean: consultant.user, field: 'password', 'has-error')}">
            <label for="newPassword" class="col-sm-2 control-label">New password</label>

            <div class="col-sm-5">
                <input type="password" class="form-control" id="newPassword"
                       name="newPassword"
                       >
            </div>
        </div>

        <div class="form-group ${hasErrors(bean: consultant.user, field: 'password', 'has-error')}">
            <label for="retypePassword"
                   class="col-sm-2 control-label">Re-type password</label>

            <div class="col-sm-5">
                <input type="password" class="form-control" id="retypePassword" name="retypePassword" >
                <g:eachError var="err" bean="${consultant.user}" field="password">
                    <g:if test="${err.code == 'password.match'}">
                        <span class="control-label" >
                            <g:message code="custom.invalid.match.password"/>
                        <span>
                    </g:if>
                </g:eachError>
            </div>

        </div>

        <div class="row">
            <div class="col-md-8">
                <g:submitButton name="Update" class="btn btn-primary btn"/>
            </div>
        </div>

        </div>
        </div>
    </g:form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>