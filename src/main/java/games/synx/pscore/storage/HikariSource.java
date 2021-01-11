package games.synx.pscore.storage;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class HikariSource implements IDatabase {

    private final HikariDataSource source;

    public HikariSource(String address, int port, String database, String username, String password) {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://" + address + ":" + port + "/" + database);
        config.addDataSourceProperty("user", username);
        config.addDataSourceProperty("password", password);
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.addDataSourceProperty("useServerPrepStmts", true);
        config.addDataSourceProperty("cacheCallableStmts", true);
        config.addDataSourceProperty("alwaysSendSetIsolation", false);
        config.addDataSourceProperty("cacheServerConfiguration", true);
        config.addDataSourceProperty("elideSetAutoCommits", true);
        config.addDataSourceProperty("useLocalSessionState", true);
        config.addDataSourceProperty("characterEncoding","utf8");
        config.addDataSourceProperty("useUnicode","true");
        config.setConnectionTimeout(TimeUnit.SECONDS.toMillis(15));
        config.setLeakDetectionThreshold(TimeUnit.SECONDS.toMillis(10));

        this.source = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.source.getConnection();
    }

    @Override
    public void close() {
        this.source.close();
    }

}
