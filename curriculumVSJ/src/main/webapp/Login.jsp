<%-- 
    Document   : Login
    Created on : 26/07/2018, 23:51:00
    Author     : vinicius
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="import_head.jspf"%>
        <title><fmt:message key="br.com.curriculumVSJ.Login.title"/></title>
    </head>
    <body>
        <%@include file="import_navbar.jspf"%>
        <br><br><br>
        <h1 align="center"><b><fmt:message key="br.com.curriculumVSJ.Login.title"/></b></h1>
        <br>
        <!-- Default form login -->
        <form action="LoginServlet" method="POST" class="text-center border border-light p-5">
            <div align="center">
                <!-- Email -->
                <div>
                    <input type="email" id="defaultLoginFormEmail" name="email" value="${param.email}" class="form-control mb-4 col-md-5 ${requestScope.emailIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Login.label.email"/>">
                    <div class="invalid-feedback">
                        <core:choose>
                            <core:when test="${requestScope.msgErrEmailInCorrect}">
                                <fmt:message key="br.com.curriculumVSJ.Login.valid.email.incorrect"/>
                            </core:when>
                            <core:otherwise>
                                <fmt:message key="br.com.curriculumVSJ.Login.valid.email.invalid"/>
                            </core:otherwise>
                        </core:choose>
                    </div>
                </div>
                <!-- Password -->
                <div>
                    <input type="password" id="defaultLoginFormPassword" name="password" class="form-control mb-4 col-md-5 ${requestScope.passwordIsValid}" placeholder="<fmt:message key="br.com.curriculumVSJ.Login.label.password"/>" required>
                    <div class="invalid-feedback">
                        <core:choose>
                            <core:when test="${requestScope.msgErrPasswordInCorrect}">
                                <fmt:message key="br.com.curriculumVSJ.Login.valid.password.incorrect"/>
                            </core:when>
                            <core:otherwise>
                                <fmt:message key="br.com.curriculumVSJ.Login.valid.password.invalid"/>
                            </core:otherwise>
                        </core:choose>
                    </div>
                </div>
                <!-- Login button -->
                <button class="btn btn-info btn-block my-10 col-md-5" type="submit"><fmt:message key="br.com.curriculumVSJ.Login.button.login"/></button>
            </div>
            
        </form>
        <!-- Default form login -->
        <br><br><br><br><br><br><br><br><br>
        <%@include file="import_footer.jspf"%>
        <%@include file="import_finalbodyscripts.jspf"%>
    </body>
</html>
