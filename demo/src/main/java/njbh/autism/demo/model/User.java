package njbh.autism.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity // this tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private String name;
    private String birthdate;
    private int age;
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return birthdate;
    }

    public void setDate(Date date) {
        this.birthdate = birthdate;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
