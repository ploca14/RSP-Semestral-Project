package cvut.rsp.controller;

import cvut.rsp.api.IFilterService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FilterController
{
    //TODO TADY BUDE POTŘEBA PŘEDĚLAT ARGUMENTY Z OBJEKŮ NA STRINGY, PROTOŽE DO GRAPHQL NEMŮŽEŠ DÁT TYPY

    @Autowired
    private IFilterService iService;

    @SchemaMapping(typeName="Query", field="filter")
    public List<Musical> filter(@Argument Preference preference) { return iService.filter(preference); }

}
