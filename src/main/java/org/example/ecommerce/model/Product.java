package org.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)

    private Long productId;
    private String productName;
    private String description;
    private Integer quantity;
    private String image;
    private Double price;
    private Double specialPrice;
    private Double discount;
    @ManyToOne
    @JoinColumn(name = "category_id" )
    @JsonIgnore
    private Category category;
}
