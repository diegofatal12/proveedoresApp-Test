package com.general.proveedores.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.general.proveedores.dtos.ProductoDTO;
import com.general.proveedores.service.ProductoServiceImp;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/productos")
public class ProductoController extends BaseControllerImpl<ProductoDTO, ProductoServiceImp>{
	
}
