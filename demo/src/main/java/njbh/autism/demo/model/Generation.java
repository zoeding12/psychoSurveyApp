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
    private String gid;
    private int floor;
    private int ceil;

    public Generation(String gid, int floor, int ceil) {
        this.gid = gid;
        this.floor = floor;
        this.ceil = ceil;
    }

    public Generation(){}

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
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