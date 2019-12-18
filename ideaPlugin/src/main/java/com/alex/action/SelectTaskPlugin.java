package com.alex.action;


import com.alex.GUI.SelectTaskDialog;
import com.alex.utils.GUIUtils;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.awt.*;

/**
 * @author wsh
 * @date 2019-12-15
 */
public class SelectTaskPlugin extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Integer width = 1200;
        Integer height = 500;
        SelectTaskDialog selectTaskDialog = new SelectTaskDialog();
        selectTaskDialog.pack();
        selectTaskDialog.setBounds(GUIUtils.getCenterX(width), GUIUtils.getCenterY(height), width, height);
        selectTaskDialog.setVisible(true);

    }
}
