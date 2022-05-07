package cvut.rsp.dao.entity.abstraction;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable
{
    @Id
    @GeneratedValue
    protected Long id;

    //#region getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    //#endregion
}

