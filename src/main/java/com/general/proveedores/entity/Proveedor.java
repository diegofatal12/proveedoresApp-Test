package com.general.proveedores.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="proveedores")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Proveedor extends Base{

	private static final long serialVersionUID = 1L;
	@Column
	private String cuilt;
	@Column
	private String nombreFantasia;
	@Column
	private String razonSocial;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "proveedor_producto", joinColumns = @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
	, inverseJoinColumns = @JoinColumn(name="producto_id", referencedColumnName = "id"))
	private Set<Producto> productos = new HashSet<>();
}
