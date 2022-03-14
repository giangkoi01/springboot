package com.service;


import com.entity.Router;
import com.repository.RouterRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RouterService {
	RouterRepository routerRepository = new RouterRepository();
	
	public List<Router> getAll(){
		return routerRepository.getAll();
	}

	public boolean insert(Router router) {
		return routerRepository.insert(router);
	}

	public boolean update(Router router){
		return routerRepository.update(router);
	}
	
	public Router findRouterId(int id) {

        return routerRepository.findById(id);
    }

	public Boolean deleteById(int id){
		return routerRepository.deleteById(id);
	}


}
