package hr.tvz.santro.studapp.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(targetEntity = User.class,mappedBy = "authorities")
    List<User> users;
    public Authority(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Authority(String name) {
        this.name = name;
    }
}
