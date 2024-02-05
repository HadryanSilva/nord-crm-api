package br.com.nord.nordcrmapi.model;

import br.com.nord.nordcrmapi.enums.LeadStatus;
import br.com.nord.nordcrmapi.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Product product;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @OneToOne
    private Panel panel;

}
