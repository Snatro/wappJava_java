package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.domain.Course;
import hr.tvz.santro.studapp.dto.CourseDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> findAll();
    List<CourseDTO> findAllByStudentJmbag(String jmbag);

    CourseDTO findFirstByStudentsJmbag(String jmbag);
    List<CourseDTO> findTop2ByStudentsJmbag(String jmbag);
    List<CourseDTO> findDistinctByStudentsSurname(String surname);
    List<CourseDTO> findByNameEquals(String name);
    List<CourseDTO> findByNameIs(String name);
    List<CourseDTO> findByEctsNot(Integer ects);
    List<CourseDTO> findByEctsIn(List<Integer> ects);
    List<CourseDTO> findByEctsNotIn(List<Integer> ects);

}
