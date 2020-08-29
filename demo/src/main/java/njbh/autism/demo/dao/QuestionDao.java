package njbh.autism.demo.dao;

import njbh.autism.demo.model.Question;

import java.util.Collection;

public interface QuestionDao {
    Collection<Question> getAllRecords();

    Question getQuestionById(int id);

    void removeQuestionById(int id);

    void updateQuestion(Question question);

    void insertQuestion(Question question);
}
