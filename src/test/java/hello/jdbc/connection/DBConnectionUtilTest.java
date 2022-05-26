package hello.jdbc.connection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

public class DBConnectionUtilTest {


    @Test
    void connect() {
        Connection connection = DBConnectUtil.getConnection();
        assertThat(connection).isNotNull();
    }
}
