package com.general.proveedores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.general.proveedores.dtos.BaseDTO;
import com.general.proveedores.service.BaseService;

public abstract class BaseControllerImpl<D extends BaseDTO, S extends BaseService<D, Long>> implements BaseController<D, Long>{
	@Autowired
	protected S servicio;
	@GetMapping("")
	public ResponseEntity<?> getAll(Pageable pageable){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody D dto){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.save(dto));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody D dto){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	} 
	@DeleteMapping("/id")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
