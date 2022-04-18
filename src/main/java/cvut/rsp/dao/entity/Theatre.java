package cvut.rsp.dao.entity;

import cvut.rsp.dao.entity.abstraction.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "theatres")
public class Theatre extends AbstractEntity
{
    private String name;
    private String webURL;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "theatre")
    private List<Musical> musicals;

    //region getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getWebURL() { return webURL; }
    public void setWebURL(String webURL) { this.webURL = webURL; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public List<Musical> getMusicals() { return musicals; }
    public void setMusicals(List<Musical> musicals) { this.musicals = musicals; }
    //endregion
}
