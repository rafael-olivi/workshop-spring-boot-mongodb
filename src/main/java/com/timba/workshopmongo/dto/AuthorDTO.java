package com.timba.workshopmongo.dto;

import java.io.Serializable;

import com.timba.workshopmongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	public AuthorDTO(User user) {
		id = user.getId();
		name = user.getName();
	}
}
