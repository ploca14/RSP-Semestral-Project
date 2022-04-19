package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Performance extends AbstractEntity
{
    @OneToMany(mappedBy = "performance")
    private List<Ticket> ticket;

    @ManyToMany
    @JoinTable(name = "musicals", joinColumns = @JoinColumn(name = "performance_id"), inverseJoinColumns = @JoinColumn(name = "musical_id"))
    private List<Musical> musicals;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    //region getters and setters
    public List<Ticket> getTicket() { return ticket; }
    public void setTicket(List<Ticket> ticket) { this.ticket = ticket; }
    public List<Musical> getMusicals() { return musicals; }
    public void setMusicals(List<Musical> musicals) { this.musicals = musicals; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    //endregion
}
