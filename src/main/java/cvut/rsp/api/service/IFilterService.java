package cvut.rsp.api.service;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import cvut.rsp.graphql.input.SortInput;

import java.util.List;

public interface IFilterService
{
    List<Musical> filterRandom(Integer limit);

    List<Musical> filter(PreferenceInput preference);

    Musical filter(Long id);

    List<Musical> sortMusicalsByPrice(SortInput sortInput);

    List<Musical> sortMusicalsByDate(SortInput sortInput);
}
