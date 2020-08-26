package njbh.autism.demo.dao;

import njbh.autism.demo.model.TestConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository()
@Qualifier("mysql")
public class MySqlTestConnectionDaoImpl implements TestConnectionDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class TestConnectionRowMapper implements RowMapper<TestConnection> {

        @Override
        public TestConnection mapRow(ResultSet resultSet, int i) throws SQLException {
            TestConnection testConnection = new TestConnection();
            testConnection.setId(resultSet.getInt("id"));
            testConnection.setName(resultSet.getString("name"));
            testConnection.setBirthDate(resultSet.getDate("birthdate").toString());

            return testConnection;
        }
    }

    @Override
    public Collection<TestConnection> getAllRecords() {

        final String sql = "SELECT * FROM test_connection";
        List<TestConnection> testConnections = jdbcTemplate.query(sql, new TestConnectionRowMapper());
        return testConnections;
    }

    @Override
    public TestConnection getTestConnectionById(int id) {
        // "?" would be replaced with id directly by Spring Boot
        final String sql = "SELECT * FROM test_connection WHERE id = ?";
        TestConnection testConnection = jdbcTemplate.queryForObject(sql, new TestConnectionRowMapper(), id);
        return testConnection;
    }

    @Override
    public void removeTestConnectionById(int id) {
        final String sql = "DELETE FROM test_connection WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateTestConnection(TestConnection testConnection) {
        final String sql = "UPDATE test_connection SET name = ?, birthdate = ? WHERE id = ?";
        final int id = testConnection.getId();
        final String name = testConnection.getName();
        final String birthDate = testConnection.getBirthDate();

        this.jdbcTemplate.update(sql, new Object[] {name, birthDate, id});
    }

    @Override
    public void insertTestConnection(TestConnection testConnection) {
        final String sql = "INSERT INTO test_connection (name, birthdate) VALUES (?, ?)";
        final String name = testConnection.getName();
        final String birthDate = testConnection.getBirthDate();

        this.jdbcTemplate.update(sql, new Object[] {name, birthDate});
    }

}
