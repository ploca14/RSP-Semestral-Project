package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Musical extends AbstractEntity
{
    private String imageSource;

    private String name;

    private String description;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToMany(mappedBy = "musicals")
    private List<Performance> performances;

    @ManyToMany(mappedBy = "musicals")
    private List<Producer> producers;

    @ManyToMany(mappedBy = "musicals")
    private List<Actor> actors;

    @ManyToMany(mappedBy = "musicals")
    private List<Director> directors;

    @ElementCollection(targetClass = MusicalType.class)
    @CollectionTable(name = "musical_type", joinColumns = @JoinColumn(name = "musical_id"))
    @Enumerated(EnumType.STRING)
    private Set<MusicalType> musicalTypes;

    @ElementCollection(targetClass = MusicalGenre.class)
    @CollectionTable(name = "musical_genre", joinColumns = @JoinColumn(name = "musical_id"))
    @Enumerated(EnumType.STRING)
    private Set<MusicalGenre> musicalGenres;

    @ElementCollection(targetClass = MusicalAtmosphere.class)
    @CollectionTable(name = "musical_atmosphere", joinColumns = @JoinColumn(name = "musical_id"))
    @Enumerated(EnumType.STRING)
    private Set<MusicalAtmosphere> musicalAtmospheres;

    //region getters and setters
    public String getImageSource() { return imageSource; }
    public void setImageSource(String imageSource) { this.imageSource = imageSource; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Theatre getTheatre() { return theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }
    public List<Performance> getPerformances() { return performances; }
    public void setPerformances(List<Performance> performances) { this.performances = performances; }
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
