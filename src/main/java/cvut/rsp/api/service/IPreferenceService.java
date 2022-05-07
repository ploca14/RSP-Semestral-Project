package cvut.rsp.api.service;

import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;

import java.util.List;
import java.util.Set;

public interface IPreferenceService
{
    Preference create(List<Producer> producers, List<Actor> actors, List<Director> directors,
                      Set<MusicalType> musicalTypes, Set<MusicalGenre> musicalGenres, Set<MusicalAtmosphere> musicalAtmospheres);
    Preference find(Long id);
    Preference update(Long id);
    void delete(Long id);
}
