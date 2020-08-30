package njbh.autism.demo.dao;

import njbh.autism.demo.model.Question;
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
public class QuestionImpl implements QuestionDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class QuestionRowMapper implements RowMapper<Question> {

        @Override
        public Question mapRow(ResultSet resultSet, int i) throws SQLException {
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setContent(resultSet.getString("content"));
            question.setCategory(resultSet.getString("category"));
            question.setGeneration_id(resultSet.getInt("generation_id"));

            return question;
        }
    }

    @Override
    public Collection<Question> getAllRecords() {
        final String sql = "SELECT * FROM questions";
        List<Question> questions = jdbcTemplate.query(sql, new QuestionImpl.QuestionRowMapper());
        return questions;
    }

    @Override
    public Question getQuestionById(int id) {
        // "?" would be replaced with id directly by Spring Boot
        final String sql = "SELECT * FROM questions WHERE id = ?";
        Question question = jdbcTemplate.queryForObject(sql, new QuestionImpl.QuestionRowMapper(), id);
        return question;
    }

    @Override
    public void removeQuestionById(int id) {
        final String sql = "DELETE FROM questions WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateQuestion(Question question) {
        final String sql = "UPDATE questions SET content = ?, category = ?, generation_id =? WHERE id = ?";
        final int id = question.getId();
        final String content = question.getContent();
        final String category = question.getCategory();
        final int generation_id = question.getGeneration_id();

        this.jdbcTemplate.update(sql, new Object[] {content, category, generation_id, id});
    }

    @Override
    public void insertQuestion(Question question) {
        final String sql = "INSERT INTO questions  VALUES (?, ?, ?, ?)";
        final int id = question.getId();
        final String content = question.getContent();
        final String category = question.getCategory();
        final int generation_id = question.getGeneration_id();

        this.jdbcTemplate.update(sql, new Object[] {id, content, category, generation_id});
    }





}
