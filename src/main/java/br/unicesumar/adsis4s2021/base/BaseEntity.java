package br.unicesumar.adsis4s2021.base;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {	
	@Id
	private String id;
	
	public BaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	
	public BaseEntity(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}
