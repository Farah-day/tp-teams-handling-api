package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    
    @Test
    public void shouldReturnTrueWhenGetTeamsIsFine(){
        List<TeamEntity> teams = teamService.getTeams();
        assertThat(teams).isNotNull().isNotEmpty();
    }

    @Test
    public void shouldReturnTrueWhenGetTeamByIDIsFine(){
        // Given.
        String given = "Barcelone";
        // When.
        Long id = 3L;
        TeamEntity result  = teamService.getTeamById(id);
        // Then.
        assertThat(result.getName()).isEqualTo(given);
    }

    @Test
    public void shouldReturnTrueWhenInsertIsFine(){
        // Given.
        String name = "Equipe";
        String slogan = "Ouais!";
        // When.
        Long id = 6L;
        teamService.insertTeam(id, name, slogan);
        // Then.
        assertThat(teamService.getTeamById(id)).isNotEqualTo(null);
    }

    @Test
    public void shouldReturnTrueWhenUpdateIsFine(){
        // Given.
        Long id = 1L;
        TeamEntity oldTeam  = teamService.getTeamById(id);
        String oldName = oldTeam.getName();
        String oldSlogan = oldTeam.getSlogan();
        String newName = "Equipe";
        String newSlogan = "Ouais!";

        // When.
        teamService.updateTeam(id, newName, newSlogan);
        TeamEntity newTeam = teamService.getTeamById(id);
        // Then.
        assertThat(oldName).isNotEqualTo(newTeam.getName());
        //assertThat(oldSlogan).isNotEqualTo(newTeam.orElseThrow().getSlogan());
    }

    /*
    @Test
    public void shouldReturnTrueWhenDeleteIsFine(){
        // Given.
        final var id = 1L;

        // When.
        teamService.deleteTeamById(id);

        // Then.
        final ThrowableAssert.ThrowingCallable callable = () -> teamService.getTeamById(id);

        assertThat(teamService.getTeamById(id)).isEqualTo(null);
    }
    */
}
