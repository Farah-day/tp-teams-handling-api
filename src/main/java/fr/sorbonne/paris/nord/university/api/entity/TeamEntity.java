package fr.sorbonne.paris.nord.university.api.entity;
import javax.persistence.*;

@Entity
@Table(name="team")
public class TeamEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="slogan")
    private String slogan;

    public TeamEntity(Long id, String name, String slogan){
        this.id=id;
        this.name=name;
        this.slogan=slogan;
    }

    public TeamEntity(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public TeamEntity(){}


    public TeamEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TeamEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getName(String name) {
        return name;
    }

    public TeamEntity setSlogan(String slogan) {
        this.slogan = slogan;
        return this;
    }

    public String getSlogan(String slogan) {
        return slogan;
    }

    public String getName() {
        return this.name;
    }

    public String getSlogan() {
        return this.slogan;
    }

}
