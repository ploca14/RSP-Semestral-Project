package cvut.rsp.controller;

import cvut.rsp.api.IMusicalService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.dao.entity.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MusicalController
{
    //TODO TADY BUDE POTŘEBA PŘEDĚLAT ARGUMENTY Z OBJEKŮ NA STRINGY, PROTOŽE DO GRAPHQL NEMŮŽEŠ DÁT TYPY

    @Autowired
    private IMusicalService iService;

    @SchemaMapping(typeName="Query", field="musicals")
    public List<Musical> getMusicals() { return iService.getMusicals(); }

    @SchemaMapping(typeName="Query", field="musicalsByPreference")
    public List<Musical> getMusicalsByPreference(@Argument Preference preference) { return iService.getMusicals(preference); }
}
