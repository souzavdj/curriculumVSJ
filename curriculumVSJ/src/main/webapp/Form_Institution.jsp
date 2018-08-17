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
        
        <form class="text-center border border-light p-5" action="FormInstitutionServlet" method="POST">
            
            <div align="center">
                <div class="col-md-5">
                    <!-- Name -->
                    <input type="text" id="defaultRegisterFormName" name="name" value="${param.name}" class="form-control <core:if test="${empty requestScope.nameSpace}">mb-4</core:if> ${requestScope.nameIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.name"/>">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.nameSpace}">mb-4</core:if>">
                        ${requestScope.nameMsgError}
                    </div>
                    <!-- E-mail -->
                    <input type="email" id="defaultRegisterFormEmail" name="email" value="${param.email}" class="form-control <core:if test="${empty requestScope.emailSpace}">mb-4</core:if> ${requestScope.emailIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.email"/>">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.emailSpace}">mb-4</core:if>">
                        ${requestScope.emailMsgError}
                    </div>    
                    <!-- Department -->
                    <input type="text" id="defaultRegisterFormDepartment" name="department" value="${param.department}" class="form-control <core:if test="${empty requestScope.departmentSpace}">mb-4</core:if> ${requestScope.departmentIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.department"/>">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.departmentSpace}">mb-4</core:if>">
                        ${requestScope.departmentMsgError}
                    </div>

                    <!-- Phone number -->
                    <input type="" id="defaultRegisterPhonePassword" name="phone" value="${param.phone}" class="form-control <core:if test="${empty requestScope.phoneSpace}">mb-4</core:if> ${requestScope.phoneIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.phones"/>" aria-describedby="defaultRegisterFormPhoneHelpBlock">
                    <div class="invalid-feedback <core:if test="${not empty requestScope.phoneSpace}">mb-4</core:if>">
                        ${requestScope.phoneMsgError}
                    </div>
                    <br><br>
                    <hr>
                    <p class="text-center"><b><fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address"/></b></p>
                </div>
                <div class="form-row mb-4 col-md-5">
                    <div class="col">
                        <!-- Zip Code -->
                        <input type="text" id="defaultRegisterFormZipCode" name="zipCode" value="${param.zipCode}" class="form-control ${requestScope.zipCodeIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.zipcode"/>">
                        <div class="invalid-feedback">
                            ${requestScope.zipCodeMsgError}
                        </div>
                    </div>
                    <div class="col">
                        <!-- Street -->
                        <input type="text" id="defaultRegisterFormStreet" name="street" value="${param.street}" class="form-control ${requestScope.streetIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.street"/>">    
                        <div class="invalid-feedback">
                            ${requestScope.streetMsgError}
                        </div>
                    </div>
                </div>
                <div class="form-row mb-4 col-md-5">
                    <div class="col">
                        <!-- Number -->
                        <input type="text" id="defaultRegisterFormNumber" name="number" value="${param.number}" class="form-control ${requestScope.numberIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.number"/>">
                        <div class="invalid-feedback">
                            ${requestScope.numberMsgError}
                        </div>
                    </div>
                    <div class="col">
                        <!-- Complement -->
                        <input type="text" id="defaultRegisterFormComplement" name="complement" value="${param.complement}" class="form-control ${requestScope.complementIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.complement"/>">
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
                        <input type="text" id="defaultRegisterFormNeighborhood" name="neighborhood" value="${param.neighborhood}" class="form-control ${requestScope.neighborhoodIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.neighborhood"/>">
                        <div class="invalid-feedback">
                            ${requestScope.neighborhoodMsgError}
                        </div>
                    </div>
                    <div class="col">
                        <!-- City -->
                        <input type="text" id="defaultRegisterFormCity" name="city" value="${param.city}" class="form-control ${requestScope.cityIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.city"/>">
                        <div class="invalid-feedback">
                            ${requestScope.cityMsgError}
                        </div>
                    </div>
                </div>
                <div class="form-row mb-4 col-md-5">
                    <div class="col">
                        <!-- Stage -->
                        <input type="text" id="defaultRegisterFormStage" name="stage" value="${param.stage}" class="form-control ${requestScope.stageIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.stage"/>">
                        <div class="invalid-feedback">
                            ${requestScope.stageMsgError}
                        </div>
                    </div>
                    <div class="col">
                        <!-- Country -->
                        <input type="text" id="defaultRegisterFormContry" name="country" value="${param.country}" class="form-control ${requestScope.countryIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Form_Institution.label.address.country"/>">
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
    </body>
</html>
