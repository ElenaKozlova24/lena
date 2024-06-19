package data.db;

import configuration.db.Configurator;
import data.db.IDBCConnector;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MYSQLDBConnector implements IDBCConnector {
    private Configurator configurator = new Configurator();
    private Statement statement = null;
    private Connection connection = null;
    ()

    private void connect() {
        try {
            Properties configuration = configurator.getConfigurator();

            String url = configuration.getProperty("db_url");
            String dbName = configuration.getProperty("db_name");
            String username = configuration.getProperty("username");
            String password = configuration.getProperty("password");

            String connectionString = String.format("jdbc:mysql://%s/%s", url, dbName);

            connection = DriverManager.getConnection(connectionString, username, password);
            statement = connection.createStatement();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        statement.execute(sql);
        return statement.execute(sql);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
    return statement.executeQuery(sql);
}
}
@Override
public void close () throws SQLException {
    if (statement != null) {
        statement.close();
    }
    if (connection !=null)
        connection.close();}
}

