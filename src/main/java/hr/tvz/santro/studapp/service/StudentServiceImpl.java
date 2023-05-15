package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.command.StudentCommand;
import hr.tvz.santro.studapp.domain.Student;
import hr.tvz.santro.studapp.dto.StudentDTO;
import hr.tvz.santro.studapp.repository.StudentJPARepository;
import hr.tvz.santro.studapp.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService,StudentJPAService {
    private static final int YEARS_AFTER_TUITION_PAYMENT = 26;

    private final StudentRepository studentRepository;

    private final StudentJPARepository studentJPARepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentJPARepository jpaRepository) {
        this.studentRepository = studentRepository;
        this.studentJPARepository = jpaRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentsToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentsToDTO);
    }


    @Override
    public Optional<StudentDTO> save(@Valid StudentCommand command) {
        return studentRepository.save(this.mapCommandToStudent(command)).map(this::mapStudentsToDTO);
    }

    @Override
    public void deleteByJMBAG(final String jmbag) {
        studentRepository.deleteByJMBAG(jmbag);
    }


    private StudentDTO mapStudentsToDTO(final Student student){
        return new StudentDTO(student.getName(), student.getSurname(),student.getJmbag(),student.getEcts(),shouldTuitionBePaid(student.getBirthDate()));
    }

    private Student mapCommandToStudent(final StudentCommand studentCommand) {
        return new Student(studentCommand.getName(), studentCommand.getSurname(), studentCommand.getJmbag(), studentCommand.getBirthDate(), studentCommand.getEcts());
    }

    private boolean shouldTuitionBePaid(LocalDate birthDate){
        return birthDate.plusYears(YEARS_AFTER_TUITION_PAYMENT).isBefore(LocalDate.now());
    }

    @Override
    public List<StudentDTO> findByBirthDateBefore(LocalDate date) {
        return this.studentJPARepository.findByBirthDateBefore(date).stream().map(this::mapStudentsToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByBirthDateAfter(LocalDate date) {
        return this.studentJPARepository.findByBirthDateAfter(date).stream().map(this::mapStudentsToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByBirthDateBetween(LocalDate date1, LocalDate date2) {
        return this.studentJPARepository.findByBirthDateBetween(date1,date2)
                .stream().map(this::mapStudentsToDTO)
                .collect(Collectors.toList());
    }
}
