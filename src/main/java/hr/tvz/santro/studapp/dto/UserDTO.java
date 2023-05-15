package hr.tvz.santro.studapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final Set<String> authorities;

    public UserDTO(Long id, String username, String firstName, String lastName, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }
}