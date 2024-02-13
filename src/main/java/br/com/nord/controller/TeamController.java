package br.com.nord.controller;

import br.com.nord.mapper.TeamMapper;
import br.com.nord.mapper.request.team.TeamPostRequest;
import br.com.nord.mapper.request.team.TeamPutRequest;
import br.com.nord.mapper.response.team.TeamPostResponse;
import br.com.nord.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/v1/team", "/api/v1/team/"})
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TeamPostResponse> findById(@PathVariable Long id) {
        var teamFound = teamService.findById(id);
        var teamConverted = teamMapper.teamToPostResponse(teamFound);
        return ResponseEntity.ok(teamConverted);
    }

    @PostMapping
    public ResponseEntity<TeamPostResponse> save(@RequestBody TeamPostRequest request) {
        var teamToSave = teamMapper.postToTeam(request);
        var teamSaved = teamService.save(teamToSave);
        var teamConverted = teamMapper.teamToPostResponse(teamSaved);
        return ResponseEntity.status(201).body(teamConverted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody TeamPutRequest request) {
        var teamToUpdate = teamMapper.putToTeam(request);
        teamService.update(teamToUpdate);
        return ResponseEntity.noContent().build();
    }

}
