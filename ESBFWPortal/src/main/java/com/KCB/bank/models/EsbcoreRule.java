/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author PMMuthama
 */
@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Table(name = "ESBCORE_RULE")
@Table(name = "ESBCORE_RULE",schema="SYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreRule.findAll", query = "SELECT e FROM EsbcoreRule e")
    , @NamedQuery(name = "EsbcoreRule.findByRuleId", query = "SELECT e FROM EsbcoreRule e WHERE e.ruleId = :ruleId")
    , @NamedQuery(name = "EsbcoreRule.findByRuleOrder", query = "SELECT e FROM EsbcoreRule e WHERE e.ruleOrder = :ruleOrder")})
public class EsbcoreRule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RULE_ID")
    private BigDecimal ruleId;
    @Column(name = "RULE_ORDER")
    private Short ruleOrder;
    @OneToMany(cascade = CascadeType.PERSIST,fetch =FetchType.LAZY,mappedBy = "ruleId")
    @JsonIgnore
    private Collection<EsbcoreRuleCondition> esbcoreRuleConditionCollection;
    
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID")
    //edited
    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    
    private EsbcoreService serviceId;
    @OneToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "ruleId")
    @JsonIgnore
    private Collection<EsbcoreRuleDestination> esbcoreRuleDestinationCollection;

    public EsbcoreRule() {
    }
    
    //@JsonCreator
    public EsbcoreRule(EsbcoreService serviceId) {
    	this.serviceId=serviceId;
    }
  

    public EsbcoreRule(BigDecimal ruleId) {
        this.ruleId = ruleId;
    }
    
   
   

    public BigDecimal getRuleId() {
        return ruleId;
    }

    public void setRuleId(BigDecimal ruleId) {
        this.ruleId = ruleId;
    }

    public Short getRuleOrder() {
        return ruleOrder;
    }

    public void setRuleOrder(Short ruleOrder) {
        this.ruleOrder = ruleOrder;
    }

    @XmlTransient
    public Collection<EsbcoreRuleCondition> getEsbcoreRuleConditionCollection() {
        return esbcoreRuleConditionCollection;
    }

    public void setEsbcoreRuleConditionCollection(Collection<EsbcoreRuleCondition> esbcoreRuleConditionCollection) {
        this.esbcoreRuleConditionCollection = esbcoreRuleConditionCollection;
    }

   
    public EsbcoreService getServiceId() {
        return serviceId;
    }
    /*
    public EsbcoreService getServiceId() {
        return serviceId;
    }*/
    

   
    public void setServiceId(EsbcoreService serviceId) {
        this.serviceId = serviceId;
    }

    @XmlTransient
    public Collection<EsbcoreRuleDestination> getEsbcoreRuleDestinationCollection() {
        return esbcoreRuleDestinationCollection;
    }

    public void setEsbcoreRuleDestinationCollection(Collection<EsbcoreRuleDestination> esbcoreRuleDestinationCollection) {
        this.esbcoreRuleDestinationCollection = esbcoreRuleDestinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreRule)) {
            return false;
        }
        EsbcoreRule other = (EsbcoreRule) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreRule[ ruleId=" + ruleId + " ]";
    }
    
}
