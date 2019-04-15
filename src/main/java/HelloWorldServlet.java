import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        res.setContentType("text/html");
        PrintWriter output = res.getWriter();
        output.println("<h1>Hello, "+name+"</h1>");
    }
}
