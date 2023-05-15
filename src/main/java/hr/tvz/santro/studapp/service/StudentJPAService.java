package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.domain.Student;
import hr.tvz.santro.studapp.dto.StudentDTO;
import java.time.LocalDate;
import java.util.List;

public interface StudentJPAService {
    List<StudentDTO> findByBirthDateBefore(LocalDate date);
    List<StudentDTO> findByBirthDateAfter(LocalDate date);
    List<StudentDTO> findByBirthDateBetween(LocalDate date1, LocalDate date2);

}
