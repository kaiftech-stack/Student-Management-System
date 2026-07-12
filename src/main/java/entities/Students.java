package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name ;

    @Column(name = "email")
    private  String email;
    private int age;

    public Students(){

    }

    public Students(String name, String email, int age ){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", age=" + age + "]";
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Courses> courses;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Address address;
}
