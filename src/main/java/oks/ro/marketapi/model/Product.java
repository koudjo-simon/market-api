package oks.ro.marketapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oks.ro.marketapi.model.model_utils.ProductStatus;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long productId;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Long stockQte;
    private Date addDate;
    @Enumerated(EnumType.STRING)
    @Column(length = 2000)
    private ProductStatus productStatus;

    @ManyToOne
    private Category category;
}
