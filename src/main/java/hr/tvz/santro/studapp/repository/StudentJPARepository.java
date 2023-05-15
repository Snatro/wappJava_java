package hr.tvz.santro.studapp.repository;

import hr.tvz.santro.studapp.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentJPARepository extends JpaRepository<Student,Long> {
    List<Student> findByBirthDateBefore(LocalDate date);
    List<Student> findByBirthDateAfter(LocalDate date);
    List<Student> findByBirthDateBetween(LocalDate date1,LocalDate date2);

    @Query("SELECT s from Student s where lower(s.name) = lower(:firstName) ")
    List<Student> find(@Param("firstName") String firstName);

}
