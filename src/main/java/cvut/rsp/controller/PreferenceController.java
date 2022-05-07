package cvut.rsp.controller;

import com.google.common.collect.Sets;
import cvut.rsp.api.IPreferenceService;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class PreferenceController
{
    //TODO TADY BUDE POTŘEBA PŘEDĚLAT ARGUMENTY Z OBJEKŮ NA STRINGY, PROTOŽE DO GRAPHQL NEMŮŽEŠ DÁT TYPY
    //PŘ:
    //@SchemaMapping(typeName="PreferenceMutation", field="createPreference")
    //public Preference create(@Argument String producers, String actors, @Argument String directors, @Argument String musicalTypes, @Argument String musicalGenres, @Argument String musicalAtmospheres) { return iService.create(producers, actors, directors, musicalTypes, musicalGenres, musicalAtmospheres); }

    @Autowired
    private IPreferenceService iService;

    @SchemaMapping(typeName="Mutation", field="createPreference")
    public Preference create(@Argument List<Producer> producers, @Argument List<Actor> actors, @Argument List<Director> directors, @Argument Set<MusicalType> musicalTypes, @Argument Set<MusicalGenre> musicalGenres, @Argument Set<MusicalAtmosphere> musicalAtmospheres) { return iService.create(producers, actors, directors, musicalTypes, musicalGenres, musicalAtmospheres); }

//    @SchemaMapping(typeName="Mutation", field="createPreference")
//    public Preference create(@Argument Map<String, Object> map)
//    {
//        var producers = map.get("producers");
//        return iService.create(map);
//    }


    @SchemaMapping(typeName="Query", field="preference")
    public Preference find(@Argument Long id) { return iService.find(id); }

    @SchemaMapping(typeName="Query", field="updatePreference")
    public Preference update(@Argument Long id) { return iService.update(id); }
}
