package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataAccess;

@WebServlet(name = "Authenticate", urlPatterns = { "/authenticate" })
public class AuthenticateServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
                PrintWriter out = response.getWriter();
                String name = request.getParameter("fname");
                String psw = request.getParameter("password");
                String method = request.getMethod();
                
         
                 
                // get Employees from DB 
                System.out.println("got to servlet ");
                DataAccess da = new DataAccess();
                boolean authenticated  = da.authenticate(name, psw);
                
                if (authenticated){
            
                    out.println("welcome "+name);  
               
                      
                    //request.getRequestDispatcher("Menu.html").forward(request, response);
                    request.getRequestDispatcher("Menu.html").include(request, response);
                }else{
                    out.println("<html>");
                    out.println("<head><title>KatiServlet</title></head>");
                    out.println("<body bgcolor = \"red\">");
                    out.println("<p>Athentication failure try logging on again, or sign up if you are not a registered user.</p>");
                    request.getRequestDispatcher("Logon.html").include(request, response);
                }
                

                
                out.println("</body></html>");
                out.close();
            }
}
