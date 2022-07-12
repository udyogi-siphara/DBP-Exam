/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 8:55 AM
 */

package util;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql, Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++){
            statement.setObject((i+1),params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) statement.executeQuery();
        }else {
            return ((T)(Boolean)(statement.executeUpdate()>0));
        }
    }

}
