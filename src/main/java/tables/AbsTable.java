package tables;

import com.mysql.cj.xdevapi.SqlResult;
import data.db.IDBCConnector;
import data.db.MYSQLDBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


public abstract class AbsTable<T> {
    public AbsTable (String name) {
        this.name = name;

    }
       private IDBCConnector idbcConnector = new MYSQLDBConnector();
    private String name = "";

        public void create(List<String> columns) throws SQLException {
            if (!isTableExist()) {
                String sqlRequest = String.format("CREATE TABLE %s (%s)", name, String.join(", ", (CharSequence) Collections.singleton(columns)));
                idbcConnector.execute(sqlRequest);
            }
        }
public void insert (String name, int age, double weight, data.Color color, String type) throws SQLException {
    idbcConnector.execute ( "INSERT INTO animals (name, age, weight, color, type) VALUES ('" + name + "'," +
            " " + age + ", " + weight + ", '" + color + "', '" +type + "'");

        }




        private boolean isTableExist () throws SQLException {
            String sqlRequest = String.format("SHOW TABLES LIKE '%s'", name);
            ResultSet resultSet = idbcConnector.executeQuery(sqlRequest);

            while (resultSet.next()) {
                if (resultSet.getString(1).equals(name)) {
                    return true;
                }
            }
            return false;
        }

//    public ResultSet list (String animalType) {
//        String sqlRequest = String.format("select * from animals where );
//        ResultSet resultSet = idbcConnector.executeQuery(sqlRequest);
//
//        while (resultSet.next()) {
//            if (resultSet.getString(1).equals(name)) {
//                return true;
//            }

    }