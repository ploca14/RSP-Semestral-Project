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
    protected Integer id;

    //#region getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    //#endregion
}

