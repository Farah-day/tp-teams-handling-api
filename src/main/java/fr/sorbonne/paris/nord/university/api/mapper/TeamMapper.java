package fr.sorbonne.paris.nord.university.api.mapper;
import fr.sorbonne.paris.nord.university.api.entity.TeamDto;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {
    public TeamMapper() {
    }

    private TeamMapper teamMapper;

    @Autowired
    public void TeamMapper(TeamMapper teamMapper){
        this.teamMapper=teamMapper;
    }

    public TeamEntity toEntity(TeamDto teamDto){
        return new TeamEntity(teamDto.getName(), teamDto.getSlogan());
    }

    public TeamDto toDto(TeamEntity teamEntity){
        return new TeamDto(teamEntity.getName(), teamEntity.getSlogan());
    }
}
