<%-- 
    Document   : view_all_accounts
    Created on : 5 Dec, 2024, 3:18:08 PM
    Author     : abhis
--%>


<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view appointment booking</title>
        <style>
        table {
            font-size: 18px;
            font-style: bold;
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
            #searchInput {
        width: 70%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: inset 1px 1px 2px rgba(0, 0, 0, 0.1);
        font-size: 16px;
        font-weight: bold;
    }

    /* Style for the search input placeholder text */
    #searchInput::placeholder {
        color: #999;
    }
    
      body {
            background: url("bank8.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
    
    </head>
        <body bgcolor="yellow">
         <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://@localhost:3306/banky","root","");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from banky.account_opening");
        %>
        <h1>View All Account Details</h1>
        <table border=2px>
        <tr>
        <th>Account Number</th>
        <th>Account Holder Name</th>
        <th>Contact Number</th>
        <th>Date Of Birth</th>
        <th>Gender</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pincode</th>
        <th>Occupation</th>
        <th>Nationality</th>
        <th>Account Type</th>
        <th>Id Proof</th>
        <th>Id Proof Number</th>
        </tr>   
        <%
        while(rs.next())
        {
        %>
        <tr>
        <td><%=rs.getInt(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=rs.getString(5)%></td>
        <td><%=rs.getString(6)%></td>
        <td><%=rs.getString(7)%></td>
        <td><%=rs.getString(8)%></td>
        <td><%=rs.getInt(9)%></td>
        <td><%=rs.getString(10)%></td>
        <td><%=rs.getString(11)%></td>
        <td><%=rs.getString(12)%></td>    
        <td><%=rs.getString(13)%></td>
        <td><%=rs.getInt(14)%></td>
        </tr>
        <%
            }
        %>
        </table>
    </body>
</html>

