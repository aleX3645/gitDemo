import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

    Connection dbConnection = null;
    public SQLConnector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found MySQL JDBC Driver");
            e.printStackTrace();
            return;
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://hostname:3306/moviepiratr", "root","Alex36451999");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean AddMovie(String name,int fees,int ageRating,int rating,String details,int hypePerWeek, String producerName){
        try{
            Statement stat = dbConnection.createStatement();
            stat.executeUpdate("INSERT INTO movie (name,`world fees`,ageRating,rating,details,hypePerWeek,ProducerName) VALUES (" +
                    name + "," + fees + "," + ageRating + "," + rating + "," + details + "," + hypePerWeek + "," + producerName + ")");
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }


    public void CloseConnection(){
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
