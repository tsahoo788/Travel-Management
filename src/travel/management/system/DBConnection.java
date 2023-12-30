package travel.management.system;
import  java.sql.*;
public class DBConnection 
{
    Connection c;
    Statement s;
    public DBConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","root");
            s = c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
