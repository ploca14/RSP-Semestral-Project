package cvut.rsp.service;

import cvut.rsp.api.IPreferenceService;
import cvut.rsp.dao.entity.Preference;
import cvut.rsp.dao.entity.people.Actor;
import cvut.rsp.dao.entity.people.Director;
import cvut.rsp.dao.entity.people.Producer;
import cvut.rsp.dao.repository.IPreferenceRepository;
import cvut.rsp.enums.MusicalAtmosphere;
import cvut.rsp.enums.MusicalGenre;
import cvut.rsp.enums.MusicalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PreferenceService implements IPreferenceService
{
    @Autowired
    IPreferenceRepository iRepository;

    @Transactional
    @Override
    public Preference create(List<Producer> producers, List<Actor> actors, List<Director> directors, Set<MusicalType> musicalTypes, Set<MusicalGenre> musicalGenres, Set<MusicalAtmosphere> musicalAtmospheres)
    {
        return null;
    }

    @Transactional
    @Override
    public Preference find(Long id)
    {
        //TODO: Implement using IPreferenceRepository
        return iRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Preference update(Long id)
    {
        //TODO: Implement using IPreferenceRepository
        return null;
    }

    @Transactional
    @Override
    public void delete(Long id)
    {
        iRepository.delete(find(id));
    }
}
