package oks.ro.marketapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstname;

    private String lastname;

    private int age;

    private String email;

    private String country;

    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<Command> commands;
}
