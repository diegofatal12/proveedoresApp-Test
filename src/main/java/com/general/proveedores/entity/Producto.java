package com.general.proveedores.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String descripcion;
	@Column
	private Double precio;
}
