package test1;

import test2.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql:///mytest";
        String username = "root";
        String password = "12345";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from user";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        List<User> list=new ArrayList<>();
        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("username");
            String psw = rs.getString("password");

            User user=new User(id,name,psw);
            list.add(user);
        }

        System.out.println(list);
        
        stmt.close();
        rs.close();
        conn.close();
    }
}
