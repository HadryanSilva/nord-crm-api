package br.com.nord.api.mapper.response.lead;

import br.com.nord.api.model.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadGetResponse {

    private Long id;

    private Long customerId;

    private Long productId;

    private LocalDateTime createdAt;

    private LeadStatus status;

}
