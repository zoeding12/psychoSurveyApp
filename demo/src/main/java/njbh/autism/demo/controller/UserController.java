package njbh.autism.demo.controller;
import njbh.autism.demo.model.User;
import njbh.autism.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController //This means that this class is a controller
@RequestMapping(path = "/users") //this means url starts with /survey after application path
public class UserController {
    @Qualifier("UserRepository")
    @Autowired //this means to get the bean called userRepository which is auto-generated by Spring, we could use it to handle the data
    private UserRepository userRepo;

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {return userRepo.findAll();
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody String addUser(@RequestParam int id,
                                        @RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam String birthday) {
        userRepo.save(new User(id, name, email, birthday));
        return "saved";
    }
}


