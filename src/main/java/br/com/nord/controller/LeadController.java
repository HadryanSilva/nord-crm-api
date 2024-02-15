package br.com.nord.controller;

import br.com.nord.mapper.LeadMapper;
import br.com.nord.mapper.request.lead.LeadPostRequest;
import br.com.nord.mapper.request.lead.LeadPutRequest;
import br.com.nord.mapper.response.lead.LeadCompleteDataResponse;
import br.com.nord.mapper.response.lead.LeadGetResponse;
import br.com.nord.mapper.response.lead.LeadPostResponse;
import br.com.nord.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/lead", "/api/v1/lead/"})
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;
    private final LeadMapper mapper;

    @GetMapping("/last-five")
    public ResponseEntity<List<LeadCompleteDataResponse>> findLastFiveLeads() {
        var leads = leadService.findLastFiveByOrderByCreatedAtDesc();
        return ResponseEntity.status(201).body(leads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadGetResponse> findById(@PathVariable Long id) {
        var leadFound = leadService.findById(id);
        var leadConverted = mapper.leadToGetResponse(leadFound);
        return ResponseEntity.status(201).body(leadConverted);
    }

    @PostMapping
    public ResponseEntity<LeadPostResponse> save(@RequestBody LeadPostRequest request) {
        var leadConverted = mapper.postToLead(request);
        var leadSaved = leadService.save(leadConverted);
        return ResponseEntity.status(201).body(mapper.leadToPostResponse(leadSaved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        leadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody LeadPutRequest request) {
        var leadConverted = mapper.putToLead(request);
        leadService.update(leadConverted);
        return ResponseEntity.noContent().build();
    }

}
