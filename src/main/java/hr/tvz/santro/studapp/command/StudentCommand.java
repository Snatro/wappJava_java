package hr.tvz.santro.studapp.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentCommand {
    @NotBlank(message = "First name cannot be empty")
    private String name;

    @NotBlank(message = "Last name cannot be empty")
    private String surname;

    @JsonFormat(pattern="dd.MM.yyyy.")
    @NotNull(message = "Birth date must be entered")
    @Past(message = "Birth date must be in past")
    private LocalDate birthDate;

    @NotBlank(message = "JMBAG cannot be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;

    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS points must be a positive integer")
    @Max(message = " Number of ECTS can not be higher than 480", value = 480)
    private int ects;


}
