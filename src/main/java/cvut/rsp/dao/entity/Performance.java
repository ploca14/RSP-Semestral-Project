package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Performance extends AbstractEntity
{
    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "musical_id")
    private Musical musical;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    //region getters and setters
    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
    public Musical getMusical() { return musical; }
    public void setMusical(Musical musical) { this.musical = musical; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    //endregion
}
