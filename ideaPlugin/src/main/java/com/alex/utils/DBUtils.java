package com.alex.utils;

import com.alex.configuration.Configuration;

import java.sql.*;

/**
 * @author wsh
 * @date 2019-11-05
 *
 * 本地数据测试库连接工具类
 */

public class DBUtils {
    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static Connection conn;

    public static Connection getConnection(){
        try {
            driver = Configuration.getValue("driver");
            url = Configuration.getValue("url");
            username = Configuration.getValue("username");
            password = Configuration.getValue("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn, PreparedStatement p, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(p != null){
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
