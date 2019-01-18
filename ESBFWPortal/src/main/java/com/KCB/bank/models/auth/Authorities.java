/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models.auth;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "AUTHORITIES")
@Table(name = "AUTHORITIES",schema="SYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authorities.findAll", query = "SELECT a FROM Authorities a")
    , @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authority = :authority")
    , @NamedQuery(name = "Authorities.findByAuthorityid", query = "SELECT a FROM Authorities a WHERE a.authorityid = :authorityid")})
public class Authorities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AUTHORITY")
    private String authority;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHORITYID")
    private BigDecimal authorityid;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Users username;

    public Authorities() {
    }

    public Authorities(BigDecimal authorityid) {
        this.authorityid = authorityid;
    }

    public Authorities(BigDecimal authorityid, String authority) {
        this.authorityid = authorityid;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public BigDecimal getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(BigDecimal authorityid) {
        this.authorityid = authorityid;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorityid != null ? authorityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.authorityid == null && other.authorityid != null) || (this.authorityid != null && !this.authorityid.equals(other.authorityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.auth.Authorities[ authorityid=" + authorityid + " ]";
    }
    
}
