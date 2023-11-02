package oks.ro.marketapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oks.ro.marketapi.model.model_utils.CommandStatus;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandId;

    @Column(name = "ttlCmp")
    private Double totalCommandPrice;

    private Date commandDate;

    @Enumerated(EnumType.STRING)
    private CommandStatus commandStatus;

    private Date lastModifiedDate;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "command")
    @JsonIgnore
    private List<CommandLine> commandLines;
}
