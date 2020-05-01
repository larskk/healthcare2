package control;

import data.Misc;
import data.TreatmentManager;
import data.UserManager;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "frontControl", urlPatterns = {"/frontControl"})

public class frontControl extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //request.getRequestDispatcher("minside.jsp").forward(request, response);
    String origin = request.getParameter("origin");

    switch (origin) {
      case "register":
        register(request, response);
        break;
      case "login":
        login(request, response);
        break;
      case "booktid":
        booktid(request, response);
        break;
      default: System.out.println("TEST");
    }
  }

  private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int roleID = Integer.parseInt(request.getParameter("role"));
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String pwd = request.getParameter("password");
    Boolean created = UserManager.createUser(firstName, lastName, pwd, email, phone, roleID);
    String message;
    if (created) {
      User user = new User(Misc.getRoleName(roleID), firstName, lastName, email, phone, pwd);
      message = "Kære " + user.getFirstName() + ", tak for din registrering!";
      request.getSession().setAttribute("user", user);
    } else {
      message = "Vi beklager, din registrering har desværre ikke kunnet behandles.";
    }
    request.setAttribute("message", message);
    //send to profile page
    request.getRequestDispatcher("minside.jsp").forward(request, response);
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    String message = "";
    String page2view;
    if (UserManager.validateUser(email, pwd)) {
      User user = UserManager.getUser(email);
      request.getSession().setAttribute("user", user);
      page2view = "minside.jsp";
      if (user.getRole().equalsIgnoreCase("Administrator")) {
        List<User> users = UserManager.getAllUsers();
        request.getSession().setAttribute("users", users);
      }
    } else {
      message = "Ukendt bruger eller password.";
      page2view = "login.jsp";
    }
    request.setAttribute("message", message);
    request.getRequestDispatcher(page2view).forward(request, response);
  }

  private void booktid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int TreatmentID = Integer.parseInt(request.getParameter("behandling"));
    String treatment = TreatmentManager.getName(TreatmentID);
    String date = request.getParameter("date-time");
    String message = "Du har booket en tid til " + treatment + " på følgende tidspunkt: " + date;
    request.setAttribute("message", message);
    request.getRequestDispatcher("minside.jsp").forward(request, response);

  }
}
