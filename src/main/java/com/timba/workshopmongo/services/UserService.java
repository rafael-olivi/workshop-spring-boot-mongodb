package com.timba.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timba.workshopmongo.domain.User;
import com.timba.workshopmongo.dto.UserDTO;
import com.timba.workshopmongo.repository.UserRepository;
import com.timba.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User entity) {
		return repo.insert(entity);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User entity) {
		User newEntity = findById(entity.getId());
		updateData(newEntity, entity);
		return repo.save(newEntity);
	}
	
	private void updateData(User newEntity, User entity) {
		newEntity.setName(entity.getName());
		newEntity.setEmail(entity.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
