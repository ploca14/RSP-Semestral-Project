package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Seat extends AbstractEntity
{
    private int row;
    private int number;
    private boolean available;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    //region getters and setters
    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    //endregion
}
