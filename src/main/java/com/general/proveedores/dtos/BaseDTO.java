package com.general.proveedores.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;	
}
