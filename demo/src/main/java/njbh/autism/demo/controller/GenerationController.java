package njbh.autism.demo.controller;

import njbh.autism.demo.dao.GenerationDao;
import njbh.autism.demo.dao.TestConnectionDao;
import njbh.autism.demo.model.Generation;
import njbh.autism.demo.model.TestConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/generations")
public class GenerationController {

    @Autowired
    @Qualifier("mysql")
    private GenerationDao generationDao;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Generation> getAllRecords(){
        return generationDao.getAllRecords();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Generation getGenerationById(@PathVariable("id") int id){
        return this.generationDao.getGenerationById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeGenerationById(@PathVariable("id") int id){
        this.generationDao.removeGenerationById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  updateGeneration(@RequestBody Generation generation){
        this.generationDao.updateGeneration(generation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  insertGeneration(@RequestBody Generation generation){
        this.generationDao.insertGeneration(generation);
    }
}
