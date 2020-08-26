package njbh.autism.demo.controller;

import njbh.autism.demo.dao.GenerationDao;
import njbh.autism.demo.dao.QuestionDao;
import njbh.autism.demo.model.Generation;
import njbh.autism.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    @Qualifier("mysql")
    private QuestionDao questionDao;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Question> getAllRecords(){
        return questionDao.getAllRecords();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Question getQuestionById(@PathVariable("id") int id){
        return this.questionDao.getQuestionById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeQuestionById(@PathVariable("id") int id){
        this.questionDao.removeQuestionById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  updateQuestion(@RequestBody Question question){
        this.questionDao.updateQuestion(question);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  insertQuestion(@RequestBody Question question){
        this.questionDao.insertQuestion(question);
    }
}

