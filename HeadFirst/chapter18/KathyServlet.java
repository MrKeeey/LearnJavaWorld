package HeadFirst.chapter18;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class KathyServlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = "Phrase of day";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML><HEAD><TITLE>");
        out.println("RandomPhrase");
        out.println("</title></head><body>");
        out.println("<H1>" + title + "</H1>");
        out.println("<P>" + RandomPhrase.makePhrase());
        out.println("<p><a href=\"KathyServlet\"> Create new phrase </a></p>");
        out.println("</body></html>");
        out.close();

    }

}
