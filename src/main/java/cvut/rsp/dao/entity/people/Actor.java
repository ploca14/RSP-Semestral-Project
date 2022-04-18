package cvut.rsp.dao.entity.people;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.abstraction.Person;
import cvut.rsp.enums.PersonType;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("ACTOR")
public class Actor extends Person
{
    @ManyToMany(mappedBy = "actors")
    private List<Preference> preferences;

    @ManyToMany
    @JoinTable(name = "musicals", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "musical_id"))
    private List<Musical> musicals;

    //region getters and setters
    public List<Preference> getPreferences() { return preferences; }
    public void setPreferences(List<Preference> preferences) { this.preferences = preferences; }
    public List<Musical> getMusicals() { return musicals; }
    public void setMusicals(List<Musical> musicals) { this.musicals = musicals; }

    @Override public PersonType getPersonType() { return PersonType.ACTOR; }
    //endregion
}
