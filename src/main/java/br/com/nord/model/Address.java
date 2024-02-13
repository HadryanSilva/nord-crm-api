package br.com.nord.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

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
