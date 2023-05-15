package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.command.StudentCommand;
import hr.tvz.santro.studapp.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();
    Optional<StudentDTO> findStudentByJMBAG(String JMBAG);
    Optional<StudentDTO> save(StudentCommand command);

    void deleteByJMBAG(String jmbag);
}
