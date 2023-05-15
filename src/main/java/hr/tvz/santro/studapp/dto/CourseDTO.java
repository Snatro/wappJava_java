package hr.tvz.santro.studapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CourseDTO {
    private final String name;
    private final Integer ects;

}
