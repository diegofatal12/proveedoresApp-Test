package com.general.proveedores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.general.proveedores.dtos.ProveedorDTO;
import com.general.proveedores.entity.Proveedor;
import com.general.proveedores.repository.BaseRepository;
import com.general.proveedores.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp extends BaseServiceImpl<ProveedorDTO, Long, Proveedor> implements ProveedorService{
	@SuppressWarnings("unused")
	@Autowired
	private ProveedorRepository pRepository;
	public ProveedorServiceImp(BaseRepository<Proveedor,Long> baseRepository) {
		super(baseRepository);
	}
}
