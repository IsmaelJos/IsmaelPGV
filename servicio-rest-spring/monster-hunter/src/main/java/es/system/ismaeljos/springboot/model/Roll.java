package es.system.ismaeljos.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rolls")
public class Roll implements Serializable{

    private int id;
    private String name;

    public Roll() {
    }

    public Roll(String name) {
        this.name = name;
    }

    public Roll(int id) {
        this.id = id;
    }

    public Roll(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Roll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return id == roll.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
