package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class cash_005fwithdraw_005fdeposite_005fby_005faccount_005fnumber_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    String dbURL = "jdbc:mysql://localhost:3306/bank_db";
    String dbUser = "root"; // Replace with your MySQL username
    String dbPassword = "password"; // Replace with your MySQL password

    String accountNumber = request.getParameter("accountNumber");
    String action = request.getParameter("action");
    String amountStr = request.getParameter("amount");
    String message = "";
    double balance = 0.0;
    String accountHolderName = "";

    if (accountNumber != null && action != null && amountStr != null) {
        double amount = Double.parseDouble(amountStr);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // Get current balance and account holder's name
            String query = "SELECT name, balance FROM banky.account_opening WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(accountNumber));
            rs = pstmt.executeQuery();

            if (rs.next()) {
                accountHolderName = rs.getString("name");
                balance = rs.getDouble("balance");

                // Handle deposit
                if ("deposit".equals(action)) {
                    balance += amount;
                    message = "Deposited ₹" + amount + " successfully!";
                } 
                // Handle withdrawal
                else if ("withdraw".equals(action)) {
                    if (balance >= amount) {
                        balance -= amount;
                        message = "Withdrawn ₹" + amount + " successfully!";
                    } else {
                        message = "Insufficient balance!";
                    }
                }

                // Update the balance in the database
                query = "UPDATE banky.account_opening SET balance = ? WHERE id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setDouble(1, balance);
                pstmt.setInt(2, Integer.parseInt(accountNumber));
                pstmt.executeUpdate();
            } else {
                message = "Account not found!";
            }
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Bank Transaction</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Bank Transaction for ");
      out.print( accountHolderName );
      out.write(" (Account No: ");
      out.print( accountNumber );
      out.write(")</h1>\n");
      out.write("\n");
      out.write("    <!-- Display current balance -->\n");
      out.write("    <p><strong>Current Balance: ₹");
      out.print( balance );
      out.write("</strong></p>\n");
      out.write("\n");
      out.write("    <!-- Transaction form -->\n");
      out.write("    <form method=\"post\" action=\"transactionPage.jsp\">\n");
      out.write("        <input type=\"hidden\" name=\"accountNumber\" value=\"");
      out.print( accountNumber );
      out.write("\">\n");
      out.write("        <label for=\"amount\">Amount:</label>\n");
      out.write("        <input type=\"number\" name=\"amount\" step=\"0.01\" required>\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        <button type=\"submit\" name=\"action\" value=\"deposit\">Deposit</button>\n");
      out.write("        <button type=\"submit\" name=\"action\" value=\"withdraw\">Withdraw</button>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <p><strong>");
      out.print( message );
      out.write("</strong></p>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
