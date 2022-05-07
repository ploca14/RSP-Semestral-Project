package cvut.rsp.graphql.mutation;

import cvut.rsp.api.IPreferenceService;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class PreferenceMutation
{
    //TODO TADY BUDE POTŘEBA PŘEDĚLAT ARGUMENTY Z OBJEKŮ NA STRINGY, PROTOŽE DO GRAPHQL NEMŮŽEŠ DÁT TYPY

    @Autowired
    private IPreferenceService iService;

    public Preference create(List<Producer> producers, List<Actor> actors, List<Director> directors, Set<MusicalType> musicalTypes, Set<MusicalGenre> musicalGenres, Set<MusicalAtmosphere> musicalAtmospheres) { return iService.create(producers, actors, directors, musicalTypes, musicalGenres, musicalAtmospheres); }

}
