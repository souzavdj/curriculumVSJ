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
        <form class="text-center border border-light p-5">
            <div align="center">
                <!-- Email -->
                <input type="email" id="defaultLoginFormEmail" class="form-control mb-4 col-md-5" placeholder="<fmt:message key="br.com.curriculumVSJ.Login.label.email"/>">
                
                <!-- Password -->
                <input type="password" id="defaultLoginFormPassword" class="form-control mb-4 col-md-5" placeholder="<fmt:message key="br.com.curriculumVSJ.Login.label.password"/>">

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
