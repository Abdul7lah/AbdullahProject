package com.Abdullah.Appoinment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Abdullah.Appoinment.Entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
