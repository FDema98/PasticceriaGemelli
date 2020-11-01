package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menutop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Menu</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:100,400,700\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/menutop.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"navbar\" id=\"myTopNav\">     \n");
      out.write("            <a href=\"home.jsp\">HOME</a>\n");
      out.write("            <a href=\"storia.jsp\">STORIA</a>\n");
      out.write("            <a href=\"shop.jsp\">SHOP</a>\n");
      out.write("            <a href=\"ordini.jsp\">ORDINI</a>\n");
      out.write("            <a href=\"doveSiamo.jsp\">DOVE SIAMO</a>\n");
      out.write("            <a href=\"contatti.jsp\">CONTATTI</a>\n");
      out.write("            <a id=\"logout\" href=\"../user?azione=logout\">LOGOUT</a>\n");
      out.write("            <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n");
      out.write("                <i class=\"fa fa-bars\"></i>\n");
      out.write("            </a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                var x = document.getElementById(\"myTopnav\");\n");
      out.write("                if (x.className === \"navbar\") {\n");
      out.write("                    x.className += \" responsive\";\n");
      out.write("                } else {\n");
      out.write("                    x.className = \"navbar\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
