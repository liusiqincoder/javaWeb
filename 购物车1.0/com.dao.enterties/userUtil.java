package com.dao.enterties;

import java.sql.*;

/**
 * Created by Administrator on 2018/9/23.
 */
public class userUtil {

    public static boolean exisitsUser(User user) {
        Statement stat = DBUtil.getStat();
        if (stat == null) {
            System.out.println("数据库打开异常");
            return false;
        }
        if (user.getPassword().equals(getUser(stat, user.getName())))
            return true;

        return false;
    }

    private static String getUser(Statement stat, String name) {
        String sql = "select * from User where name =\'" + name + "\'";
        String password = "";
        try {
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                password = rs.getString(2);
            } else
                return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
        return password;
    }

    public static boolean addUser(Statement stat, User user) {
        if (!"".equals(getUser(stat, user.getName()))) {
            System.out.println("用户已存在，注册不成功");
            return false;
        }
        String sql = "insert into User values(\'" + user.getName() + "\',\'" + user.getPassword() + "\');";
        try {
            int num = stat.executeUpdate(sql);
            if (num == 0) {
                System.out.println("插入不成功,注册失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
