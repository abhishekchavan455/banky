<%-- 
    Document   : account_opening_registration_form
    Created on : 5 Dec, 2024, 1:51:51 PM
    Author     : abhis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add doctor - Rathod Multispeciality Health Clinic</title>
    </head>
    <body>
       <%
         String fname=request.getParameter("fname");
         String email=request.getParameter("email");
         String cont=request.getParameter("contact");
         int contact=Integer.parseInt(cont);
         String date=request.getParameter("date");
         String gender=request.getParameter("gender");
         String city=request.getParameter("city");
         String state=request.getParameter("state");
         String pin=request.getParameter("pincode");
         int pincode=Integer.parseInt(pin);
         String occupation=request.getParameter("occupation");
         String nationality=request.getParameter("nationality");
         String account_type=request.getParameter("account_type");
         String id_proof=request.getParameter("id");
         String id_num=request.getParameter("id_number");
         int id_number=Integer.parseInt(id_num);
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://@localhost:3306/banky","root","");
         Statement stmt=con.createStatement();
         int result=stmt.executeUpdate("insert into banky.account_opening (fname,email,contact,date,gender,city,state,pincode,occupation,nationality,account_type,id_proof,id_number) values('"+fname+"','"+email+"',"+contact+",'"+date+"','"+gender+"','"+city+"','"+state+"',"+pincode+",'"+occupation+"','"+nationality+"','"+account_type+"','"+id_proof+"',"+id_number+")");
         if(result>0)                                     
         {                                                                        
         out.println("account open successfully");
         }
        %> 
    </body>
</html>



