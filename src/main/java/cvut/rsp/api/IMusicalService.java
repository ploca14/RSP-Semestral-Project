package cvut.rsp.api;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;

import java.util.List;

public interface IMusicalService
{
    List<Musical> getMusicals();
    List<Musical> getMusicals(Preference preference);

    //TODO: Implement
    // Preference createPreference(Map<String,Object> args);
}
