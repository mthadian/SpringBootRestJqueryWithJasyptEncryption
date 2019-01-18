/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KCB.bank.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

/**
 *
 * @author PMMuthama
 */
@Entity
//@Table(name = "ESBCORE_SERVICE")
@Table(name = "ESBCORE_SERVICE",schema="SYS")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "EsbcoreService.findAll", query = "SELECT e FROM EsbcoreService e")
    , @NamedQuery(name = "EsbcoreService.findByServiceId", query = "SELECT e FROM EsbcoreService e WHERE e.serviceId = :serviceId")
    , @NamedQuery(name = "EsbcoreService.findByServiceCode", query = "SELECT e FROM EsbcoreService e WHERE e.serviceCode = :serviceCode")
    , @NamedQuery(name = "EsbcoreService.findBySystemDomainId", query = "SELECT e FROM EsbcoreService e WHERE e.systemDomainId = :systemDomainId")
    , @NamedQuery(name = "EsbcoreService.findByServiceType", query = "SELECT e FROM EsbcoreService e WHERE e.serviceType = :serviceType")
    , @NamedQuery(name = "EsbcoreService.findByServiceName", query = "SELECT e FROM EsbcoreService e WHERE e.serviceName = :serviceName")
    , @NamedQuery(name = "EsbcoreService.findByOperation", query = "SELECT e FROM EsbcoreService e WHERE e.operation = :operation")
    , @NamedQuery(name = "EsbcoreService.findByVersion", query = "SELECT e FROM EsbcoreService e WHERE e.version = :version")
    , @NamedQuery(name = "EsbcoreService.findBySync", query = "SELECT e FROM EsbcoreService e WHERE e.sync = :sync")
    , @NamedQuery(name = "EsbcoreService.findByLogLevel", query = "SELECT e FROM EsbcoreService e WHERE e.logLevel = :logLevel")
    , @NamedQuery(name = "EsbcoreService.findByDuplicateCheck", query = "SELECT e FROM EsbcoreService e WHERE e.duplicateCheck = :duplicateCheck")
    , @NamedQuery(name = "EsbcoreService.findByGenericReply", query = "SELECT e FROM EsbcoreService e WHERE e.genericReply = :genericReply")
    , @NamedQuery(name = "EsbcoreService.findByTimeout", query = "SELECT e FROM EsbcoreService e WHERE e.timeout = :timeout")
    , @NamedQuery(name = "EsbcoreService.findByRetryMax", query = "SELECT e FROM EsbcoreService e WHERE e.retryMax = :retryMax")
    , @NamedQuery(name = "EsbcoreService.findByRetryInterval", query = "SELECT e FROM EsbcoreService e WHERE e.retryInterval = :retryInterval")
    , @NamedQuery(name = "EsbcoreService.findByPrjReleaseCode", query = "SELECT e FROM EsbcoreService e WHERE e.prjReleaseCode = :prjReleaseCode")
    , @NamedQuery(name = "EsbcoreService.findByEmailAlertGroup", query = "SELECT e FROM EsbcoreService e WHERE e.emailAlertGroup = :emailAlertGroup")
    , @NamedQuery(name = "EsbcoreService.findBySmsAlertGroup", query = "SELECT e FROM EsbcoreService e WHERE e.smsAlertGroup = :smsAlertGroup")
    , @NamedQuery(name = "EsbcoreService.findByEmailAlertFlag", query = "SELECT e FROM EsbcoreService e WHERE e.emailAlertFlag = :emailAlertFlag")
    , @NamedQuery(name = "EsbcoreService.findBySmsAlertFlag", query = "SELECT e FROM EsbcoreService e WHERE e.smsAlertFlag = :smsAlertFlag")
    , @NamedQuery(name = "EsbcoreService.findByCreationDate", query = "SELECT e FROM EsbcoreService e WHERE e.creationDate = :creationDate")
    , @NamedQuery(name = "EsbcoreService.findByCreatedBy", query = "SELECT e FROM EsbcoreService e WHERE e.createdBy = :createdBy")})


