package njbh.autism.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity // this tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
    @Id
    private String uid;
    private String name;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String birthday;


    protected User() {}

    public User(String uid, String name, String email, String birthday) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public String getBirthday() {
        return birthday;
    }
}
