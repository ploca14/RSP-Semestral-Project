package cvut.rsp.service;

import cvut.rsp.api.service.IAssortmentService;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.api.repository.IActorRepository;
import cvut.rsp.api.repository.IDirectorRepository;
import cvut.rsp.api.repository.IProducerRepository;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssortmentService implements IAssortmentService
{
    @Autowired IActorRepository iActorRepository;
    @Autowired IProducerRepository iProducerRepository;
    @Autowired IDirectorRepository iDirectorRepository;

    @Override public List<Actor> getActors() { return iActorRepository.findAll(); }

    @Override public List<Producer> getProducers() { return iProducerRepository.findAll(); }

    @Override public List<Director> getDirectors() { return iDirectorRepository.findAll(); }

    //TODO: NOT USED
    //TODO: return enum data with request to database or not?
    @Override public MusicalType[] getMusicalTypes() { return MusicalType.values(); }

    //TODO: NOT USED
    //TODO: return enum data with request to database or not?
    @Override public MusicalGenre[] getMusicalGenres() { return MusicalGenre.values(); }

    //TODO: NOT USED
    //TODO: return enum data with request to database or not?
    @Override public MusicalAtmosphere[] getMusicalAtmospheres() { return MusicalAtmosphere.values(); }
}
