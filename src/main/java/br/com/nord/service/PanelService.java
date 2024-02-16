package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.model.Panel;
import br.com.nord.repository.PanelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanelService {

    private final PanelRepository panelRepository;

    public List<Panel> findAll() {
        return panelRepository.findAll();
    }

    public Panel save(Panel panel) {
        return panelRepository.save(panel);
    }

    public Panel findById(Long id) {
        return panelRepository.findById(id).orElseThrow(() -> new NotFoundException("Panel not found"));
    }

    public void delete(Long id) {
        var panel = findById(id);
        panelRepository.delete(panel);
    }

    public void update(Panel panelToUpdate) {
        assertPanelExists(panelToUpdate);
        panelRepository.save(panelToUpdate);
    }

    private void assertPanelExists(Panel panel) {
        findById(panel.getId());
    }

}
