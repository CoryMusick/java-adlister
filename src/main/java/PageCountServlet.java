import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
    @WebServlet(name = "PageCountServlet", urlPatterns = "/count")
    public class PageCountServlet extends HttpServlet {
        int count = 0;

        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
            count += 1;
            res.setContentType("text/html");
            PrintWriter output = res.getWriter();


            String action = req.getParameter("action");
            if (action != null && action.equals("reset") ) {
                count = 0;
            }

            output.println("<h1>" + count + "</h1>");
        }
    }