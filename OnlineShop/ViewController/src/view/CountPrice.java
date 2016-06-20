package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.DataAccess;

@WebServlet(name = "CountPrice", urlPatterns = { "/countprice" })
public class CountPrice extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

   

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        int age = Integer.parseInt(request.getParameter("age"));
        int price = 0;
       // String method = request.getMethod();
       System.out.println(age);
        //DataAccess da = new DataAccess(); //??????????? DONT NEED DB!!!!!!!!!!!!!!!!!!!!!
       // int checkAge  = da.checkAge(age);//
       
        if (((age < 10) && (age >= 0)) || (age > 60)) {
                price = 0;
                out.println("The ticket is free: $" +price);    //Under age 10 and over 60 is free
                       
        }else if ((age >= 10) && (age <= 60)) {                    // Equal sign???????
                price = 20;
                out.println("The ticket is: $" +price);         //Between age 10 - 60 -> Price $20
        }else {
                out.println("Invalid age.");                    // Under age 0 -> Invalid age
        }
        
        
        out.println("<html>");
        out.println("<head><title>CountPrice</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }
}
