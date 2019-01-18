package com.KCB.bank.Repos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreRule;
import com.KCB.bank.models.EsbcoreRuleDestination;

@Repository
public interface EsbcoreRuleDestinationRepository extends JpaRepository<EsbcoreRuleDestination, BigDecimal>{
	public Optional<EsbcoreRuleDestination> findByRuleId_RuleId(BigDecimal RuleId_RuleId);
	EsbcoreRuleDestination findFirstByOrderByRuleDestinationIdDesc();

}
