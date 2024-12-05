<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Account Details</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background: url('hospital5.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 35px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .title {
            text-align: center;
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-reset {
            background-color: #6c757d;
        }

        .btn-reset:hover {
            background-color: #5a6268;
        }

        .message {
            font-size: 16px;
            color: #28a745;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>
<%
    String account_num = request.getParameter("n1");
    int account_number = Integer.parseInt(account_num);

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banky", "root", "");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM banky.account_opening WHERE account_number=" + account_number);

    boolean accountExists = rs.next();
    String message = "";
    if (accountExists) {
        int currentBalance = rs.getInt(15); // Assuming balance is in the 15th column
%>
<div class="container">
    <h2 class="title">Manage Account</h2>

    <!-- Account Details -->
    <div class="form-group">
        <label>Account Number</label>
        <input type="text" readonly value="<%= rs.getInt(1) %>">
    </div>
    <div class="form-group">
        <label>Account Holder Name</label>
        <input type="text" readonly value="<%= rs.getString(2) %>">
    </div>
    <div class="form-group">
        <label>Current Balance</label>
        <input type="text" readonly value="₹<%= currentBalance %>">
    </div>

    <!-- Deposit and Withdraw Form -->
    <form method="post" action="account_update_successfully.jsp">
        <input type="hidden" name="account_number" value="<%= rs.getInt(1) %>">
        <div class="form-group">
            <label for="amount">Enter Amount</label>
            <input type="number" name="amount" id="amount" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="action">Select Action</label>
            <select name="action" id="action" required>
                <option value="deposit">Deposit</option>
                <option value="withdraw">Withdraw</option>
            </select>
        </div>
        <button type="submit" class="btn">Submit</button>
    </form>

    <div class="message"><%= message %></div>
</div>
<%
    } else {
        message = "Account not found.";
    }
%>
</body>
</html>
