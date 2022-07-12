/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 8:54 AM
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    public Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ijse","root","1234");
    }
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection==null) ? dbConnection= new DBConnection():dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
