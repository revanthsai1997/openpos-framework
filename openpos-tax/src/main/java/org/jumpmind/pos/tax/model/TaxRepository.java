package org.jumpmind.pos.tax.model;

import java.util.List;

import org.jumpmind.pos.persist.DBSession;
import org.jumpmind.pos.persist.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
@DependsOn(value = { "TaxModule" })
public class TaxRepository {

    private Query<TaxAuthorityRule> taxAuthorityRuleLookup = new Query<TaxAuthorityRule>().named("taxAuthorityRuleLookup")
            .result(TaxAuthorityRule.class);

    @Autowired
    @Qualifier("taxDbSession")
    @Lazy
    private DBSession dbSession;

    public List<TaxAuthorityRule> findTaxAuthorityRules(String taxCalculationGeocode) {
        List<TaxAuthorityRule> taxAuthorityRules = dbSession.query(taxAuthorityRuleLookup, taxCalculationGeocode);
        return taxAuthorityRules;
    }

}