package sk.akademiasovy.tipos.server.db;

import sk.akademiasovy.tipos.server.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQL {


    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/tipos";
    private String username="root";
    private String password="";

    public getUser(String username, String password){
       try{
        conn=Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url,username,password);
        String query = "SELECT Name from country username where username like ? password like ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            User user=new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),rs.getString("login"));
            query = "UPDATE INTO tokens(idu, token") VALUES (? ?)";
                    ps=conn.prepareStatement()
        }
        return null;
    }catch(Exception e){
           e.printStackTrace();
       }
        return null ;
        }

}
