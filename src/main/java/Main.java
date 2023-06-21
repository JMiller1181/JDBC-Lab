import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.selectAllBooks();
    }
}
