package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBClient {
    public static MySqlDBClient client = null;
    public static Connection mysqlClient;

    private MySqlDBClient()
    {
        String url = "jdbc:mysql://localhost:3306/org";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mysqlClient = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static MySqlDBClient getClient()
    {
        if (client == null){
            System.out.println("Primera vez");
            client = new MySqlDBClient();
        }

        return client;
    }

    public long getData() {

        return 4;
    }
}
