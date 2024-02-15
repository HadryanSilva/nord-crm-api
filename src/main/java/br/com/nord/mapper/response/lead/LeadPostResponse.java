package br.com.nord.mapper.response.lead;

import br.com.nord.enums.LeadStatus;
import br.com.nord.model.Customer;
import br.com.nord.model.Panel;
import br.com.nord.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LeadPostResponse {

    private Long id;

    private Customer customer;

    private Product product;

    private LocalDateTime createdAt;

    private LeadStatus status;

    private Panel panel;

}
