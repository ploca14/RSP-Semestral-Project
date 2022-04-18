package cvut.rsp.dao.entity.abstraction;

import cvut.rsp.enums.PersonType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Person extends AbstractEntity
{
    @Basic(optional = false)
    @Column(nullable = false, unique = false)
    private String firstName;

    @Basic(optional = false)
    @Column(nullable = false, unique = false)
    private String lastName;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    //region getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    abstract public PersonType getPersonType();
    //endregion
}
