package njbh.autism.demo.controller;

import njbh.autism.demo.dao.TestConnectionDao;
import njbh.autism.demo.model.TestConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/testConnection")
public class TestConnectionController {

    @Autowired
    @Qualifier("mysql")
    private TestConnectionDao testConnectionDao;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TestConnection> getAllRecords(){
        return testConnectionDao.getAllRecords();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TestConnection getTestConnectionById(@PathVariable("id") int id){
        return this.testConnectionDao.getTestConnectionById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeTestConnectionById(@PathVariable("id") int id){
        this.testConnectionDao.removeTestConnectionById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  updateTestConnection(@RequestBody TestConnection testConnection){
        this.testConnectionDao.updateTestConnection(testConnection);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  insertTestConnection(@RequestBody TestConnection testConnection){
        this.testConnectionDao.insertTestConnection(testConnection);
    }
}
