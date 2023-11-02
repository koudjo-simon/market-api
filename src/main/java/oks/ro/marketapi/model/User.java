package oks.ro.marketapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String tel;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserRoles> userRoles;
}
