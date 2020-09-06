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
            question.setQid(resultSet.getString("qid"));
            question.setContent(resultSet.getString("content"));
            question.setCategory(resultSet.getString("category"));
            question.setGid(resultSet.getString("gid"));

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
    public Question getQuestionById(String qid) {
        // "?" would be replaced with id directly by Spring Boot
        final String sql = "SELECT * FROM questions WHERE qid = ?";
        Question question = jdbcTemplate.queryForObject(sql, new QuestionImpl.QuestionRowMapper(), qid);
        return question;
    }

    @Override
    public void removeQuestionById(String qid) {
        final String sql = "DELETE FROM questions WHERE qid = ?";
        this.jdbcTemplate.update(sql, qid);
    }

    @Override
    public void updateQuestion(Question question) {
        final String sql = "UPDATE questions SET content = ?, category = ?, gid =? WHERE qid = ?";
        final String qid = question.getQid();
        final String content = question.getContent();
        final String category = question.getCategory();
        final String gid = question.getGid();

        this.jdbcTemplate.update(sql, new Object[] {content, category, gid, qid});
    }

    @Override
    public void insertQuestion(Question question) {
        final String sql = "INSERT INTO questions  VALUES (?, ?, ?, ?)";
        final String qid = question.getQid();
        final String content = question.getContent();
        final String category = question.getCategory();
        final String gid = question.getGid();

        this.jdbcTemplate.update(sql, new Object[] {qid, content, category, gid});
    }





}
