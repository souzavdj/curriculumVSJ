<%-- 
    Document   : Form_Institution
    Created on : 10/08/2018, 01:25:39
    Author     : vinicius
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="import_head.jspf"%>
        <title><fmt:message key="br.com.curriculumVSJ.Form_Institution.title"/></title>
    </head>
    <body>
        <%@include file="import_navbar.jspf"%>
        <br>
        <h1 class="col-sm-auto" align="center"><b><fmt:message key="br.com.curriculumVSJ.Form_Institution.title"/></b></h1>
        <core:if test="${not empty msgSuccess}">
            <hr>
            <br>
            <div class="text-center alert alert-success" role="alert">
                <h3>${ requestScope.msgSuccess }</h3>
            </div>
            
        </core:if>
            
        <form class="text-center border border-light p-5" action="FormInstitutionServlet" method="POST">
            
            <div align="center">
                <div class="col-md-5">
                    <!-- Name -->
                    <input type="text" id="nameInstitution" name="name" value="${param.name}" class="form-control <core:if test="${empty requestScope.nameSpace}">mb-4</core:if> ${requestScope.nameIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.name"/>" maxlength="254" style="text-transform:uppercase">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.nameSpace}">mb-4</core:if>">
                        ${requestScope.nameMsgError}
                    </div>
                    <!-- E-mail -->
                    <input type="text" id="emailInstitution" name="email" value="${param.email}" class="form-control <core:if test="${empty requestScope.emailSpace}">mb-4</core:if> ${requestScope.emailIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.email"/>" maxlength="254" style="text-transform:uppercase">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.emailSpace}">mb-4</core:if>">
                        ${requestScope.emailMsgError}
                    </div>    
                    <!-- Department -->
                    <input type="text" id="departmentInstitution" name="department" value="${param.department}" class="form-control <core:if test="${empty requestScope.departmentSpace}">mb-4</core:if> ${requestScope.departmentIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.department"/>" maxlength="254" style="text-transform:uppercase">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.departmentSpace}">mb-4</core:if>">
                        ${requestScope.departmentMsgError}
                    </div>

                    <!-- Phone number -->
                    <input type="text" id="phoneInstitution" name="phone" value="${param.phone}" class="form-control <core:if test="${empty requestScope.phoneSpace}">mb-4</core:if> ${requestScope.phoneIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.phone"/>" aria-describedby="defaultRegisterFormPhoneHelpBlock" maxlength="14" style="text-transform:uppercase">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.phoneSpace}">mb-4</core:if>">
                        ${requestScope.phoneMsgError}
                    </div>
                    <br><br>
                    <hr>
                    <p class="text-center"><b><fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address"/></b></p>
                </div>
                    <div class="form-row mb-4 col-md-5">
                        <div class="col input-group">
                            <!-- Zip Code -->
                            <input type="text" id="zipCode" name="zipCode" value="${param.zipCode}" class="form-control ${requestScope.zipCodeIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.zipcode"/>" maxlength="9" style="text-transform:uppercase">
                            <span class="input-group-btn"> 
                                <button type="button" class="btn btn-info btn-block form-control" name="btnSearchZipCode" onclick="javascript:searchZipCode()"><fmt:message key = "br.com.curriculumVSJ.Form_Institution.button.search"/></button>
                            </span>
                            <div class="invalid-feedback">
                                <label id="zipCodeMsgError">${requestScope.zipCodeMsgError}</label>
                            </div>
                        </div>
                        <div class="col">
                            <!-- Street -->
                            <input type="text" id="street" name="street" value="${ param.street }" class="form-control ${requestScope.streetIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.street"/>" maxlength="254" style="text-transform:uppercase">    
                            <div class="invalid-feedback">
                                ${requestScope.streetMsgError}
                            </div>
                        </div>
                    </div>
                    <div class="form-row mb-4 col-md-5">
                        <div class="col">
                            <!-- Number -->
                            <input type="text" id="number" name="number" value="${param.number}" class="form-control ${requestScope.numberIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.number"/>" maxlength="8" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.numberMsgError}
                            </div>
                        </div>
                        <div class="col">
                            <!-- Complement -->
                            <input type="text" id="complement" name="complement" value="${param.complement}" class="form-control ${requestScope.complementIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.complement"/>" maxlength="254" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.complementMsgError}
                            </div>
                            <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted">
                                <fmt:message key="br.com.curriculumVSJ.Form_Institution.label.optional"/>
                            </small>
                        </div>
                    </div>
                    <div class="form-row mb-4 col-md-5">
                        <div class="col">
                            <!-- Neighborhood -->
                            <input type="text" id="neighborhood" name="neighborhood" value="${param.neighborhood}" class="form-control ${requestScope.neighborhoodIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.neighborhood"/>" maxlength="254" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.neighborhoodMsgError}
                            </div>
                        </div>
                        <div class="col">
                            <!-- City -->
                            <input type="text" id="city" name="city" value="${param.city}" class="form-control ${requestScope.cityIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.city"/>" maxlength="254" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.cityMsgError}
                            </div>
                        </div>
                    </div>
                    <div class="form-row mb-4 col-md-5">
                        <div class="col">
                            <!-- State -->
                            <input type="text" id="state" name="state" value="${param.state}" class="form-control ${requestScope.stateIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.stage"/>" maxlength="254" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.stateMsgError}
                            </div>
                        </div>
                        <div class="col">
                            <!-- Country -->
                            <input type="text" id="country" name="country" value="${param.country}" class="form-control ${requestScope.countryIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.country"/>" maxlength="254" style="text-transform:uppercase">
                            <div class="invalid-feedback">
                                ${requestScope.countryMsgError}
                            </div>
                        </div>
                    </div>
                    <div class="mb-4 col-md-5">
                        <br>
                        <hr>
                    </div>
                <div class="form-row mb-4 col-md-5">    
                    <div class="col">
                        <!-- Sign up button -->
                        <button class="btn btn-info btn-block form-control" type="submit"><fmt:message key="br.com.curriculumVSJ.Form_Institution.button.register"/></button>
                    </div>
                    <div class="col">
                        <!-- Secondary button -->
                        <button type="button" class="btn btn-outline-info btn-block form-control" onclick="javascript:location.href='HomePage.jsp'"><fmt:message key="br.com.curriculumVSJ.Form_Institution.button.cancel"/></button>
                    </div>
                </div>
            </div>
        </form>
        <%@include file="import_footer.jspf"%>
        <%@include file="import_finalbodyscripts.jspf"%>
        <%@include file="import_scripts.jspf"%>
    </body>
</html>