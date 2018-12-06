/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Exceptions.UserException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("changeorder", new ChangeOrder());
        commands.put("UpdateOrder", new UpdateOrder());
        commands.put("calculateorder", new CalculateOrder());
        commands.put("heightandlength", new HeightandLengths());
        commands.put("updatedatabase", new UpdateDatabase());
        commands.put("demos", new Demos());
        commands.put("createuser", new CreateUser());
        commands.put("pdf", new PDFRenderer());
        commands.put("gotocreateuser", new GoToCreateUser());
        commands.put("login", new GoToLoginPage());
        commands.put("employeepage", new GoToEmployeePage());
        commands.put("logout", new LogOut());
        //add methods here for the controller
    }
    

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws DataException, OrderException, UserException;

}
