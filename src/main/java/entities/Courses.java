package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="course")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private double fees;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

}
