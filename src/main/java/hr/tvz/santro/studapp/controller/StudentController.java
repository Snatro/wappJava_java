package hr.tvz.santro.studapp.controller;

import hr.tvz.santro.studapp.command.StudentCommand;
import hr.tvz.santro.studapp.domain.Student;
import hr.tvz.santro.studapp.dto.StudentDTO;
import hr.tvz.santro.studapp.service.StudentJPAService;
import hr.tvz.santro.studapp.service.StudentService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;
    private final StudentJPAService studentJPAService;

    public StudentController(StudentService studentService,StudentJPAService jpaService) {
        this.studentService = studentService;
        this.studentJPAService = jpaService;
    }

    @GetMapping
    public List<StudentDTO> getStudents(){
       return studentService.findAll();
    }

    @GetMapping(params = "JMBAG")
    public ResponseEntity<StudentDTO> getStudentByJMBAG(@RequestParam final String JMBAG){
        return studentService.findStudentByJMBAG(JMBAG)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.OK)
                                .headers(new HttpHeaders())
                                .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("/{JMBAG}")
    public void delete (@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
    }
    @GetMapping("/dateBefore")
    public List<StudentDTO> findByDateBefore(){
        return studentJPAService.findByBirthDateBefore(LocalDate.now().minusYears(23));
    }
    @GetMapping("/dateAfter")
    public List<StudentDTO> findByDateAfter(){
        return studentJPAService.findByBirthDateAfter(LocalDate.now().minusYears(23));
    }
    @GetMapping("/dateBetween")
    public List<StudentDTO> findByDateBetween(){
        return studentJPAService.findByBirthDateBetween(LocalDate.now().minusYears(23),LocalDate.now());
    }
}
