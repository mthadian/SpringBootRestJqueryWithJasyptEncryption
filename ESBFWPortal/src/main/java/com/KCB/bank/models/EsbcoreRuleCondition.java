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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author PMMuthama
 */
@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)

//@Table(name = "ESBCORE_RULE_CONDITION")
@Table(name = "ESBCORE_RULE_CONDITION",schema="SYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreRuleCondition.findAll", query = "SELECT e FROM EsbcoreRuleCondition e")
    , @NamedQuery(name = "EsbcoreRuleCondition.findByRuleConditionId", query = "SELECT e FROM EsbcoreRuleCondition e WHERE e.ruleConditionId = :ruleConditionId")
    , @NamedQuery(name = "EsbcoreRuleCondition.findByRuleConditionOrder", query = "SELECT e FROM EsbcoreRuleCondition e WHERE e.ruleConditionOrder = :ruleConditionOrder")
    , @NamedQuery(name = "EsbcoreRuleCondition.findByFieldOperation", query = "SELECT e FROM EsbcoreRuleCondition e WHERE e.fieldOperation = :fieldOperation")
    , @NamedQuery(name = "EsbcoreRuleCondition.findByFieldName", query = "SELECT e FROM EsbcoreRuleCondition e WHERE e.fieldName = :fieldName")
    , @NamedQuery(name = "EsbcoreRuleCondition.findByFieldValue", query = "SELECT e FROM EsbcoreRuleCondition e WHERE e.fieldValue = :fieldValue")})
public class EsbcoreRuleCondition implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RULE_CONDITION_ID")
    private BigDecimal ruleConditionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RULE_CONDITION_ORDER")
    private short ruleConditionOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FIELD_OPERATION")
    private String fieldOperation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIELD_NAME")
    private String fieldName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "FIELD_VALUE")
    private String fieldValue;
    @JoinColumn(name = "RULE_ID", referencedColumnName = "RULE_ID")
    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER,optional = false)
    
    private EsbcoreRule ruleId;

    
    public EsbcoreRuleCondition() {
    	
    }
    
    /*
    @JsonCreator
    public EsbcoreRuleCondition(@JsonProperty("fieldValue") String fieldValue,@JsonProperty("fieldName") String fieldName,@JsonProperty("fieldOperation") String fieldOperation,@JsonProperty("ruleConditionOrder") short ruleConditionOrder,@JsonProperty("ruleConditionId") BigDecimal ruleConditionId,@JsonProperty("ruleId") EsbcoreRule ruleId)
    {
    	this.fieldValue=fieldValue;
    	this.fieldName=fieldName;
    	this.fieldOperation=fieldOperation;
    	this.ruleConditionOrder=ruleConditionOrder;
    	this.ruleConditionId=ruleConditionId;
    	
    	this.ruleId=ruleId;
    	
    }
    */

    public EsbcoreRuleCondition(BigDecimal ruleConditionId) {
        this.ruleConditionId = ruleConditionId;
    }
    
    @JsonCreator
    public EsbcoreRuleCondition(BigDecimal ruleConditionId, short ruleConditionOrder, String fieldOperation, String fieldName, String fieldValue) {
        this.ruleConditionId = ruleConditionId;
        this.ruleConditionOrder = ruleConditionOrder;
        this.fieldOperation = fieldOperation;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    } 

    public BigDecimal getRuleConditionId() {
        return ruleConditionId;
    }

    public void setRuleConditionId(BigDecimal ruleConditionId) {
        this.ruleConditionId = ruleConditionId;
    }

    public short getRuleConditionOrder() {
        return ruleConditionOrder;
    }

    public void setRuleConditionOrder(short ruleConditionOrder) {
        this.ruleConditionOrder = ruleConditionOrder;
    }

    public String getFieldOperation() {
        return fieldOperation;
    }

    public void setFieldOperation(String fieldOperation) {
        this.fieldOperation = fieldOperation;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public EsbcoreRule getRuleId() {
        return ruleId;
    }

    public void setRuleId(EsbcoreRule ruleId) {
        this.ruleId = ruleId;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleConditionId != null ? ruleConditionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreRuleCondition)) {
            return false;
        }
        EsbcoreRuleCondition other = (EsbcoreRuleCondition) object;
        if ((this.ruleConditionId == null && other.ruleConditionId != null) || (this.ruleConditionId != null && !this.ruleConditionId.equals(other.ruleConditionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreRuleCondition[ ruleConditionId=" + ruleConditionId + " ]";
    }
    
}
