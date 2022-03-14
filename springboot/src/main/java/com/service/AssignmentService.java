package com.service;


import com.DTO.AssignmentDTO;
import com.entity.Assignment;
import com.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssignmentService {

	@Autowired
	private DriverService driverService;

	@Autowired
	private RouterService routerService;

	@Autowired
    AssignmentRepository assignmentRepository;
	
	public List<Assignment> getAll(){
		return assignmentRepository.getAll();
	}
	
	public boolean insert(AssignmentDTO assignmentDTO) {
		Assignment assignment = new Assignment();
		System.out.println(assignmentDTO);
		assignment.setDriver(driverService.findById(assignmentDTO.getDriver_id()));
		assignment.setRouter(routerService.findRouterId(assignmentDTO.getRouter_id()));
		assignment.setTurnNumber(assignmentDTO.getTurnNumber());
		return assignmentRepository.insert(assignment);
	}

	public boolean update(AssignmentDTO assignmentDTO){
		Assignment assignment = assignmentRepository.findById(assignmentDTO.getId());
		assignment.setDriver(driverService.findById(assignmentDTO.getDriver_id()));
		assignment.setRouter(routerService.findRouterId(assignmentDTO.getRouter_id()));
		assignment.setTurnNumber(assignmentDTO.getTurnNumber());
		return assignmentRepository.update(assignment);
	}

	public Assignment findById(int id){
		return assignmentRepository.findById(id);
	}

	public boolean deleteById(int id){
		return assignmentRepository.deleteById(id);
	}

	public boolean deleteByDriverId(int id){
		return assignmentRepository.deleteByDriverId(id);
	}

	public boolean deleteByRouterId(int id){
		return assignmentRepository.deleteByRouterId(id);
	}
}
