package hr.tvz.santro.studapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer ects;

    public Course(long id, String name, Integer ects){
        this.id = id;
        this.name = name;
        this.ects = ects;
    }
    public Course(String name, Integer ects){
        this.name = name;
        this.ects = ects;
    }
    @ManyToMany(targetEntity = Student.class, mappedBy = "courses")
    private List<Student> students;

}
