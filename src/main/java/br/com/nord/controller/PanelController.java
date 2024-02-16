package br.com.nord.controller;

import br.com.nord.mapper.PanelMapper;
import br.com.nord.mapper.response.panel.PanelGetResponse;
import br.com.nord.mapper.response.panel.PanelPostResponse;
import br.com.nord.model.Panel;
import br.com.nord.service.PanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/panel", "/api/v1/panel/"})
@RequiredArgsConstructor
public class PanelController {

    private final PanelService service;
    private final PanelMapper mapper;
    @GetMapping
    public ResponseEntity<List<PanelGetResponse>> findAll() {
        var panels = service.findAll();
        var convertedList = mapper.panelListToGetResponseList(panels);
        return ResponseEntity.ok(convertedList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanelGetResponse> findById(@PathVariable Long id) {
        var panelFound = service.findById(id);
        var panelConverted = mapper.panelToGetResponse(panelFound);
        return ResponseEntity.ok(panelConverted);
    }

    @PostMapping
    public ResponseEntity<PanelPostResponse> save(@RequestBody Panel panel) {
        var panelSaved = service.save(panel);
        var panelConverted = mapper.panelToPostResponse(panelSaved);
        return ResponseEntity.status(201).body(panelConverted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Panel panel) {
        service.update(panel);
        return ResponseEntity.noContent().build();
    }

}
