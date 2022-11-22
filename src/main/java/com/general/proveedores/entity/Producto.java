package com.general.proveedores.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

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
	 * comentario hecho por diego y jancito
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String descripcion;
	@Column
	private Double precio;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinTable(name = "proveedor_producto", joinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id")
	, inverseJoinColumns = @JoinColumn(name="proveedor_id", referencedColumnName = "id"))
	private Proveedor proveedor;
}
