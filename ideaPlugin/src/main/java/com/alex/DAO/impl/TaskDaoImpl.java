package com.alex.DAO.impl;

import com.alex.DAO.TaskDao;
import com.alex.entity.Task;
import com.alex.utils.SqlBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: JIN KE
 * @Date: 2019/12/11 10:19
 */
public class TaskDaoImpl implements TaskDao {

    @Override
    public List<Task> queryAllTask(Integer uid) {
        List<Task>  tasks=new ArrayList<>();
        SqlBuilder sqlBuilder = SqlBuilder.getInstance();
        sqlBuilder.select("*")
                .from("task_info")
                .where()
                .addEqualTo("uid",uid);
        try {
            tasks = (List<Task>) sqlBuilder.createQuery(sqlBuilder.getSql(), sqlBuilder.getParams(), Task.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            SqlBuilder.closeAll();
        }
        return tasks;
    }

    @Override
    public  List<Task> queryTaskByProjectName(Integer uid, String projectName) {
        List<Task> tasks =new ArrayList<>();
        SqlBuilder sqlBuilder = SqlBuilder.getInstance();
        sqlBuilder.select("*")
                .from("task_info")
                .where()
                .addEqualTo("uid",uid)
                .addEqualTo("project_name",projectName);
        try {
            tasks = (List<Task>) sqlBuilder.createQuery(sqlBuilder.getSql(), sqlBuilder.getParams(), Task.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            SqlBuilder.closeAll();
        }
        return tasks;
    }

    @Override
    public List<Task> queryTaskByTaskType(Integer uid, String TaskType) {
        List<Task> tasks =new ArrayList<>();
        SqlBuilder sqlBuilder = SqlBuilder.getInstance();
        sqlBuilder.select("*")
                .from("task_info")
                .where()
                .addEqualTo("uid",uid)
                .addEqualTo("task_type",TaskType);
        try {
            tasks = (List<Task>) sqlBuilder.createQuery(sqlBuilder.getSql(), sqlBuilder.getParams(), Task.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            SqlBuilder.closeAll();
        }
        return tasks;
    }

    @Override
    public List<Task> queryTaskByTaskPriority(Integer uid, Integer TaskPriority) {
        List<Task> tasks =new ArrayList<>();
        SqlBuilder sqlBuilder = SqlBuilder.getInstance();
        sqlBuilder.select("*")
                .from("task_info")
                .where()
                .addEqualTo("uid",uid)
                .addEqualTo("task_priority",TaskPriority);
        try {
            tasks = (List<Task>) sqlBuilder.createQuery(sqlBuilder.getSql(), sqlBuilder.getParams(), Task.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            SqlBuilder.closeAll();
        }
        return tasks;
    }
}
