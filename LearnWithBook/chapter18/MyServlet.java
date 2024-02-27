package LearnWithBook.chapter18;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = "Servlet is working";

        out.println("<HTML><BODY>");
        out.println("<H1> + message + </H1>");
        out.println("</HTML></BODY>");
        out.close();
    }

}
