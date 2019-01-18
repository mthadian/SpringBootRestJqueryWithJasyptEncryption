/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "ESBCORE_SYSTEM_DOMAIN")
@Table(name = "ESBCORE_SYSTEM_DOMAIN" , schema="SYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreSystemDomain.findAll", query = "SELECT e FROM EsbcoreSystemDomain e")
    , @NamedQuery(name = "EsbcoreSystemDomain.findBySystemDomainId", query = "SELECT e FROM EsbcoreSystemDomain e WHERE e.systemDomainId = :systemDomainId")
    , @NamedQuery(name = "EsbcoreSystemDomain.findByDomainId", query = "SELECT e FROM EsbcoreSystemDomain e WHERE e.domainId = :domainId")})
public class EsbcoreSystemDomain implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DOMAIN_ID")
    private BigInteger domainId;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTEM_DOMAIN_ID")
    private BigDecimal systemDomainId;
    @JoinColumn(name = "SYSTEM_CODE", referencedColumnName = "SYSTEM_CODE")
    @ManyToOne(optional = false)
    private EsbcoreSystem systemCode;
    //fetch = FetchType.EAGER,
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "esbcoreSystemDomain")
    private EsbcoreService esbcoreService;

    public EsbcoreSystemDomain() {
    }

    public EsbcoreSystemDomain(BigDecimal systemDomainId) {
        this.systemDomainId = systemDomainId;
    }

    public EsbcoreSystemDomain(BigDecimal systemDomainId, BigInteger domainId) {
        this.systemDomainId = systemDomainId;
        this.domainId = domainId;
    }

    public BigDecimal getSystemDomainId() {
        return systemDomainId;
    }

    public void setSystemDomainId(BigDecimal systemDomainId) {
        this.systemDomainId = systemDomainId;
    }

    public BigInteger getDomainId() {
        return domainId;
    }

    public void setDomainId(BigInteger domainId) {
        this.domainId = domainId;
    }

    public EsbcoreSystem getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(EsbcoreSystem systemCode) {
        this.systemCode = systemCode;
    }

    public EsbcoreService getEsbcoreService() {
        return esbcoreService;
    }

    public void setEsbcoreService(EsbcoreService esbcoreService) {
        this.esbcoreService = esbcoreService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemDomainId != null ? systemDomainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreSystemDomain)) {
            return false;
        }
        EsbcoreSystemDomain other = (EsbcoreSystemDomain) object;
        if ((this.systemDomainId == null && other.systemDomainId != null) || (this.systemDomainId != null && !this.systemDomainId.equals(other.systemDomainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreSystemDomain[ systemDomainId=" + systemDomainId + " ]";
    }

    
}