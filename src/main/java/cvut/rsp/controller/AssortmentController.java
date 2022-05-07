package cvut.rsp.controller;

import cvut.rsp.api.IAssortmentService;
import cvut.rsp.dao.entity.Post;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AssortmentController
{
    @Autowired
    private IAssortmentService iService;

    @SchemaMapping(typeName="Query", field="actors")
    public List<Actor> getActors() { return iService.getActors(); }

    @SchemaMapping(typeName="Query", field="producers")
    public List<Producer> getProducers() { return iService.getProducers(); }

    @SchemaMapping(typeName="Query", field="directors")
    public List<Director> getDirectors() { return iService.getDirectors(); }

    @SchemaMapping(typeName="Query", field="musicalAtmospheres")
    public MusicalAtmosphere[] getMusicalAtmospheres() { return iService.getMusicalAtmospheres(); }

    @SchemaMapping(typeName="Query", field="musicalGenres")
    public MusicalGenre[] getMusicalGenres() { return iService.getMusicalGenres(); }

    @SchemaMapping(typeName="Query", field="musicalTypes")
    public MusicalType[] getMusicalTypes() { return iService.getMusicalTypes(); }
}
