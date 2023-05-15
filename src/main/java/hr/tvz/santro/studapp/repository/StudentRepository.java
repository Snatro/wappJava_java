package hr.tvz.santro.studapp.repository;

import hr.tvz.santro.studapp.domain.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentRepository {
    Set<Student> findAll();
    Optional<Student> findStudentByJMBAG(String JMBAG);
    Optional<Student> save(Student student);
    void deleteByJMBAG(String jmbag);
}
