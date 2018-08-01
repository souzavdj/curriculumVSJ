<%-- 
    Document   : Error
    Created on : 31/07/2018, 20:02:17
    Author     : vinicius
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="import_head.jspf"%>
        <title><fmt:message key="br.com.curriculumVSJ.Error.title"/></title>
    </head>
    <body>
        <%@include file="import_navbar.jspf"%>
        <br><br>
        <h1 align="center" class="col-sm-auto"><b><fmt:message key="br.com.curriculumVSJ.Error.subtitle"/></b></h1>
        <br>
        <div data-spy="scroll" class="scrollspy-example z-depth-1 mt-4" data-offset="0">
            <br>
            <h3 class="text-center col-sm-auto"><b>${requestScope.error}</b></h3>
            <br><br>
            <ol>
                <core:forEach items="${requestScope.msgError}" var="msg" varStatus="status">
                    <li class="text-justify col-md-auto">${msg}</li>
                </core:forEach>
            </ol>
        </div>
        <%@include file="import_footer.jspf"%>
        <%@include file="import_finalbodyscripts.jspf"%>
    </body>
</html>
