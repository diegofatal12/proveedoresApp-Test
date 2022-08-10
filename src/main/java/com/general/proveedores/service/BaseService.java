package com.general.proveedores.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.general.proveedores.dtos.BaseDTO;

public interface BaseService <D extends BaseDTO, ID extends Serializable>{
	public Page<D> findAll(Pageable pageable) throws Exception;
	public D findById(ID id) throws Exception;
	public D save(D dto) throws Exception;
	public D update(ID id, D dto) throws Exception;
	public boolean delete(ID id) throws Exception;
}
