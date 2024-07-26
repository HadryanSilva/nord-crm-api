package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.lead.LeadPostRequest;
import br.com.nord.api.mapper.response.lead.LeadGetResponse;
import br.com.nord.api.mapper.response.lead.LeadPostResponse;
import br.com.nord.api.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/leads")
public class LeadController {

    private final LeadService leadService;

    @GetMapping
    public ResponseEntity<List<LeadGetResponse>> findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(leadService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadGetResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(leadService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LeadPostResponse> save(@RequestBody LeadPostRequest request) {
        var leadSaved = leadService.save(request);
        return ResponseEntity.created(URI.create("/api/v1/leads/" + leadSaved.getId()))
                .body(leadSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        leadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody LeadPostRequest request) {
        leadService.update(id, request);
        return ResponseEntity.noContent().build();
    }

}
