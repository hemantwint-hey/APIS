package org.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long productId;
    private String productName;
    @NotBlank
    @Size(min = 6, message = "Product description must contain atleast 6 character")
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


    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;
}
