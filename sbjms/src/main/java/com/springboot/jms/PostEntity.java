package com.springboot.jms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "POST")
public class PostEntity implements Serializable{

	/**
	 * Serialized for JMS purpose
	 */
	private static final long serialVersionUID = 855729132080774528L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@NotEmpty
	@Column(name = "MESSAGE")
	private String message;

}
