package com.alex.utils;

import com.alex.VO.TaskVO;
import com.alex.entity.Task;
import com.alex.service.TaskService;
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
    public void testQueryAllShowTask(){
        Integer uid = 1;
        TaskServiceImpl t = new TaskServiceImpl();
        List<TaskVO> taskVOS = t.queryAllShowTask(uid);
        System.out.println(taskVOS);
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

    @Test
    public void saveOrUpdateTask(){
        //从数据库中获取task
        TaskService taskService = new TaskServiceImpl();
        Task task = taskService.queryTaskByProjectName(1, "p2").get(0);
        //将task转换成显示的taskVO
        TaskVO taskVO = new TaskVO();
        taskVO = (TaskVO) ReflectionUtils.copyProperties(task, taskVO);
        //模拟更新操作
        Task task2 = new Task();
        task2 = (Task) ReflectionUtils.copyProperties(taskVO, task2);
        task2.setEndTime("2019-12-13 14:50:59");
        System.out.println(task2);

        try {
            SqlBuilder.saveOrUpdate(task2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlBuilder.closeAll();
        }
    }

    @Test
    public void save(){
        Task task2 = new Task();
        task2.setTaskId(123);
        task2.setUid(1);

        try {
            SqlBuilder.saveOrUpdate(task2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlBuilder.closeAll();
        }
    }
}
