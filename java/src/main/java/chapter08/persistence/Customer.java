package chapter08.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A very simple entity to have the DAO in this package return something.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    private String id;
    private int dob;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }
}
