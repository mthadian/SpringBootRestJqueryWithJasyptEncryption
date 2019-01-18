package com.KCB.bank.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.EsbcoreSystem;

@Repository
public interface EsbcoreSystemRepository extends JpaRepository<EsbcoreSystem, String>
{
	EsbcoreSystem findFirstByOrderBySystemCodeDesc();

}
