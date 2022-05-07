package cvut.rsp.api.service;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;

import java.util.List;

public interface IFilterService
{
    List<Musical> filterRandom(Integer limit);

    List<Musical> filter(PreferenceInput preference);

    Musical filter(Long id);
}
