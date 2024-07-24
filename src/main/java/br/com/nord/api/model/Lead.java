package br.com.nord.api.model;

import br.com.nord.api.model.enums.LeadStatus;
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

    private Long customerId;

    private Long productId;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;


}
