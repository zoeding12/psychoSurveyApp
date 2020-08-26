package njbh.autism.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generations")
public class Generation {
    @Id
    @GeneratedValue
    private int id;
    private int from;
    private int to;

    public Generation(int id, int from, int to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public Generation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}