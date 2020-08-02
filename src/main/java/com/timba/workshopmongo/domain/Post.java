package com.timba.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.timba.workshopmongo.dto.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@org.springframework.data.annotation.Id
	private String Id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
}
