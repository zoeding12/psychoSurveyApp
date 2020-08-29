package njbh.autism.demo.model;

import javax.persistence.*;

@Entity // this tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String birthday;
    private String email;

    protected User() {}

    public User(int id, String name, String birthday, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
//        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

//    public int getAge() { return age; }

    public String getEmail() {
        return email;
    }

}
