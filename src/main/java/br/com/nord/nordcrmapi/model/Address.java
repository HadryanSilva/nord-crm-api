package br.com.nord.nordcrmapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String district;

    private String complement;

}
