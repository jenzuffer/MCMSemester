package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
public class CreateUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("firstpassword");
        String password2 = request.getParameter("secondpassword");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        if (!password1.equals(password2)) {
            throw new LoginSampleException("Passwords does not match");
        }
        User user = new User(email, password1);
        request.getSession().setAttribute("user", user);
        LogicFacade.createUser(user);
        return "navigator";
    }
}
