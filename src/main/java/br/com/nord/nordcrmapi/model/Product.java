package br.com.nord.nordcrmapi.model;

import br.com.nord.nordcrmapi.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String supplier;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private String description;

}
