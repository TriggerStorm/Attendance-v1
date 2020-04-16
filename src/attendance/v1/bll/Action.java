/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

/**
 *
 * @author macos
 */

public interface Action {

    void execute(String secretCode);

    void undo();

    String getName();
}
