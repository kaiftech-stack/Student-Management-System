package entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "plot_no")
    private String plotNo;

    private String area;

    private int pincode;

    private String city;

    private String state;

    private String country;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Students student;
}
