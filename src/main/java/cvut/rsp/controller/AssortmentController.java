package cvut.rsp.controller;

import cvut.rsp.api.service.IAssortmentService;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AssortmentController
{
    @Autowired private IAssortmentService iService;

    @QueryMapping()
    public List<Actor> actors() { return iService.getActors(); }

    @QueryMapping()
    public List<Producer> producers() { return iService.getProducers(); }

    @QueryMapping()
    public List<Director> directors() { return iService.getDirectors(); }

    //TODO: NOT USED
    @QueryMapping()
    public MusicalAtmosphere[] musicalAtmospheres() { return iService.getMusicalAtmospheres(); }

    //TODO: NOT USED
    @QueryMapping()
    public MusicalGenre[] musicalGenres() { return iService.getMusicalGenres(); }

    //TODO: NOT USED
    @QueryMapping()
    public MusicalType[] musicalTypes() { return iService.getMusicalTypes(); }
}
