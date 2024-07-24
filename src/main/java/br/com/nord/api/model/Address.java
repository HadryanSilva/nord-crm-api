package br.com.nord.api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Column(nullable = false, name = "address_zip_code")
    private String zipCode;

    @Column(nullable = false, name = "address_city")
    private String city;

    @Column(nullable = false, name = "address_street")
    private String street;

    @Column(nullable = false, name = "address_state")
    private String state;

    @Column(nullable = false, name = "address_district")
    private String district;

    @Column(name = "address_complement")
    private String complement;

}
