/*
package cvut.rsp.controller;

import cvut.rsp.api.IAssortmentService;
import cvut.rsp.api.IMusicalService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class MainController
{
    @Autowired private IAssortmentService iAssortmentService;
    @Autowired private IMusicalService iMusicalService;

    //region Preference request
    //TODO: fill data in 'field' parameter
    //TODO: Change parameter data type
    */
/**
     * User sent data to create preference
     *//*

    @SchemaMapping(typeName="Mutation", field="")
    public Preference createPreference(@Argument Map<String,Object> args)
    {
        //TODO: Implement this method according to given data type
//        return iMusicalService.createPreference(args);
        return null;
    }
    //endregion

    //region Musical requests
    //TODO: fill data in 'field' parameter
    */
/**
     * When user skipped preference creation
     *//*

    @SchemaMapping(typeName="Query", field="")
    public List<Musical> getMusicals() { return iMusicalService.getMusicals(); }

    //TODO: fill data in 'field' parameter
    */
/**
     * When user created preference
     *//*

    @SchemaMapping(typeName="Query", field="")
    public List<Musical> getMusicals(@Argument Preference preference) { return iMusicalService.getMusicals(preference); }
    //endregion

    //region Assortment requests
    //TODO: Decide if wrapper entity 'Assortment' should be created

//    //fill data in 'field' parameter
//    @SchemaMapping(typeName="Query", field="")
//    public void getAssortment()
//    {
//        var actors = getActors();
//        var producers = getProducers();
//        var directors = getDirector();
//        var musicalTypes = getMusicalTypes();
//        var musicalGenres = getMusicalGenres();
//        var musicalAtmospheres = getMusicalAtmospheres();
//
//        return new Assortment(actors, producers, directors, musicalTypes, musicalGenres, musicalAtmospheres);
//    }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public List<Actor> getActors() { return iAssortmentService.getActors(); }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public List<Producer> getProducers() { return iAssortmentService.getProducers(); }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public List<Director> getDirector() { return iAssortmentService.getDirectors(); }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public MusicalType[] getMusicalTypes() { return iAssortmentService.getMusicalTypes(); }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public MusicalGenre[] getMusicalGenres() { return iAssortmentService.getMusicalGenres(); }

    //TODO: fill data in 'field' parameter
    @SchemaMapping(typeName="Query", field="")
    public MusicalAtmosphere[] getMusicalAtmospheres() { return iAssortmentService.getMusicalAtmospheres(); }
    //endregion
}
*/
