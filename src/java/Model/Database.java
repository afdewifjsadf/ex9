/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ub
 */
public class Database {
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String url = "jdbc:derby://localhost:1527/test";
    private String username = "app";
    private String password = "app";
    
    private Connection connect;
    private static Statement stmt;
    public Database() {
        try{
            Class.forName(driver);
            connect = DriverManager.getConnection(url, username, password);
            stmt = connect.createStatement();
            System.err.println("make it");
            
        }catch(Exception e){
             System.err.println("error");
             e.printStackTrace();
        }
    }
    
    public void close(){
        try {
            if (connect!=null){
                connect.close();
                System.err.println("\n close connect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static String insertStudent(Student s) throws SQLException {
        String sql = "insert into STUDENT (id, name, gpa)"
                + " values (" + s.getId() + "," + "'" + s.getName() + "'" + "," + s.getGpa() + ")";
        int result = stmt.executeUpdate(sql);
        System.out.println("Insert " + result + " row");
        return "Insert " + result + " row";
    }

    public static String deleteStudent( Student s) throws SQLException {
        String sql = "delete from STUDENT where id = " + s.getId();
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("Delete " + result + " row");
        return "Delete " + result + " row";
    }

    public static String updateStudent(Student s) throws SQLException {
        String sql = "update STUDENT set gpa  = " + s.getGpa() +", name = '" + s.getName() + "'"
                + " where id = " + s.getId();
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("Update " + result + " row");
        return "Update " + result + " row";
    }


    
    
}
