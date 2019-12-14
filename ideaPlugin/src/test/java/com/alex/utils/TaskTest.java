package com.alex.utils;

import com.alex.entity.Task;
import com.alex.service.impl.TaskServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: JIN KE
 * @Date: 2019/12/11 17:47
 */
public class TaskTest {
    @Test
    public void displayAllTaskTest(){
        Integer uid =1;
        TaskServiceImpl t=new TaskServiceImpl();
        List<Task> taskList = t.displayAllTask(uid);
        for(Task task : taskList){
            System.out.println(task);
        }
    }
    @Test
    public void filterTaskByProjectTest(){
        Integer uid =1;
        String  project="p6";
        TaskServiceImpl t=new TaskServiceImpl();
        List<Task> taskList = t.queryTaskByProjectName(uid,project);
        System.out.println(taskList);
    }
    @Test
    public void filterTaskByTaskTypeTest(){
        Integer uid = 3;
        String taskType = "develop";
        TaskServiceImpl t=new TaskServiceImpl();
        List<Task> taskList = t.queryTaskByTaskType(uid,taskType);
        System.out.println(taskList);
    }
    @Test
    public void filterTaskByTaskPriorityTest(){
        Integer uid = 3;
        Integer taskPriority=1;
        TaskServiceImpl t=new TaskServiceImpl();
        List<Task> taskList = t.queryTaskByTaskPriority(uid,taskPriority);
        System.out.println(taskList);
    }

    @Test
    public void sortTaskWithProjectTest(){
        TaskServiceImpl t=new TaskServiceImpl();
        Integer uid =1;
        List<Task> taskList = t.sortTaskWithProjectName(t.displayAllTask(uid));
        SortUtils.printfTaskInfoList(taskList);
    }
    @Test
    public void sortTaskWithTaskTypeTest(){
        TaskServiceImpl t=new TaskServiceImpl();
        Integer uid =1;
        List<Task> taskList = t.sortTaskWithTaskType(t.displayAllTask(uid));
        SortUtils.printfTaskInfoList(taskList);
    }

    @Test
    public void sortTaskWithTaskPriorityTest(){
        TaskServiceImpl t=new TaskServiceImpl();
        Integer uid =1;
        List<Task> taskList = t.sortTaskWithTaskPriority(t.displayAllTask(uid));
        SortUtils.printfTaskInfoList(taskList);
    }
    @Test
    public void sortTaskWithDueTimeTest(){
        TaskServiceImpl t=new TaskServiceImpl();
        Integer uid =1;
        List<Task> taskList = t.sortTaskWithDueTime(t.displayAllTask(uid));
        SortUtils.printfTaskInfoList(taskList);
    }
}
