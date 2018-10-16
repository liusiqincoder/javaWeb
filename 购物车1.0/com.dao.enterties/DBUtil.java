package com.dao.enterties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2018/10/1.
 */
public class DBUtil {

    private static Connection conn = null;
    private static Statement stat = null;

    public static Statement getStat() {
        if (stat == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/购物车系统?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimez" +
                        "one=GMT", "root", "root");
                stat = conn.createStatement();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return stat;
    }

    public static boolean close() {
        try {
            if (conn != null)
                conn.close();
            if (stat != null)
                stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
