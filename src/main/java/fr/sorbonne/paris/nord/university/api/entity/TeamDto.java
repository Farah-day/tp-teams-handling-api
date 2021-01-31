package fr.sorbonne.paris.nord.university.api.entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TeamDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    public String name;
    @Column(name="slogan")
    public String slogan;

    private TeamEntity teamEntity;

    public TeamDto(String name, String slogan) {
        this.name=name;
        this.slogan=slogan;
    }

    public TeamDto(Long id, String name, String slogan) {
        this.id =id;
        this.name=name;
        this.slogan=slogan;
    }

    public Long getId() {
        return teamEntity.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return teamEntity.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return teamEntity.getSlogan();
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
