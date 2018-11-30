/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
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
        commands.put("updateorder", new UpdateOrder());
        commands.put("calculateorder", new CalculateOrder());
        commands.put("heightandlength", new HeightandLengths());
        commands.put("updatedatabase", new UpdateDatabase());
        commands.put("demos", new Demos());
        commands.put("createuser", new CreateUser());
        commands.put("pdf", new PDFRenderer());
        commands.put("gotocreateuser", new GoToCreateUser());
        commands.put("login", new GoToLoginPage());
         commands.put("employeepage", new GoToEmployeePage());
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
            throws LoginSampleException;

}
