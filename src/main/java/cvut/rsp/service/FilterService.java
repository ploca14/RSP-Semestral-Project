package cvut.rsp.service;

import cvut.rsp.api.IFilterService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService implements IFilterService
{
    @Override
    public List<Musical> filter(Preference preference)
    {
        //TODO: find musicals by preference properties
        // return IPreferenceRepository.customMethod(preference);
        return null;
    }
}
