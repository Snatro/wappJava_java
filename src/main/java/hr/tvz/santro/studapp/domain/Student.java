package hr.tvz.santro.studapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String jmbag;
    private LocalDate birthDate;
    private Integer ects;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;


    public Student(Long id, String name, String surname, String jmbag, LocalDate birthDate, Integer ects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jmbag = jmbag;
        this.birthDate = birthDate;
        this.ects = ects;
    }

    public Student(String name, String surname, String jmbag, LocalDate birthDate, Integer ects) {
        this.name = name;
        this.surname = surname;
        this.jmbag = jmbag;
        this.birthDate = birthDate;
        this.ects = ects;
    }

}
