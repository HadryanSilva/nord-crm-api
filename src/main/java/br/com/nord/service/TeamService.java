package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.model.Team;
import br.com.nord.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TeamService {

    private final TeamRepository teamRepository;

    public Team save(Team team) {
        log.info("Saving team");
        return teamRepository.save(team);
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Team not found"));
    }

    public void delete(Long id) {
        var team = findById(id);
        log.info("Deleting team with id {}", id);
        teamRepository.delete(team);
        log.info("Team deleted successfully");
    }

    public void update(Team teamToUpdate) {
        assertTeamExists(teamToUpdate);
        log.info("Updating team with id {}", teamToUpdate.getId());
        teamRepository.save(teamToUpdate);
        log.info("Team updated successfully");
    }

    private void assertTeamExists(Team team) {
        findById(team.getId());
    }

}
