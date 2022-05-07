package cvut.rsp.controller;

import cvut.rsp.api.service.IFilterService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.graphql.input.PreferenceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//TODO: NOT USED
@Controller
public class FilterController
{
    @Autowired private IFilterService iService;

    @QueryMapping()
    public List<Musical> filter(@Argument PreferenceInput preference) { return iService.filter(preference); }
}
