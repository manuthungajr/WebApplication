/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dulanjana
 */
@WebService(serviceName = "Thread")
public class Thread {
    private Connection con;
    private Statement state1;
    
    
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addThreads")
    public String addThreads(@WebParam(name = "Name") String Name) {
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
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            
            
            String sql = "INSERT INTO threads (Name, Date, By) VALUES ('"+Name+"', '"+dtf.format(now)+"', '"+"ez"+"')";
            System.out.println("5");
            state1.executeUpdate(sql);
            System.out.println("6");
            
        } catch (Exception ex) {
            
            System.out.println("Error:"+ex);
        }
        return null;
    }
}
