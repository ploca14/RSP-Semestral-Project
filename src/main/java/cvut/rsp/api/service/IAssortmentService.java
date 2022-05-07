package cvut.rsp.api.service;

import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;

import java.util.List;

public interface IAssortmentService
{
    List<Actor> getActors();
    List<Producer> getProducers();
    List<Director> getDirectors();

    //TODO: return type leave as is OR change to List<Type>?
    //TODO: NOT USED
    MusicalType[] getMusicalTypes();
    MusicalGenre[] getMusicalGenres();
    MusicalAtmosphere[] getMusicalAtmospheres();
}
