/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import java.util.Stack;


/**
 *
 * @author macos
 */
public class CommandManager {

    private final Stack<Action> undoStack;
    private final Stack<Action> redoStack;
    private static CommandManager instance = null;
    private CommandManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    public static CommandManager getInstance()
    {
        if(instance == null)
        {
            instance = new CommandManager();
        }
        
        return instance;
    }

    public void execute(Action cmd,String code) {
        undoStack.push(cmd);
        redoStack.clear();
        cmd.execute(code);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Action cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        Action cmd = redoStack.pop();
        undoStack.push(cmd);

    }
}

  

   


