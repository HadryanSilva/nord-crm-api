package br.com.nord.api.service;

import br.com.nord.api.exception.NotFoundException;
import br.com.nord.api.mapper.LeadMapper;
import br.com.nord.api.mapper.request.lead.LeadPostRequest;
import br.com.nord.api.mapper.response.lead.LeadGetResponse;
import br.com.nord.api.mapper.response.lead.LeadPostResponse;
import br.com.nord.api.model.Lead;
import br.com.nord.api.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class LeadService {

    private final LeadRepository leadRepository;

    private final LeadMapper leadMapper;

    public List<LeadGetResponse> findAll(int page, int size) {
        log.info("Finding all leads");
        return leadRepository
                .findAll(PageRequest.of(page, size))
                .stream()
                .map(leadMapper::leadToGetResponse)
                .toList();
    }

    public LeadGetResponse findById(Long id) {
        log.info("Finding lead by id: {}", id);
        var lead = leadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lead not found"));
        return leadMapper.leadToGetResponse(lead);
    }

    public LeadPostResponse save(LeadPostRequest request) {
        log.info("Saving lead: {}", request);
        Lead lead = leadMapper.postRequestToLead(request);
        lead = leadRepository.save(lead);
        return leadMapper.leadToPostResponse(lead);
    }

    public void delete(Long id) {
        log.info("Deleting lead with id: {}", id);
        var leadFound = leadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lead not found"));
        leadRepository.delete(leadFound);
    }

    public void update(Long id, LeadPostRequest request) {
        log.info("Updating lead with id: {}", id);
        var leadFound = leadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lead not found"));
        leadFound.setStatus(request.getStatus());
        leadRepository.save(leadFound);
    }

}
