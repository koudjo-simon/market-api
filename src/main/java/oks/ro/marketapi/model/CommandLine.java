package oks.ro.marketapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandLine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandLineId;

    private Double unitPrice;

    private Double quantity;

    private Double totalCommandLinePrice;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Command command;
}
