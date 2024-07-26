package br.com.nord.api.service;

import br.com.nord.api.exception.NotFoundException;
import br.com.nord.api.mapper.PanelMapper;
import br.com.nord.api.mapper.request.panel.PanelPostRequest;
import br.com.nord.api.mapper.response.panel.PanelGetResponse;
import br.com.nord.api.mapper.response.panel.PanelPostResponse;
import br.com.nord.api.repository.PanelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class PanelService {

    private final PanelRepository panelRepository;
    private final PanelMapper panelMapper;

    public List<PanelGetResponse> findAll(int page, int size) {
        log.info("Listing all panels");
        return panelRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(panelMapper::panelToGetResponse)
                .toList();
    }

    public PanelGetResponse findById(Long id) {
        log.info("Findig panel by id: {}", id);
        var panelFound = panelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Panel not found"));
        return panelMapper.panelToGetResponse(panelFound);
    }

    public PanelPostResponse save(PanelPostRequest request) {
        log.info("Saving panel: {}", request);
        var panelToSave = panelMapper.postToPanel(request);
        var panelSaved = panelRepository.save(panelToSave);
        return panelMapper.panelToPostResponse(panelSaved);
    }

    public void delete(Long id) {
        log.info("Deleting panel by id: {}", id);
        var panelFound = panelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Panel not found"));
        panelRepository.delete(panelFound);
    }

    public void update(Long id, PanelPostRequest request) {
        log.info("Updating panel by id: {}", id);
        var panelFound = panelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Panel not found"));
        panelFound.setName(request.getName());
        panelRepository.save(panelFound);
    }

}
