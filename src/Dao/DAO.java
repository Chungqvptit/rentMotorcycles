package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DAO {
    protected static Connection con;//declare the connection
    public static void main(String[] args) {
        
 
    //constructor
        
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/cuahang";
            String dbClass = "com.mysql.jdbc.Driver";
 
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "chung123");
                System.out.println("Successfull");
            }catch(ClassNotFoundException | SQLException e) {
                System.out.println("errol");
            }
        }
}
}