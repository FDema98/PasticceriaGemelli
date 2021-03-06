package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gestioneprodotti.Prodotto;
import gestioneutente.SessioneUtente;
import java.util.ArrayList;
import gestioneordini.Ordine;

public final class ordini_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/JSP/menutop.jsp");
    _jspx_dependants.add("/JSP/footer.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/ordini.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css\" />\n");
      out.write("        <title>Ordini</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"menutop\">");
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
      out.write("        <div class=\"navbar\" id=\"myTopNav\">    \n");
      out.write("            <div class=\"navbarCont\">\n");
      out.write("            <a class=\"item underline\" href=\"home.jsp\">HOME</a>\n");
      out.write("            <a class=\"item\" href=\"storia.jsp\">STORIA</a>\n");
      out.write("            <a class=\"item\" href=\"shop.jsp\">SHOP</a>\n");
      out.write("            <a class=\"item\" href=\"ordini.jsp\">ORDINI</a>\n");
      out.write("            <a class=\"item\" href=\"doveSiamo.jsp\">DOVE SIAMO</a>\n");
      out.write("            <a class=\"item\" href=\"contatti.jsp\">CONTATTI</a>\n");
      out.write("            <a class=\"item\" id=\"logout\" href=\"../user?azione=logout\">LOGOUT</a>\n");
      out.write("            <a href=\"javascript:void(0);\" class=\"icon underline\" onclick=\"myFunction()\">\n");
      out.write("                <i class=\"fa fa-bars\"></i>\n");
      out.write("            </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                var x = document.getElementById(\"myTopNav\");\n");
      out.write("                if (x.className === \"navbar\") {\n");
      out.write("                    x.className += \" responsive\";\n");
      out.write("                } else {\n");
      out.write("                    x.className = \"navbar\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("</div>\n");
      out.write("        <div id=\"main\">\n");
      out.write("                ");
 if (request.getSession().getAttribute("usernameLog") == null) {
                        response.sendRedirect("reglog.jsp");
                        return;
                    }
                    SessioneUtente su = (SessioneUtente) request.getSession().getAttribute("Utente");
                    if (su == null) {
                        response.sendRedirect(request.getContextPath() + "/reglog.jsp");
                    } else {
                        ArrayList<Ordine> lista = (ArrayList<Ordine>) request.getSession().getAttribute("orisultato");
                        if (lista == null) {
                            System.out.println("Lista Ordini non trovata");
                            response.sendRedirect("/OrdiniServlet?azione=stampaOrdini");
                            return;
                        } else {
                            request.getSession().removeAttribute("orisultato");
                            
      out.write("<div class=\"ordiniContainer\">");

                            if (!lista.isEmpty()) {
                                for (Ordine x : lista) {
                                    float tot = 0;
                                    if (su.isAdmin() || request.getSession().getAttribute("usernameLog").equals(x.getUsername())){
                                    
      out.write("\n");
      out.write("                                    <div class=\"ordine\">           \n");
      out.write("                    <div class=\"ordineUtente\">");
      out.print(x.getUsername());
      out.write("#0000");
      out.print(x.getId());
      out.write("</div>\n");
      out.write("                    ");
for (Prodotto y : x.getLista()) {
                        tot += y.getPrezzo()*y.getQuantita();
      out.write("\n");
      out.write("                        <div class=\"ordineInfo\">");
      out.print(y.getQuantita());
      out.write("x <a href=\"../ProdottiServlet?azione=visualizzaProdotto&id=");
      out.print(y.getId());
      out.write('"');
      out.write('>');
      out.print(y.getNome());
      out.write("</a> - €");
      out.print(String.format("%.2f", y.getPrezzo()));
      out.write("</div>         \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <div class=\"ordineTot\">TOTALE: <b>€");
      out.print(String.format("%.2f", tot));
      out.write("</b></div>\n");
      out.write("            </div> ");

                                    }
                                }
      out.write("\n");
      out.write("            ");
} else {
      out.write("              \n");
      out.write("            <p class=\"errorRicerca\">Nessun ordine in database</p>\n");
      out.write("                    ");
}
                    }
                    }
            
      out.write(" \n");
      out.write("                                    </div>\n");
      out.write("                                    </div>\n");
      out.write("    <div id=\"footer\">");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Footer</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:100,400,700\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/footer.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"riga\">\n");
      out.write("            <div class=\"colonna\">\n");
      out.write("                <h3>PASTICCERIA</h3>\n");
      out.write("                <div class=\"info\">Minori (SA)</br> Via Roma, 80, 84010</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"colonna\">\n");
      out.write("                <h3>APERTURA</h3>\n");
      out.write("                <div class=\"info\">Chiuso il martedì</br>\n");
      out.write("                Domenica 7:00 - 13:00</br>\n");
      out.write("                Altri giorni 7:00 - 23:00</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"colonna\">\n");
      out.write("                <h3>CONTATTI</h3>\n");
      out.write("                <div class=\"info\">e-mail: pasticceriagemelli@sweet.it</br>\n");
      out.write("                    telefono: 089 561 4780</br>\n");
      out.write("                    <a href=\"#\" class=\"fa fa-instagram\"></a>\n");
      out.write("                    <a href=\"#\" class=\"fa fa-facebook\"></a>\n");
      out.write("                    <a href=\"#\" class=\"fa fa-twitter\"></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("</div>\n");
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
