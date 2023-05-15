package hr.tvz.santro.studapp.controller;


import hr.tvz.santro.studapp.domain.Course;
import hr.tvz.santro.studapp.dto.CourseDTO;
import hr.tvz.santro.studapp.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return this.courseService.findAll();
    }
    @GetMapping("/{JMBAG}")
    public List<CourseDTO> getAllCoursesByStudentJmbag(@PathVariable String JMBAG){
        return this.courseService.findAllByStudentJmbag(JMBAG);
    }
    @GetMapping("/findFirst/{JMBAG}")
    public CourseDTO getFirstCourseByStudentJmbag(@PathVariable String JMBAG){
        return this.courseService.findFirstByStudentsJmbag(JMBAG);
    }
    @GetMapping("/findTopTwo/{JMBAG}")
    public List<CourseDTO> getFirstTwoCourseByStudentJmbag(@PathVariable String JMBAG){
        return this.courseService.findTop2ByStudentsJmbag(JMBAG);
    }
    @GetMapping("/findDistinct/{surname}")
    public List<CourseDTO> getDistinctCourseByStudentSurname(@PathVariable String surname){
        return this.courseService.findDistinctByStudentsSurname(surname);
    }
    @GetMapping("/findByNameEquals/{name}")
    public List<CourseDTO> getCoursesWithNameEquals(@PathVariable String name){
        return this.courseService.findByNameEquals(name);
    }
    @GetMapping("/findByNameIs/{name}")
    public List<CourseDTO> getCoursesWithNameIs(@PathVariable String name){
        return this.courseService.findByNameIs(name);
    }
    @GetMapping("/findByEctsNot/{ects}")
    public List<CourseDTO> getCoursesWithEctsNot(@PathVariable Integer ects){
        return this.courseService.findByEctsNot(ects);
    }
    @GetMapping("/findByEctsIn")
    public List<CourseDTO> getCoursesWithEctsIn(){
        List<Integer> integers = List.of(1,6,120,180);
        return this.courseService.findByEctsIn(integers);
    }
    @GetMapping("/findByEctsNotIn")
    public List<CourseDTO> getCoursesWithEctsNotIn(){
        List<Integer> integers = List.of(1,60,120,180);
        return this.courseService.findByEctsNotIn(integers);
    }
}
