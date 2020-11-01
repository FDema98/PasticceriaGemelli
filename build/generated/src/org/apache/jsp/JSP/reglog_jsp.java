package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reglog_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Pasticceria Gemelli - Login</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:100,400,700\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"icon\" href=\"../IMAGE/sweet.ico\" type=\"image/x-icon\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../IMAGE/sweet.ico\" type=\"image/x-icon\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/reglog.css\">     \n");
      out.write("        <!-- IMPORT DI JQUERY -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p id=\"login-register__error\" class=\"animatedBounceIn\"></p>\n");
      out.write("        <div id =\"login\" class=\"login-register__form animatedBounceIn\">\n");
      out.write("            <form action=\"../user?azione=login\" method=\"POST\">\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\" required=\"required\">\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\" required=\"required\"><br>\n");
      out.write("                <input type=\"submit\">\n");
      out.write("                <p class=\"login-register__change\">Non hai un account? <a class=\"register__link\" href=\"\">Registrati</a></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id =\"register\" class=\"login-register__form invisible animatedBounceIn\">\n");
      out.write("            <p id=\"login-register__error\"></p>\n");
      out.write("            <form action=\"../user?azione=register\" method=\"POST\">\n");
      out.write("                <input type=\"text\" name=\"nome\" placeholder=\"Nome\" required=\"required\">\n");
      out.write("                <input type=\"text\" name=\"cognome\" placeholder=\"Cognome\" required=\"required\">\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\" required=\"required\">\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\" required=\"required\"><br>\n");
      out.write("                <input type=\"submit\">\n");
      out.write("                <p class=\"login-register__change\">Hai gia un account? <a class=\"login__link\" href=\"\">Login</a></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function getUrlVars() {\n");
      out.write("                var vars = {};\n");
      out.write("                var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {\n");
      out.write("                    vars[key] = value;\n");
      out.write("                });\n");
      out.write("                return vars;\n");
      out.write("            }\n");
      out.write("            var failed = getUrlVars()[\"failed\"];\n");
      out.write("            if (failed === \"reg\") {\n");
      out.write("                $(\"#register\").toggleClass(\"invisible\");\n");
      out.write("                $(\"#login\").toggleClass(\"invisible\");\n");
      out.write("                document.getElementById(\"login-register__error\").innerHTML = \"Username gia utilizzato\";\n");
      out.write("            }\n");
      out.write("            if (failed === \"log\") {\n");
      out.write("                document.getElementById(\"login-register__error\").innerHTML = \"Username o password errati\";\n");
      out.write("            }\n");
      out.write("            //I link ricaricano la pagina automaticamente\n");
      out.write("            $(\".login__link\").click(function (e) {\n");
      out.write("                //Evita di far ricaricare la pagina e perdere i toggle avvenuti in precedenza\n");
      out.write("                e.preventDefault();\n");
      out.write("                $(\"#register\").toggleClass(\"invisible\");\n");
      out.write("                $(\"#login\").toggleClass(\"invisible\");\n");
      out.write("            });\n");
      out.write("            $(\".register__link\").click(function (e) {\n");
      out.write("                //Evita di far ricaricare la pagina e perdere i toggle avvenuti in precedenza\n");
      out.write("                e.preventDefault();\n");
      out.write("                $(\"#login\").toggleClass(\"invisible\");\n");
      out.write("                $(\"#register\").toggleClass(\"invisible\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
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
