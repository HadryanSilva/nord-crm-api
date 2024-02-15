package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.mapper.LeadMapper;
import br.com.nord.mapper.response.lead.LeadCompleteDataResponse;
import br.com.nord.model.Customer;
import br.com.nord.model.Lead;
import br.com.nord.model.Product;
import br.com.nord.repository.CustomerRepository;
import br.com.nord.repository.LeadRepository;
import br.com.nord.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class LeadService {

    private final LeadRepository leadRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final LeadMapper mapper;

    public List<LeadCompleteDataResponse> findLastFiveByOrderByCreatedAtDesc() {
        log.info("Finding last five leads");
        var leads =  leadRepository.findLastFiveByOrderByCreatedAtDesc();
        var leadsConverted = new ArrayList<LeadCompleteDataResponse>();
        fillCustomers(leads, leadsConverted);
        fillProducts(leads, leadsConverted);
        return leadsConverted;
    }

    public Lead findById(Long id) {
        log.info("Finding lead by id: {}", id);
        return leadRepository.findById(id).orElseThrow(() -> new NotFoundException("Lead not found"));
    }

    public Lead save(Lead lead) {
        log.info("Saving lead");
        return leadRepository.save(lead);
    }

    public void delete(Long id) {
        log.info("Deleting lead by id: {}", id);
        leadRepository.deleteById(id);
    }

    public void update(Lead lead) {
        assertLeadExists(lead);
        log.info("Updating lead");
        leadRepository.save(lead);
        log.info("Lead updated successfully");
    }

    private void assertLeadExists(Lead lead) {
        findById(lead.getId());
    }

    private void fillCustomers(List<Lead> leads, List<LeadCompleteDataResponse> completeLeads) {
        leads.forEach(lead -> {
            var customer = customerRepository.findById(lead.getCustomerId())
                    .orElse(null);
            var leadConverted = mapper.leadToCompleteDataResponse(lead);
            leadConverted.setCustomer(customer);
            completeLeads.add(leadConverted);
        });
    }

    private void fillProducts(List<Lead> leads, List<LeadCompleteDataResponse> leadsConverted) {
        leads.forEach(lead -> {
            var product = productRepository.findById(lead.getProductId())
                    .orElse(null);
            var leadConverted = mapper.leadToCompleteDataResponse(lead);
            leadConverted.setProduct(product);
            leadsConverted.add(leadConverted);
        });

    }
}
