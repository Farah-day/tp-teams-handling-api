package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TeamControllerTest {

    private final TeamEntity teamEntity = new TeamEntity("NameTest", "SloganTest");

    @Autowired
    private TeamMapper teamMapper;

    @Mock
    private TeamService teamService;


    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(new TeamController(teamService, teamMapper));
    }

    @Test
    public void shouldReturn200WhenGetTeamsIsFine(){
        when(teamService.getTeams()).thenReturn(List.of(teamEntity));
        given()
                .when()
                .get("/teams")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturn200WhenGetTeamByIdIsFine(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/teams/{id}", 2L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturn200WhenInserted(){
        // Given.
        final var mockedTeam = new TeamEntity()
                .setId(8L)
                .setName("test")
                .setSlogan("test");

        when(teamService.insertTeam(any())).thenReturn(mockedTeam);

        // When / then.
        final var path = "teams";
        given()
                .contentType(ContentType.JSON)
                .body(mockedTeam)
                .when()
                .post(path)
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturn200WheUpdated(){
        // Given.
        final var id = 1L;
        final var mockedTeam = new TeamEntity()
                .setId(id)
                .setName("test")
                .setSlogan("test");

        when(teamService.updateTeam(any())).thenReturn(mockedTeam);

        // When / then.
        final var path = "teams/{id}";
        given()
                .contentType(ContentType.JSON)
                .body(mockedTeam)
                .when()
                .put("update", mockedTeam)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturn200WhenDeleteIsSuccessful(){
        given()
                .when()
                .delete("delete/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

}
