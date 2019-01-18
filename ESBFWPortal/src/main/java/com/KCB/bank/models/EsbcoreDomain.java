/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "ESBCORE_DOMAIN")
@Table(name = "ESBCORE_DOMAIN", schema = "SYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreDomain.findAll", query = "SELECT e FROM EsbcoreDomain e")
    , @NamedQuery(name = "EsbcoreDomain.findByDomainId", query = "SELECT e FROM EsbcoreDomain e WHERE e.domainId = :domainId")
    , @NamedQuery(name = "EsbcoreDomain.findByDomainType", query = "SELECT e FROM EsbcoreDomain e WHERE e.domainType = :domainType")
    , @NamedQuery(name = "EsbcoreDomain.findByDomainName", query = "SELECT e FROM EsbcoreDomain e WHERE e.domainName = :domainName")})
public class EsbcoreDomain implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOMAIN_ID")
    private BigDecimal domainId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOMAIN_TYPE")
    private String domainType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DOMAIN_NAME")
    private String domainName;

    public EsbcoreDomain() {
    }

    public EsbcoreDomain(BigDecimal domainId) {
        this.domainId = domainId;
    }

    public EsbcoreDomain(BigDecimal domainId, String domainType, String domainName) {
        this.domainId = domainId;
        this.domainType = domainType;
        this.domainName = domainName;
    }

    public BigDecimal getDomainId() {
        return domainId;
    }

    public void setDomainId(BigDecimal domainId) {
        this.domainId = domainId;
    }

    public String getDomainType() {
        return domainType;
    }

    public void setDomainType(String domainType) {
        this.domainType = domainType;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domainId != null ? domainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreDomain)) {
            return false;
        }
        EsbcoreDomain other = (EsbcoreDomain) object;
        if ((this.domainId == null && other.domainId != null) || (this.domainId != null && !this.domainId.equals(other.domainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreDomain[ domainId=" + domainId + " ]";
    }
    
}