public class EsbcoreService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICE_ID")
    
    private BigDecimal serviceId;
    @Size(max = 4)
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @Column(name = "SYSTEM_DOMAIN_ID")
    private BigInteger systemDomainId;
    @Size(max = 20)
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    @Size(max = 255)
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Size(max = 255)
    @Column(name = "OPERATION")
    private String operation;
    @Size(max = 5)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "SYNC")
    private Short sync;
    @Size(max = 10)
    @Column(name = "LOG_LEVEL")
    private String logLevel;
    @Column(name = "DUPLICATE_CHECK")
    private Short duplicateCheck;
    @Column(name = "GENERIC_REPLY")
    private Short genericReply;
    @Column(name = "TIMEOUT")
    private Integer timeout;
    @Column(name = "RETRY_MAX")
    private Integer retryMax;
    @Column(name = "RETRY_INTERVAL")
    private Integer retryInterval;
    @Size(max = 50)
    @Column(name = "PRJ_RELEASE_CODE")
    private String prjReleaseCode;
    @Size(max = 50)
    @Column(name = "EMAIL_ALERT_GROUP")
    private String emailAlertGroup;
    @Size(max = 500)
    @Column(name = "SMS_ALERT_GROUP")
    private String smsAlertGroup;
    @Column(name = "EMAIL_ALERT_FLAG")
    private BigInteger emailAlertFlag;
    @Column(name = "SMS_ALERT_FLAG")
    private BigInteger smsAlertFlag;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Size(max = 100)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SYSTEM_DOMAIN_ID")
    //, insertable = false, updatable = false
    @OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY,optional = false)
    @JsonIgnore
    private EsbcoreSystemDomain esbcoreSystemDomain;
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch =FetchType.LAZY, mappedBy = "serviceId")
    @JsonIgnore
    private Collection<EsbcoreRuleDestination> esbcoreRuleDestinationCollection;
    
    

    
    public EsbcoreService() {
    }

   
    public EsbcoreService(BigDecimal serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigDecimal serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public BigInteger getSystemDomainId() {
        return systemDomainId;
    }

    public void setSystemDomainId(BigInteger systemDomainId) {
        this.systemDomainId = systemDomainId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Short getSync() {
        return sync;
    }

    public void setSync(Short sync) {
        this.sync = sync;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public Short getDuplicateCheck() {
        return duplicateCheck;
    }

    public void setDuplicateCheck(Short duplicateCheck) {
        this.duplicateCheck = duplicateCheck;
    }

    public Short getGenericReply() {
        return genericReply;
    }

    public void setGenericReply(Short genericReply) {
        this.genericReply = genericReply;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetryMax() {
        return retryMax;
    }

    public void setRetryMax(Integer retryMax) {
        this.retryMax = retryMax;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getPrjReleaseCode() {
        return prjReleaseCode;
    }

    public void setPrjReleaseCode(String prjReleaseCode) {
        this.prjReleaseCode = prjReleaseCode;
    }

    public String getEmailAlertGroup() {
        return emailAlertGroup;
    }

    public void setEmailAlertGroup(String emailAlertGroup) {
        this.emailAlertGroup = emailAlertGroup;
    }

    public String getSmsAlertGroup() {
        return smsAlertGroup;
    }

    public void setSmsAlertGroup(String smsAlertGroup) {
        this.smsAlertGroup = smsAlertGroup;
    }

    public BigInteger getEmailAlertFlag() {
        return emailAlertFlag;
    }

    public void setEmailAlertFlag(BigInteger emailAlertFlag) {
        this.emailAlertFlag = emailAlertFlag;
    }

    public BigInteger getSmsAlertFlag() {
        return smsAlertFlag;
    }

    public void setSmsAlertFlag(BigInteger smsAlertFlag) {
        this.smsAlertFlag = smsAlertFlag;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public EsbcoreSystemDomain getEsbcoreSystemDomain() {
        return esbcoreSystemDomain;
    }

    public void setEsbcoreSystemDomain(EsbcoreSystemDomain esbcoreSystemDomain) {
        this.esbcoreSystemDomain = esbcoreSystemDomain;
    }
    
    //added
    @XmlTransient
    public Collection<EsbcoreRuleDestination> getEsbcoreRuleDestinationCollection() {
		return esbcoreRuleDestinationCollection;
	}

	public void setEsbcoreRuleDestinationCollection(Collection<EsbcoreRuleDestination> esbcoreRuleDestinationCollection) {
		this.esbcoreRuleDestinationCollection = esbcoreRuleDestinationCollection;
	}
//
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsbcoreService)) {
            return false;
        }
        EsbcoreService other = (EsbcoreService) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.KCB.bank.models.EsbcoreService[ serviceId=" + serviceId + " ]";
    }
    /**

	@Override
	public String toString() {
		return "EsbcoreService [serviceId=" + serviceId + ", serviceCode=" + serviceCode + ", systemDomainId="
				+ systemDomainId + ", serviceType=" + serviceType + ", serviceName=" + serviceName + ", operation="
				+ operation + ", version=" + version + ", sync=" + sync + ", logLevel=" + logLevel + ", duplicateCheck="
				+ duplicateCheck + ", genericReply=" + genericReply + ", timeout=" + timeout + ", retryMax=" + retryMax
				+ ", retryInterval=" + retryInterval + ", prjReleaseCode=" + prjReleaseCode + ", emailAlertGroup="
				+ emailAlertGroup + ", smsAlertGroup=" + smsAlertGroup + ", emailAlertFlag=" + emailAlertFlag
				+ ", smsAlertFlag=" + smsAlertFlag + ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", esbcoreSystemDomain=" + esbcoreSystemDomain + "]";
	}
	**/
    
    
    
    
    
    
    
    
}
