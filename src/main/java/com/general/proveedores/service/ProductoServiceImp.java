package com.general.proveedores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.general.proveedores.dtos.ProductoDTO;
import com.general.proveedores.entity.Producto;
import com.general.proveedores.repository.BaseRepository;
import com.general.proveedores.repository.ProductoRepository;

@Service
public class ProductoServiceImp extends BaseServiceImpl<ProductoDTO, Long, Producto> implements ProductoService{
	@SuppressWarnings("unused")
	@Autowired
	private ProductoRepository prodRepository;
	public ProductoServiceImp(BaseRepository<Producto, Long> baseRepository) {
		super(baseRepository);
	}
	
}
