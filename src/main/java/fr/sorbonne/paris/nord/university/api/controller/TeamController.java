package fr.sorbonne.paris.nord.university.api.controller;
import fr.sorbonne.paris.nord.university.api.entity.TeamDto;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/teams")
    public List<TeamEntity> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping(value = "/teams/{id}")
    public TeamEntity getTeamById(@PathVariable("id") Long id) {
        return teamService.getTeamById(id);
    }


    @PostMapping(value = "/insert")
    public void insertTeam(TeamEntity teamToInsert) {
        teamService.insertTeam(teamToInsert);
    }

    @PutMapping(value = "/update")
    public void updateTeam(@RequestBody TeamEntity teamToUpdate){
        teamService.updateTeam(teamToUpdate);
    }

    @PutMapping("/teams/{id}")
    public TeamDto updateTeam(@PathVariable Long id, @RequestBody TeamDto team) {
        var teamWithId = new TeamDto(id, team.name, team.slogan);
        final TeamEntity savedTeam = teamService.updateTeam(teamMapper.toEntity(teamWithId));

        return teamMapper.toDto(savedTeam);
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<TeamEntity> createTeam(@RequestBody TeamEntity teamEntity){
        return new ResponseEntity<>(teamService.insertTeam(teamEntity), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTeamById(@PathVariable("id") Long id){
        teamService.deleteTeamById(id);
    }
}
