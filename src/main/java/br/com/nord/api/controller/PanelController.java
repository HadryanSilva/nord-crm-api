package br.com.nord.api.controller;

import br.com.nord.api.mapper.request.panel.PanelPostRequest;
import br.com.nord.api.mapper.response.panel.PanelGetResponse;
import br.com.nord.api.mapper.response.panel.PanelPostResponse;
import br.com.nord.api.service.PanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/panels")
public class PanelController {

    private final PanelService panelService;

    @GetMapping
    public ResponseEntity<List<PanelGetResponse>> findAll(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(panelService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanelGetResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(panelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PanelPostResponse> save(@RequestBody PanelPostRequest request) {
        var panelSaved = panelService.save(request);
        return ResponseEntity.created(URI.create("/api/v1/panels/" + panelSaved.getId()))
                .body(panelSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        panelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody PanelPostRequest request) {
        panelService.update(id, request);
        return ResponseEntity.noContent().build();
    }

}
