package com.alex.utils;

import com.alex.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2019-12-09
 */
public class SqlBuilderTest {


    @Test
    public void testCreateQuery(){
        Integer uid = 1;
        String username = "alex_trello";
        SqlBuilder sqlBuilder = SqlBuilder.getInstance();
        sqlBuilder.select("*")
                .from("trello_user")
                .where()
                .addEqualTo("uid", uid)
                .addEqualTo("username", username);
        try {
            List<User> users = (List<User>) sqlBuilder.createQuery(sqlBuilder.getSql(), sqlBuilder.getParams(), User.class);
            System.out.println(users);
            System.out.println(users.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            SqlBuilder.closeAll();
        }
    }



    @Test
    public void testSaveOrUpdate(){
        User user = new User(19, "我asdad", "12312312eqweqeqw");
        try {
            System.out.println(SqlBuilder.saveOrUpdate(user));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlBuilder.closeAll();
        }

    }
}
