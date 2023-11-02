package oks.ro.marketapi.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import oks.ro.marketapi.model.model_utils.ProductStatus;

import java.util.Date;

@Data
public class ProductParams {
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Long stockQte;
    private String productStatus;
}
