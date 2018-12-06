package PresentationLayer;

import FunctionLayer.Exceptions.DataException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
public class GoToCreateUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
        return "createuser";
    }
    
}
