package com.alex.utils;


import com.alex.VO.TaskVO;
import com.alex.annotation.Table;
import com.alex.entity.Task;
import com.alex.entity.User;
import com.alex.service.TaskService;
import com.alex.service.impl.TaskServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2019-12-09
 */


public class ReflectionTest {

    @Test
    public void test(){
        Integer uid = 1;
        String username = "alex";
        String password = "123456";
        List<Object> params1 = new ArrayList<Object>();
        params1.add(uid);
        params1.add(username);
        params1.add(password);
        List<Object> params2 = new ArrayList<Object>();
        params2.add(uid);
        params2.add(username);
        params2.add(password);
        List<Object> params3 = new ArrayList<Object>();
        params3.add(uid);
        params3.add(username);
        params3.add(password);
        List<List<Object>> fieldsGroup = new ArrayList<List<Object>>();
        fieldsGroup.add(params1);
        fieldsGroup.add(params2);
        fieldsGroup.add(params3);

        ReflectionUtils.createObjects(User.class, fieldsGroup);

    }

    @Test
    public void testGet(){
        User user = new User(15, "alex123123", "123");
        List<Object> objects = ReflectionUtils.getObjectParams(user);
        System.out.println(objects);
    }


    @Test
    public void testGetAnno() {

       Class<User> userClass = User.class;
       Table table = userClass.getAnnotation(Table.class);
        System.out.println(table.tableName());

//        boolean hasAnnotation = Test.class.isAnnotationPresent(Table.class);
//        System.out.println(hasAnnotation);
//        if (hasAnnotation) {
//            Table table = Test.class.getAnnotation(Table.class);
//            //获取类的注解
//            System.out.println(table.tableName());
//
//        }
    }


    @Test
    public void testGetFieldAnno(){
        User user = new User();
        List<String> attributeAnnotations = ReflectionUtils.getAttributeAnnotations(user);
        System.out.println(attributeAnnotations);
    }



    @Test
    public void testGetObjectParams(){
        TaskService taskService = new TaskServiceImpl();
        List<TaskVO> taskVOS = taskService.queryAllShowTask(1);
        TaskVO taskVO = taskVOS.get(0);
        System.out.println(taskVO);
        List<Object> params = ReflectionUtils.getObjectParams(taskVO);
        System.out.println(params);
    }

    @Test
    public void testCopyProperties(){
        TaskService taskService = new TaskServiceImpl();
        Task task = taskService.queryTaskByProjectName(1, "p2").get(0);
        TaskVO taskVO = new TaskVO();
        taskVO = (TaskVO) ReflectionUtils.copyProperties(task, taskVO);
        Task task2 = new Task();
        task2 = (Task) ReflectionUtils.copyProperties(taskVO, task2);
        System.out.println(task2);
    }

    @Test
    public void testGetPrimaryKey(){
        System.out.println(ReflectionUtils.getPrimaryKeyAttributeName(Task.class));
    }

    @Test
    public void testCreateObject(){
        List<Object> param = new ArrayList<>();
        param.add(1);
        param.add("t1");
        param.add("p1");
        param.add(1);
        param.add("develop");
        param.add("2019-12-12 14:50:59");
        param.add("2019-12-12 14:50:59");
        param.add("2019-12-12 14:50:59");
        TaskVO selectedTaskVO = (TaskVO) ReflectionUtils.createObject(TaskVO.class, param);
        System.out.println(selectedTaskVO);
    }
}
