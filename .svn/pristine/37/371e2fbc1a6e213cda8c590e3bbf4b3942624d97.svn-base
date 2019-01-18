package com.KCB.bank.Repos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreSystemDomain;

@Repository
public interface EsbcoreSystemDomainRepository extends JpaRepository<EsbcoreSystemDomain, BigDecimal>
{
	EsbcoreSystemDomain findFirstByOrderBySystemDomainIdDesc();
	public Optional<EsbcoreSystemDomain> findBySystemCode_SystemCodeAndDomainId(String systemCode,BigInteger domainId);

}
