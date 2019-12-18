package com.alex.GUI.Modal;

import com.alex.GUI.component.DateChooserJButton;
import com.alex.VO.TaskVO;
import com.alex.utils.GUIUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wsh
 * @date 2019-12-17
 * 设置开始时间与结束时间的模态框
 */
public class SetTimeModal extends JFrame {
    //常量，防止出现魔法值
    private static final String SET_START_TIME_MODAL = "start";
    private static final String SET_END_TIME_MODAL = "end";

    private JDialog jDialog;
    private TaskVO taskVO;
    private String flag;
    private JPanel timePanel;
    private JLabel timeLabel;
    private DateChooserJButton dateChooserJButton;
    private JButton okButton;
    private JButton cancelButton;

    public SetTimeModal(){
        timePanel = new JPanel();
        timePanel.setBounds(0, 0, 300, 150);
        timePanel.setLayout(null);
        timeLabel = new JLabel("Start Time:");
        timeLabel.setBounds(50,0, 100, 100);
        timePanel.add(timeLabel);

        dateChooserJButton = new DateChooserJButton();
        dateChooserJButton.setBounds(120, 38, 150, 25);
        timePanel.add(dateChooserJButton);

        okButton = new JButton("ok");
        okButton.setBounds(85, 90, 50, 30);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 时间设置
                //1. 获取设置的时间
                //2. 更新数据库
            }
        });

        cancelButton = new JButton("cancel");
        cancelButton.setBounds(170, 90, 60, 30);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        timePanel.add(okButton);
        timePanel.add(cancelButton);
        this.add(timePanel);
        this.pack();
        this.setBounds(GUIUtils.getCenterX(300), GUIUtils.getCenterY(150), 300, 150);
        this.setVisible(true);
    }
    public SetTimeModal(String flag, JDialog dialog, TaskVO taskVO){
        this();
        this.taskVO = taskVO;
        this.jDialog = dialog;
        this.flag = flag;
        if(this.flag.indexOf(SET_START_TIME_MODAL) > -1){
            timeLabel.setText("Start Time:");
        }
        else{
            timeLabel.setText("End Time:");
        }

    }

    private void onCancel(){
        this.setVisible(false);
        this.jDialog.setVisible(true);
    }
}
