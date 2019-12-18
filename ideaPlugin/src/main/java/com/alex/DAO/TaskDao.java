package com.alex.DAO;

import com.alex.VO.TaskVO;
import com.alex.entity.Task;

import java.util.List;

/**
 *
 * 使用uid来确定具体获得哪一个用户的task
 */
public interface TaskDao {

     List<Task> queryAllTask(Integer uid);
     List<TaskVO> queryAllShowTask(Integer uid);
     List<Task> queryTaskByProjectName(Integer uid, String project);
     List<Task> queryTaskByTaskType(Integer uid, String TaskType);
     List<Task> queryTaskByTaskPriority(Integer uid, Integer TaskPriority);
     Boolean saveOrUpdateTask(Object object);

}
