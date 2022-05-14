package cvut.rsp.controller;

import cvut.rsp.api.service.IMusicalService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import cvut.rsp.graphql.input.SortInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MusicalController
{
    @Autowired
    private IMusicalService iService;

    @QueryMapping()
    public List<Musical> musicals(@Argument Integer limit) { return iService.getMusicals(limit); }

    @QueryMapping()
    public List<Musical> musicalsByPreference(@Argument PreferenceInput preference) { return iService.getMusicals(preference); }

    @QueryMapping()
    public Musical musicalById(@Argument Long id) { return iService.getMusical(id); }

    @QueryMapping()
    public List<Musical> sortMusicalsByPrice(@Argument SortInput sortInput) { return iService.sortMusicalsByPrice(sortInput); }

    @QueryMapping()
    public List<Musical> sortMusicalsByDate(@Argument SortInput sortInput) { return iService.sortMusicalsByDate(sortInput); }

}
