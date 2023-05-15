package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.domain.Course;
import hr.tvz.santro.studapp.dto.CourseDTO;
import hr.tvz.santro.studapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return this.courseRepository.findAll().stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findAllByStudentJmbag(String jmbag) {
        return this.courseRepository.findAllByStudents_Jmbag(jmbag).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findFirstByStudentsJmbag(String jmbag) {
        return this.mapToCourseDTO(this.courseRepository.findFirstByStudents_Jmbag(jmbag));
    }

    @Override
    public List<CourseDTO> findTop2ByStudentsJmbag(String jmbag) {
        return this.courseRepository.findTop2ByStudents_Jmbag(jmbag).stream()
                .map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findDistinctByStudentsSurname(String surname) {
        return this.courseRepository.findDistinctByStudents_Surname(surname).stream().map(this::mapToCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByNameEquals(String name) {
        return this.courseRepository.findByNameEquals(name).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByNameIs(String name) {
        return this.courseRepository.findByNameIs(name).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByEctsNot(Integer ects) {
        return this.courseRepository.findByEctsNot(ects).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByEctsIn(List<Integer> ects) {
        return this.courseRepository.findByEctsIn(ects).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByEctsNotIn(List<Integer> ects) {
        return this.courseRepository.findByEctsNotIn(ects).stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    private CourseDTO mapToCourseDTO(Course course){
        return new CourseDTO(course.getName(),course.getEcts());
    }
}
