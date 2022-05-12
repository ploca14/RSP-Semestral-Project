package cvut.rsp.service;

import cvut.rsp.api.service.IFilterService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.api.repository.IMusicalRepository;
import cvut.rsp.graphql.input.PreferenceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FilterService implements IFilterService
{
    @Autowired IMusicalRepository iMusicalRepository;

    @Override public List<Musical> filterRandom(Integer limit)
    {
        var ids = iMusicalRepository.getAllIds();

        if(ids.size() < limit) { return  iMusicalRepository.findAllById(ids); }

        var set = new HashSet<Long>();

        while(set.size() < limit)
        {
            var rand = ThreadLocalRandom.current().nextInt(ids.size());

            set.add(ids.get(rand));
        }
        
        return iMusicalRepository.findAllById(set);
    }

    //TODO: Implement filtering algorithm

    @Override public List<Musical> filter(PreferenceInput preference)
    {
        //TODO: find musicals by preference properties, add them to list and return it

        List<Musical> musicals = new ArrayList<>();

        List<Long> musicalsIds = iMusicalRepository.getAllIds();

        musicalsIds.forEach(e -> musicals.add(iMusicalRepository.findById(e).get()));

        return musicals;
    }

    @Override public Musical filter(Long id) { return iMusicalRepository.findById(id).get(); }
}
