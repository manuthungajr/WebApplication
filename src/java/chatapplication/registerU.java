/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dulanjana
 */
@WebService(serviceName = "registerU")
public class registerU {

private Connection con;
private Statement state1;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "a")
    public String a(@WebParam(name = "a") String a, @WebParam(name = "b") String b, @WebParam(name = "c") String c) {
        System.out.println("Yesssss");
        try {
            System.out.println("1");
            //loading driver class
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("2");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app","root","");
            System.out.println("3");
            state1=con.createStatement();
            System.out.println("4");
            
            String sql = "INSERT INTO users (Nickname, Logid, Password) VALUES ('"+a+"', '"+b+"', '"+c+"')";
            System.out.println("5");
            state1.executeUpdate(sql);
            System.out.println("6");
            
        } catch (Exception ex) {
            
            System.out.println("Error:"+ex);
        }
        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "Loginid") String Loginid, @WebParam(name = "Password") String Password) {
        //TODO write your implementation code here:
        System.out.println("Yesssss");
        try {
            System.out.println("1");
            //loading driver class
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("2");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app","root","");
            System.out.println("3");
            state1=con.createStatement();
            System.out.println("4");
            
            String sql = "SELECT * FROM users WHERE Logid = '"+Loginid+"' AND Password = '"+Password+"'";
            System.out.println("5");
            state1.executeQuery(sql);
            System.out.println("6");
            System.out.println("Login Sucessfull");
            
        } catch (Exception ex) {
            
            System.out.println("Error:"+ex);
        }
        
        return null;
    }
        
    }

