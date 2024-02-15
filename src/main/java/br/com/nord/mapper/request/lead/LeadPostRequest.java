package br.com.nord.mapper.request.lead;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadPostRequest {

    private Long customerId;

    private Long productId;

    private LocalDateTime createdAt;

    private String status;

    private Long panelId;

}
