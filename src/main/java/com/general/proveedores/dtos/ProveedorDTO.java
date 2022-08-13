package com.general.proveedores.dtos;

import java.util.HashSet;
import java.util.Set;

import com.general.proveedores.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProveedorDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cuilt;
	private String nombreFantasia;
	private String razonSocial;
	private Set<Producto> productos = new HashSet<>();
	
}
