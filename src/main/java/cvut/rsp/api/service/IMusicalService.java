package cvut.rsp.api.service;

import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import cvut.rsp.graphql.input.SortInput;

import java.util.List;

public interface IMusicalService
{
    Musical getMusical(Long id);
    List<Musical> getMusicals(Integer limit);
    List<Musical> getMusicals(PreferenceInput preference);
    List<Musical> sortMusicalsByPrice(SortInput sortInput);
    List<Musical> sortMusicalsByDate(SortInput sortInput);
}
