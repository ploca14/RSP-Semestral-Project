package cvut.rsp.api;

import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;

import java.util.List;

public interface IAssortmentService
{
    //TODO: Assortment getAssortment(); Decide whether new entity 'Assortment' should be created or not

    List<Actor> getActors();
    List<Producer> getProducers();
    List<Director> getDirectors();

    //TODO: return type leave as is OR change to List<Type>?
    MusicalType[] getMusicalTypes();
    MusicalGenre[] getMusicalGenres();
    MusicalAtmosphere[] getMusicalAtmospheres();
}
