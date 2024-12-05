<%-- 
    Document   : account_update_successfully
    Created on : 5 Dec, 2024, 6:36:41 PM
    Author     : abhis
--%>

<%@page import="java.sql.*" %>
<%
    String accountNumber = request.getParameter("account_number");
    String action = request.getParameter("action");
    String amountStr = request.getParameter("amount");
    String message = "";

    if (accountNumber != null && action != null && amountStr != null) {
        double amount = Double.parseDouble(amountStr);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banky", "root", "");
            Statement stmt = con.createStatement();

            // Fetch current balance
            rs = stmt.executeQuery("SELECT balance FROM banky.account_opening WHERE account_number=" + accountNumber);
            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                // Update balance based on action
                if ("deposit".equals(action)) {
                    currentBalance += amount;
                    message = "Deposited ?" + amount + " successfully!";
                } else if ("withdraw".equals(action)) {
                    if (currentBalance >= amount) {
                        currentBalance -= amount;
                        message = "Withdrawn ?" + amount + " successfully!";
                    } else {
                        message = "Insufficient balance!";
                    }
                }

                // Update balance in database
                pstmt = con.prepareStatement("UPDATE banky.account_opening SET balance = ? WHERE account_number = ?");
                pstmt.setDouble(1, currentBalance);
                pstmt.setInt(2, Integer.parseInt(accountNumber));
                pstmt.executeUpdate();
            } else {
                message = "Account not found.";
            }
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Transaction Status</title>
</head>
<body>
    <h1><%= message %></h1>
    <a href="homepage.html?n1=<%= accountNumber%>">Back to Account</a>
</body>
</html>

