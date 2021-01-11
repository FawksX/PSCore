package games.synx.pscore.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabase {

    Connection getConnection() throws SQLException;

    void close();

}
