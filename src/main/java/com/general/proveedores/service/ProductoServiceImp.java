package com.general.proveedores.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.general.proveedores.dtos.ProductoDTO;
import com.general.proveedores.entity.Producto;
import com.general.proveedores.entity.Proveedor;
import com.general.proveedores.repository.BaseRepository;
import com.general.proveedores.repository.ProductoRepository;
import com.general.proveedores.repository.ProveedorRepository;

@Service
public class ProductoServiceImp extends BaseServiceImpl<ProductoDTO, Long, Producto> implements ProductoService{

	@Autowired
	private ProductoRepository prodRepository;
	@Autowired
	private ProveedorRepository provRepository;
	public ProductoServiceImp(BaseRepository<Producto, Long> baseRepository) {
		super(baseRepository);
	}
	
	public ProductoDTO save(ProductoDTO dto) {
		Optional<Proveedor> optProv = provRepository.findById(dto.getProveedor().getId());
		dto.setProveedor(optProv.get());
		ProductoDTO dtoGuardado = mapearDto(prodRepository.save(mapearEntidad(dto)));
		return dtoGuardado;
	}
}
