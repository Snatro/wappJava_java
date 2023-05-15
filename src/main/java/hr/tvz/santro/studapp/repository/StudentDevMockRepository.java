package hr.tvz.santro.studapp.repository;

import hr.tvz.santro.studapp.domain.Student;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
@Component
@Profile("dev")
public class StudentDevMockRepository implements StudentRepository {

    private final Set<Student> MOCK_STUDENTS = new HashSet<>();
    @Override
    public Set<Student> findAll() {
        return MOCK_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return MOCK_STUDENTS.stream().filter(st -> Objects.equals(st.getJmbag(),JMBAG)).findAny();
    }

    @Override
    public Optional<Student> save(final Student student) {
        if(!MOCK_STUDENTS.contains(student)){
            MOCK_STUDENTS.add(student);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByJMBAG(String jmbag) {

    }

}
