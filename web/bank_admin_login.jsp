<%-- 
    Document   : bank_admin_login
    Created on : 5 Dec, 2024, 4:14:10 PM
    Author     : abhis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin login - Rathod Multispeciality Health Clinic</title>
    </head>
    <body>
         <%
         String uname=request.getParameter("n1");
         String pass=request.getParameter("n2");
         if((uname.equals("admin"))&&(pass.equals("admin123")))
         {
         response.sendRedirect("homepage.html");
         }
         else   
         {
         response.sendRedirect("bank_admin_login.html");
         }
        %>
    </body>
</html>

