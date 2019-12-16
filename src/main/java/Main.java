import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        SQLConnector sql = new SQLConnector();
        System.out.println(sql.AddMovie("dda", 3, 4, 3234, "'dd'", 456, "'WB'"));
    }
}
