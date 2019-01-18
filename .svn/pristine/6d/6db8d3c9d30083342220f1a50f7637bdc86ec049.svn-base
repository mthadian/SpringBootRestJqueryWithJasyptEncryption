/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "ESBCORE_SYSTEM")
@Table(name = "ESBCORE_SYSTEM",schema = "SYS") 
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsbcoreSystem.findAll", query = "SELECT e FROM EsbcoreSystem e")
    , @NamedQuery(name = "EsbcoreSystem.findBySystemCode", query = "SELECT e FROM EsbcoreSystem e WHERE e.systemCode = :systemCode")
    , @NamedQuery(name = "EsbcoreSystem.findBySystemName", query = "SELECT e FROM EsbcoreSystem e WHERE e.systemName = :systemName")})
public class EsbcoreSystem implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SYSTEM_NAME")
    private String systemName;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SYSTEM_CODE")
    private String systemCode;
    //fetch = FetchType.EAGER,
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemCode")
    @JsonIgnore
    private Collection<EsbcoreSystemDomain> esbcoreSystemDomainCollection;

    public EsbcoreSystem() {
    }

    public EsbcoreSystem(String systemCode) {
        this.systemCode = systemCode;
    }

    public EsbcoreSystem(String systemCode, String systemName) {
        this.systemCode = systemCode;
        this.systemName = systemName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @XmlTransient
    public Collection<EsbcoreSystemDomain> getEsbcoreSystemDomainCollection() {
        return esbcoreSystemDomainCollection;
    }

    public void setEsbcoreSystemDomainCollection(Collection<EsbcoreSystemDomain> esbcoreSystemDomainCollection) {
        this.esbcoreSystemDomainCollection = esbcoreSystemDomainCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemCode != null ? systemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreSystem)) {
            return false;
        }
        EsbcoreSystem other = (EsbcoreSystem) object;
        if ((this.systemCode == null && other.systemCode != null) || (this.systemCode != null && !this.systemCode.equals(other.systemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreSystem[ systemCode=" + systemCode + " ]";
    }

  
    
}
