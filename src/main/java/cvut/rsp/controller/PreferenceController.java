package cvut.rsp.controller;

import cvut.rsp.api.service.IPreferenceService;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.*;

//TODO: NOT USED
@Controller
public class PreferenceController
{
    //TODO TADY BUDE POTŘEBA PŘEDĚLAT ARGUMENTY Z OBJEKŮ NA STRINGY, PROTOŽE DO GRAPHQL NEMŮŽEŠ DÁT TYPY
    //PŘ:
    //@SchemaMapping(typeName="PreferenceMutation", field="createPreference")
    //public Preference create(@Argument String producers, String actors, @Argument String directors, @Argument String musicalTypes, @Argument String musicalGenres, @Argument String musicalAtmospheres) { return iService.create(producers, actors, directors, musicalTypes, musicalGenres, musicalAtmospheres); }

    @Autowired private IPreferenceService iService;

    @MutationMapping()
    public Preference createPreference(@Argument List<Producer> producers, @Argument List<Actor> actors, @Argument List<Director> directors, @Argument Set<MusicalType> musicalTypes, @Argument Set<MusicalGenre> musicalGenres, @Argument Set<MusicalAtmosphere> musicalAtmospheres) { return iService.create(producers, actors, directors, musicalTypes, musicalGenres, musicalAtmospheres); }

    //TODO: NOT USED
    @QueryMapping()
    public Preference preference(@Argument Long id) { return iService.find(id); }

    //TODO: NOT USED
    @QueryMapping()
    public Preference updatePreference(@Argument Long id) { return iService.update(id); }
}
