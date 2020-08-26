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

            generation.setId(resultSet.getInt("id"));
            generation.setFrom(resultSet.getInt("from"));
            generation.setTo(resultSet.getInt("to"));
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
    public Generation getGenerationById(int id) {
        final String sql = "SELECT * FROM generations WHERE id = ?";
        Generation generation = jdbcTemplate.queryForObject(sql, new GenerationDaoImpl.GenerationRowMapper(), id);
        return generation;
    }

    @Override
    public void removeGenerationById(int id) {
        final String sql = "DELETE FROM generations WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateGeneration(Generation generation) {
        final String sql = "UPDATE generations SET from = ?, to = ? WHERE id = ?";
        final int id = generation.getId();
        final int from = generation.getFrom();
        final int to = generation.getTo();

        this.jdbcTemplate.update(sql, id, from, to);
    }

    @Override
    public void insertGeneration(Generation generation) {
        final String sql = "INSERT INTO generations  VALUES (?, ?, ?)";
        final int id = generation.getId();
        final int from = generation.getFrom();
        final int to = generation.getTo();

        this.jdbcTemplate.update(sql, id, from, to);
    }
}
