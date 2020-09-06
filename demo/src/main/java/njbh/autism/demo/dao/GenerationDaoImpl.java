package njbh.autism.demo.dao;

import njbh.autism.demo.model.Generation;
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
public class GenerationDaoImpl implements GenerationDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class GenerationRowMapper implements RowMapper<Generation> {

        @Override
        public Generation mapRow(ResultSet resultSet, int i) throws SQLException {
            Generation generation = new Generation();

            generation.setGid(resultSet.getString("gid"));
            generation.setFloor(resultSet.getInt("floor"));
            generation.setCeil(resultSet.getInt("ceil"));
            return generation;
        }
    }
    @Override
    public Collection<Generation> getAllRecords() {
        final String sql = "SELECT * FROM generations";
        List<Generation> generations = jdbcTemplate.query(sql, new GenerationDaoImpl.GenerationRowMapper());
        return generations;
    }

    @Override
    public Generation getGenerationById(String gid) {
        final String sql = "SELECT * FROM generations WHERE gid = ?";
        Generation generation = jdbcTemplate.queryForObject(sql, new GenerationDaoImpl.GenerationRowMapper(), gid);
        return generation;
    }

    @Override
    public void removeGenerationById(String gid) {
        final String sql = "DELETE FROM generations WHERE gid = ?";
        this.jdbcTemplate.update(sql, gid);
    }

    @Override
    public void updateGeneration(Generation generation) {
        final String sql = "UPDATE generations SET floor = ?, ceil = ? WHERE gid = ?";
        final String gid = generation.getGid();
        final int floor = generation.getFloor();
        final int ceil = generation.getCeil();

        this.jdbcTemplate.update(sql, floor, ceil, gid);
    }

    @Override
    public void insertGeneration(Generation generation) {
        final String sql = "INSERT INTO generations  VALUES (?, ?, ?)";
        final String gid = generation.getGid();
        final int floor = generation.getFloor();
        final int ceil = generation.getCeil();

        this.jdbcTemplate.update(sql, gid, floor, ceil);
    }
}
