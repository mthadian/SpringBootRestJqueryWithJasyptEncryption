package com.KCB.bank.Repos;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreDomain;

@Repository
public interface EsbcoreDomainRepository extends JpaRepository<EsbcoreDomain,BigDecimal> 
{
	EsbcoreDomain findFirstByOrderByDomainIdDesc();

}
