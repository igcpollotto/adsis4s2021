package br.unicesumar.adsis4s2021.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	@Id
	private String id;
	
	public BaseEntity() {
	}
	
	public BaseEntity(String id) {
		this.id = id;
	}



	public String getId() {
		return id;
	}

}
