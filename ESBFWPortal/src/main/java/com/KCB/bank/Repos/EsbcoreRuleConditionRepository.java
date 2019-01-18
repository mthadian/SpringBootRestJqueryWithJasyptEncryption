package com.KCB.bank.Repos;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreRuleCondition;

@Repository
public interface EsbcoreRuleConditionRepository extends JpaRepository<EsbcoreRuleCondition, BigDecimal>
{
	EsbcoreRuleCondition findFirstByOrderByRuleConditionIdDesc();

}
