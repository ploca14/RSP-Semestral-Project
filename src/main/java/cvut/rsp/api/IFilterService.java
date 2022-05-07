package cvut.rsp.api;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;

import java.util.List;

public interface IFilterService
{
    List<Musical> filter(Preference preference);
}
