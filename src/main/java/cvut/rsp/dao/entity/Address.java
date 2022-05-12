package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "address")
public class Address extends AbstractEntity
{
    private String city;
    private String street;
    private int postcode;

    @OneToOne(mappedBy = "address")
    private Theatre theatre;

    //region getters and setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public int getPostcode() { return postcode; }
    public void setPostcode(int postcode) { this.postcode = postcode; }
    public Theatre getTheatre() { return theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }
    //endregion
}
