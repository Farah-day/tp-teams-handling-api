package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService{

    private TeamRepository teamRepository;

    @Autowired
    public void TeamService(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }

    public List<TeamEntity> getTeams(){
        return teamRepository.findAll();
    }

    public TeamEntity getTeamById(Long id){
            return teamRepository.findById(id).get();
    }

    public TeamEntity insertTeam(Long id, String name,String slogan){
        TeamEntity document = new TeamEntity(id,name,slogan);
        return teamRepository.save(document);
    }

    public TeamEntity updateTeam(Long id, String name,String slogan){
        TeamEntity document = new TeamEntity(id,name,slogan);
        return teamRepository.save(document);
    }

    public void deleteTeamById(Long id){
        teamRepository.deleteById(id);
    }


    public TeamEntity insertTeam(TeamEntity teamToSave) {
        return teamRepository.save(teamToSave);
    }

    public TeamEntity updateTeam(TeamEntity teamToUpdate) {
        return this.updateTeam(teamToUpdate.getId(), teamToUpdate.getName(),teamToUpdate.getSlogan());
    }
}
