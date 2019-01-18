package com.KCB.bank.Repos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreRule;

@Repository
public interface EsbcoreRuleRepository extends JpaRepository<EsbcoreRule, BigDecimal>{
	
	EsbcoreRule findFirstByOrderByRuleIdDesc();
	List<EsbcoreRule> findByServiceId_ServiceId(BigDecimal serviceId);
	Optional<EsbcoreRule> findFirstByServiceId_ServiceIdOrderByRuleOrderDesc(BigDecimal serviceId);
	

}
