package personas.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    public static DataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(JDBC_URL);
        basicDataSource.setPassword(JDBC_PASS);
        basicDataSource.setPassword(JDBC_PASS);
        //Inicializamos el tamaño inicial del pool de conexiones
        basicDataSource.setInitialSize(5);
        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public static void close(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void close(Connection connection) throws SQLException {
        connection.close();
    }


}
