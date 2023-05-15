package hr.tvz.santro.studapp.repository;

import hr.tvz.santro.studapp.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAll();
    List<Course> findAllByStudents_Jmbag(String jmbag);
    Course findFirstByStudents_Jmbag(String jmbag);
    List<Course> findTop2ByStudents_Jmbag(String jmbag);
    List<Course> findDistinctByStudents_Surname(String surname);
    List<Course> findByNameEquals(String name);
    List<Course> findByNameIs(String name);
    List<Course> findByEctsNot(Integer ects);
    List<Course> findByEctsIn(List<Integer> ects);
    List<Course> findByEctsNotIn(List<Integer> ects);


}
