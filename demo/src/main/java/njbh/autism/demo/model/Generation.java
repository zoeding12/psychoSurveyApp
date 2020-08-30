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
    private int floor;
    private int ceil;

    public Generation(int id, int floor, int ceil) {
        this.id = id;
        this.floor = floor;
        this.ceil = ceil;
    }

    public Generation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCeil() {
        return ceil;
    }

    public void setCeil(int ceil) {
        this.ceil = ceil;
    }
}