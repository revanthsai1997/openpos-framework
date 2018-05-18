package org.jumpmind.pos.tax.model;

import java.math.BigDecimal;

/**
 * A line item component of a RETAIL TRANSACTION that records the charging and
 * offsetting liability credit for sales tax on merchandise items and services
 * sold by the store or debit for merchandise returned to the store.
 * 
 * @author elong
 * 
 */
public class TaxLineItem extends RetailTransactionLineItem {

    private TaxAuthority taxAuthority;

    private TaxableGroup taxableGroup;

    private BigDecimal taxableAmount;

    private BigDecimal taxAmount;

    private BigDecimal taxPercent;

    private TaxExemptionModifier taxExemptionModifier;

    private TaxOverrideModifier taxOverrideModifier;

    public TaxLineItem() {
    }

    public TaxLineItem(SaleReturnTaxLineItem taxLineItem) {
        taxAuthority = taxLineItem.getTaxAuthority();
        taxableGroup = taxLineItem.getTaxableGroup();
        taxableAmount = taxLineItem.getTaxableAmount();
        taxAmount = taxLineItem.getTaxAmount();
        taxPercent = taxLineItem.getTaxPercent();
    }

    public void add(SaleReturnTaxLineItem taxLineItem) {
        if (taxableAmount == null) {
            taxableAmount = BigDecimal.ZERO;
        }
        if (taxAmount == null) {
            taxAmount = BigDecimal.ZERO;
        }
        taxableAmount = taxableAmount.add(taxLineItem.getTaxAmount());
        taxAmount = taxAmount.add(taxLineItem.getTaxAmount());
    }

    public BigDecimal getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public TaxableGroup getTaxableGroup() {
        return taxableGroup;
    }

    public void setTaxableGroup(TaxableGroup taxableGroup) {
        this.taxableGroup = taxableGroup;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public TaxAuthority getTaxAuthority() {
        return taxAuthority;
    }

    public void setTaxAuthority(TaxAuthority taxAuthority) {
        this.taxAuthority = taxAuthority;
    }

    public TaxExemptionModifier getTaxExemptionModifier() {
        return taxExemptionModifier;
    }

    public void setTaxExemptionModifier(TaxExemptionModifier taxExemptionModifier) {
        this.taxExemptionModifier = taxExemptionModifier;
    }

    public TaxOverrideModifier getTaxOverrideModifier() {
        return taxOverrideModifier;
    }

    public void setTaxOverrideModifier(TaxOverrideModifier taxOverrideModifier) {
        this.taxOverrideModifier = taxOverrideModifier;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }

}