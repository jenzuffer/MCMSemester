package PresentationLayer.Commands;

import PresentationLayer.Commands.Command;
import FunctionLayer.Exceptions.DataException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
public class LogOut extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
        request.getSession().invalidate();
        return "login";
    }

    
}
