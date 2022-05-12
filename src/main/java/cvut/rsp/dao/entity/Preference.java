package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Preference extends AbstractEntity
{
    @ManyToMany
    @JoinTable(name = "preference_producer",
            joinColumns = @JoinColumn(name = "preference_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private List<Producer> producers;

    @ManyToMany
    @JoinTable(name = "preference_actor",
            joinColumns = @JoinColumn(name = "preference_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(name = "preference_director",
            joinColumns = @JoinColumn(name = "preference_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Director> directors;

    @ElementCollection(targetClass = MusicalType.class)
    @JoinTable(name = "musical_type_preference",
            joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "musical_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<MusicalType> musicalTypes;

    @ElementCollection(targetClass = MusicalGenre.class)
    @JoinTable(name = "musical_genre_preference",
            joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "musical_genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<MusicalGenre> musicalGenres;

    @ElementCollection(targetClass = MusicalAtmosphere.class)
    @JoinTable(name = "musical_atmosphere_preference",
            joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "musical_atmosphere", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<MusicalAtmosphere> musicalAtmospheres;

    //region getters and setters
    public List<Producer> getProducers() { return producers; }
    public void setProducers(List<Producer> producers) { this.producers = producers; }
    public List<Actor> getActors() { return actors; }
    public void setActors(List<Actor> actors) { this.actors = actors; }
    public List<Director> getDirectors() { return directors; }
    public void setDirectors(List<Director> directors) { this.directors = directors; }
    public Set<MusicalType> getMusicalTypes() { return musicalTypes; }
    public void setMusicalTypes(Set<MusicalType> musicalTypes) { this.musicalTypes = musicalTypes; }
    public Set<MusicalGenre> getMusicalGenres() { return musicalGenres; }
    public void setMusicalGenres(Set<MusicalGenre> musicalGenres) { this.musicalGenres = musicalGenres; }
    public Set<MusicalAtmosphere> getMusicalAtmospheres() { return musicalAtmospheres; }
    public void setMusicalAtmospheres(Set<MusicalAtmosphere> musicalAtmospheres) { this.musicalAtmospheres = musicalAtmospheres; }
    //endregion
}
