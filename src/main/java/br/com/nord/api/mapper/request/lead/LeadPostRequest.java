package br.com.nord.api.mapper.request.lead;

import br.com.nord.api.model.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadPostRequest {

    private Long customerId;

    private Long productId;

    private LocalDateTime createdAt;

    private LeadStatus status;

}
