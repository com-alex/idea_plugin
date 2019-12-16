package com.alex.action;


import com.alex.GUI.CustomDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author wsh
 * @date 2019-12-15
 */
public class SelectTaskPlugin extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
//        SelectTaskDialog taskDialog = new SelectTaskDialog();
//        taskDialog.setSize(500, 500);

        CustomDialog customDialog = new CustomDialog();
        customDialog.pack();
        customDialog.setSize(500, 500);

        customDialog.setVisible(true);
        System.exit(0);
    }
}
