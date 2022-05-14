package cvut.rsp.service;

import cvut.rsp.api.service.IFilterService;
import cvut.rsp.api.service.IMusicalService;
import cvut.rsp.api.service.IPreferenceService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import cvut.rsp.graphql.input.SortInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicalService implements IMusicalService
{
    @Autowired private IPreferenceService iPreferenceService;
    @Autowired private IFilterService iFilterService;

    private static Integer LIMIT = 10;

    @Transactional(readOnly = true)
    @Override public Musical getMusical(Long id) { return iFilterService.filter(id); }

    @Transactional(readOnly = true)
    @Override public List<Musical> getMusicals(Integer limit) { return randomMusicals(LIMIT); }

    @Transactional(readOnly = true)
    @Override public List<Musical> getMusicals(PreferenceInput preferenceInput)
    {
        if(preferenceInput == null) { return randomMusicals(LIMIT); }

        var musicals = iFilterService.filter(preferenceInput);

        if(musicals == null) { return randomMusicals(LIMIT); }
        if(musicals.isEmpty()) { return randomMusicals(LIMIT); }

        return musicals;
    }

    @Transactional(readOnly = true)
    @Override public List<Musical> sortMusicalsByPrice(SortInput sortInput){
        return iFilterService.sortMusicalsByPrice(sortInput);
    }

    @Transactional(readOnly = true)
    @Override public List<Musical> sortMusicalsByDate(SortInput sortInput){
        return iFilterService.sortMusicalsByDate(sortInput);
    }

    //TODO: Implement random filtering
    private List<Musical> randomMusicals(Integer limit)
    {
        return iFilterService.filterRandom(limit);
    }
}
