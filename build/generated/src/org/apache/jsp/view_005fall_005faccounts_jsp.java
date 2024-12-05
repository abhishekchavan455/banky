package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public final class view_005fall_005faccounts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>view appointment booking</title>\n");
      out.write("        <style>\n");
      out.write("        table {\n");
      out.write("            font-size: 18px;\n");
      out.write("            font-style: bold;\n");
      out.write("            width: 80%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 12px 15px;\n");
      out.write("            text-align: left;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        tr:hover {\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("            #searchInput {\n");
      out.write("        width: 70%;\n");
      out.write("        padding: 10px;\n");
      out.write("        margin: 10px 0;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        border-radius: 4px;\n");
      out.write("        box-shadow: inset 1px 1px 2px rgba(0, 0, 0, 0.1);\n");
      out.write("        font-size: 16px;\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Style for the search input placeholder text */\n");
      out.write("    #searchInput::placeholder {\n");
      out.write("        color: #999;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("      body {\n");
      out.write("            background: url(\"hospital2.jpg\");\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-attachment: fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("        <body bgcolor=\"yellow\">\n");
      out.write("         ");

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://@localhost:3306/banky","root","");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from banky.account_opening");
        
      out.write("\n");
      out.write("        <h1>View All Account Details</h1>\n");
      out.write("        <table border=2px>\n");
      out.write("        <tr>\n");
      out.write("        <th>Account Number</th>\n");
      out.write("        <th>Account Holder Name/th>\n");
      out.write("        <th>Contact Number</th>\n");
      out.write("        <th>Date Of Birth</th>\n");
      out.write("        <th>Gender</th>\n");
      out.write("        <th>Address</th>\n");
      out.write("        <th>City</th>\n");
      out.write("        <th>State</th>\n");
      out.write("        <th>Pincode</th>\n");
      out.write("        <th>Occupation</th>\n");
      out.write("        <th>Nationality</th>\n");
      out.write("        <th>Account Type</th>\n");
      out.write("        <th>Id Proof</th>\n");
      out.write("        <th>Id Proof Number</th>\n");
      out.write("        </tr>   \n");
      out.write("        ");

        while(rs.next())
        {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("        <td>");
      out.print(rs.getInt(1));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(6));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(7));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(8));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getInt(9));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(10));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(11));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(12));
      out.write("</td>    \n");
      out.write("        <td>");
      out.print(rs.getString(13));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
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
