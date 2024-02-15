package br.com.nord.mapper.response.lead;

import br.com.nord.enums.LeadStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadGetResponse {

    private Long customerId;

    private Long productId;

    private LocalDateTime createdAt;

    private LeadStatus status;

    private Long panelId;

}
