package com.general.proveedores.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.general.proveedores.dtos.ProveedorDTO;
import com.general.proveedores.service.ProveedorServiceImp;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/proveedores")
public class ProveedorController extends BaseControllerImpl<ProveedorDTO, ProveedorServiceImp>{
	
}
