package cvut.rsp.service;

import cvut.rsp.api.IFilterService;
import cvut.rsp.api.IMusicalService;
import cvut.rsp.api.IPreferenceService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicalService implements IMusicalService
{
    @Autowired private IPreferenceService iPreferenceService;
    @Autowired private IFilterService iFilterService;

    @Transactional(readOnly = true)
    @Override public List<Musical> getMusicals() { return getMusicals(null); }

    /***
     * If argument is equal to null, then return value is random musicals
     * Else service returns musicals filtered by preference
     *
     * @param userPreference
     * @return
     */
    @Transactional(readOnly = true)
    @Override public List<Musical> getMusicals(Preference userPreference)
    {
        if(userPreference == null) { return randomMusicals(); }

        var musicals = iFilterService.filter(userPreference);

        //TODO: if musicals == null -> Choose random musicals;

        return musicals;
    }

    //TODO: Implement random filtering
    private List<Musical> randomMusicals()
    {
        return null;
    }
}
