package cvut.rsp.service;

import cvut.rsp.api.IAssortmentService;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.dao.repository.IActorRepository;
import cvut.rsp.dao.repository.IDirectorRepository;
import cvut.rsp.dao.repository.IProducerRepository;
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

    @Override
    public List<Actor> getActors() { return iActorRepository.findAll(); }

    @Override
    public List<Producer> getProducers() { return iProducerRepository.findAll(); }

    @Override
    public List<Director> getDirectors() { return iDirectorRepository.findAll(); }

    @Override
    public MusicalType[] getMusicalTypes()
    {
        //TODO: return enum data with request to database or not?
        // Is it necessary to make request to database for enum values or just write code as it is written below
        return MusicalType.values();
    }

    @Override
    public MusicalGenre[] getMusicalGenres()
    {
        //TODO: return enum data with request to database or not?
        // Is it necessary to make request to database for enum values or just write code as it is written below
        return MusicalGenre.values();
    }

    @Override
    public MusicalAtmosphere[] getMusicalAtmospheres()
    {
        //TODO: return enum data with request to database or not?
        // Is it necessary to make request to database for enum values or just write code as it is written below
        return MusicalAtmosphere.values();
    }
}
