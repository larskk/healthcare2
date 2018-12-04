package control;

import data.UserManager;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControl", urlPatterns = {"/frontControl"})
public class frontControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //request.getRequestDispatcher("minside.jsp").forward(request, response);
        String origin = request.getParameter("origin");

        switch (origin) {
            case "register":
                register(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String success = "message";
        User user = new User(role, firstName, lastName, email, phone, password);
        if (UserManager.createUser(user)) {
            success = "TRUE";
        } else {
            success = "FALSE";
        }
        request.setAttribute("message", success);
        //send to profile page
        request.getRequestDispatcher("minside.jsp").forward(request, response);
    }
}
