package PresentationLayer;

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
        String password1 = request.getParameter("password");
        String password2 = request.getParameter("passwordcheck");
        if (!password1.equals(password2)) {
            throw new LoginSampleException("Passwords does not match");
        }
        User user = new User(email, password1);
        request.getSession().setAttribute("user", user);
        
        return "navigator";
    }
}
