package com.KCB.bank.Repos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreService;
/**
 * @author Patrick Muthama
 *
 */
@Repository
public interface EsbcoreServiceRepository extends JpaRepository<EsbcoreService, BigDecimal>
{
	List<EsbcoreService> findByServiceIdAndSystemDomainId(BigDecimal serviceId, BigInteger systemDomainId);
	EsbcoreService findFirstByOrderByServiceIdDesc();
	List<EsbcoreService> findByCreatedBy(String createdBy);
	
	


}
