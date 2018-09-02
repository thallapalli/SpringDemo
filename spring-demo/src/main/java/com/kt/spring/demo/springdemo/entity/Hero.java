package com.kt.spring.demo.springdemo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HERO database table.
 * 
 */
@Entity
@NamedQuery(name="Hero.findAll", query="SELECT h FROM Hero h")
public class Hero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String name;

	public Hero() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}