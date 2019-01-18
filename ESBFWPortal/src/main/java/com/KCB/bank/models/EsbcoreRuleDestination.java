/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "ESBCORE_RULE_DESTINATION")
@Table(name = "ESBCORE_RULE_DESTINATION",schema="SYS")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreRuleDestination.findAll", query = "SELECT e FROM EsbcoreRuleDestination e")
    , @NamedQuery(name = "EsbcoreRuleDestination.findByRuleDestinationId", query = "SELECT e FROM EsbcoreRuleDestination e WHERE e.ruleDestinationId = :ruleDestinationId")})
public class EsbcoreRuleDestination implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RULE_DESTINATION_ID")
    private BigDecimal ruleDestinationId;
    @JoinColumn(name = "RULE_ID",referencedColumnName = "RULE_ID")
   // @JoinColumn(name = "RULE_ID", referencedColumnName = "RULE_ID")
    //(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER,optional=false)
    private EsbcoreRule ruleId;
    @JoinColumn(name = "SERVICE_ID",referencedColumnName = "SERVICE_ID")
    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER,optional=false)
    private EsbcoreService serviceId;

    public EsbcoreRuleDestination() {
    }

    public EsbcoreRuleDestination(BigDecimal ruleDestinationId) {
        this.ruleDestinationId = ruleDestinationId;
    }

    public BigDecimal getRuleDestinationId() {
        return ruleDestinationId;
    }

    public void setRuleDestinationId(BigDecimal ruleDestinationId) {
        this.ruleDestinationId = ruleDestinationId;
    }

    public EsbcoreRule getRuleId() {
        return ruleId;
    }

    public void setRuleId(EsbcoreRule ruleId) {
        this.ruleId = ruleId;
    }

    public EsbcoreService getServiceId() {
        return serviceId;
    }

    public void setServiceId(EsbcoreService serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleDestinationId != null ? ruleDestinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreRuleDestination)) {
            return false;
        }
        EsbcoreRuleDestination other = (EsbcoreRuleDestination) object;
        if ((this.ruleDestinationId == null && other.ruleDestinationId != null) || (this.ruleDestinationId != null && !this.ruleDestinationId.equals(other.ruleDestinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreRuleDestination[ ruleDestinationId=" + ruleDestinationId + " ]";
    }
    
}