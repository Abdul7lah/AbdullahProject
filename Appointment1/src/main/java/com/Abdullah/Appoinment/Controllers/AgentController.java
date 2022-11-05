package com.Abdullah.Appoinment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Abdullah.Appoinment.Entity.Agent;
import com.Abdullah.Appoinment.Repository.AgentRepository;

@RestController
@RequestMapping("/appiontment_scheduling_app")
public class AgentController {
	
	
	@Autowired
	private AgentRepository agentRepository;
	
	@GetMapping("/agent")
	public String getAgent() {
		return "jalksdjflasdf";
	}
	
	@PutMapping("/agent/{id}/appintment/")
	public ResponseEntity updateAppointment(@PathVariable("id") Integer id, @RequestBody Agent ag) {
	try {	
		Agent agent =  agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not by the appoint with this " + id));
	
	
	 
		agent.setFirst_name(ag.getFirst_name());
		agent.setLast_name(ag.getLast_name());
		agent.setEmail_id(ag.getEmail_id());
		agent.setPassword(ag.getPassword());
		agent.setPhoneNumer(ag.getPhoneNumer());
		
		
		agentRepository.save(agent);
	}catch(IllegalArgumentException e) {e.printStackTrace();}
		return (ResponseEntity) ResponseEntity.ok();
		
	}
	
	
	@DeleteMapping("/agent/{id}/appintment/")
	public ResponseEntity deleteAppointment(@PathVariable("id") Integer id) {
		
		Agent agent =  agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not by the appoint with this " + id));
		agentRepository.delete(agent);
		
		return (ResponseEntity) ResponseEntity.ok();
		
	}
	

}
