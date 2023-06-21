import java.sql.*;

public class DatabaseConnector {
    public Connection connect(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String pass = "root";
        try {
            connection = DriverManager.getConnection(url,userName,pass);
            System.out.println("Connected to  database successfully");
        } catch (SQLException e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllBooks(){
        String sql = "SELECT * FROM books";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {connection = this.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("title") + "\t"
                        + resultSet.getString("author") + "\t"
                        + resultSet.getString("price"));
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error executing SELECT Statement");
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
