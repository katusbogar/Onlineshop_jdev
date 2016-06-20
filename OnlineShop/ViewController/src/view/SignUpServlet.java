package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.DataAccess;

@WebServlet(name = "SignUpServlet", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String psw = request.getParameter("password");
        String method = request.getMethod();
        
        System.out.println("got to servlet ");
        DataAccess da = new DataAccess();
        boolean insertOk  = da.signUp(name, psw);
        
        
        if (insertOk){
            out.println("<html>");
            out.println("<head><title>KatiServlet</title></head>");
            out.println("<body bgcolor = \"blue\">");
            //System.out.println("got here");
            out.println("<p>Sign up successful!</p>");
            // Navigation where to go.
            request.getRequestDispatcher("Logon.html").include(request, response);
        }else{
            out.println("<html>");
            out.println("<head><title>KatiServlet</title></head>");
            out.println("<body bgcolor = \"red\">");
            out.println("<p>Username is already exists. Try signing up again.</p>");
            request.getRequestDispatcher("Signup.html").include(request, response);
        }
        

        
        out.println("</body></html>");
        out.close();
    
    }
}
