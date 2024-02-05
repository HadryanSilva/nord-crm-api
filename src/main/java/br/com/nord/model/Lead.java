package br.com.nord.model;

import br.com.nord.enums.LeadStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
