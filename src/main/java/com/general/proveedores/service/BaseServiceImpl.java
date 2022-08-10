package com.general.proveedores.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.general.proveedores.dtos.BaseDTO;
import com.general.proveedores.entity.Base;
import com.general.proveedores.repository.BaseRepository;

public abstract class BaseServiceImpl <D extends BaseDTO, ID extends Serializable, E extends Base> implements BaseService<D, ID>{
	
	protected BaseRepository<E, ID> baseRepository;
	@Autowired
	protected ModelMapper modelMapper;
	protected Class<E> entityClass;
	protected Class<D> dtoClass;
	@SuppressWarnings("unchecked")
	public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
		this.baseRepository = baseRepository;
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[2];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[0];
	}

		private E mapearEntidad(D dto) {
			E entidad = modelMapper.map(dto, entityClass);
			return entidad;
		}
		private D mapearDto(E e) {
			D dto = modelMapper.map(e, dtoClass);
			return dto;
		}
	@Override
	public Page<D> findAll(Pageable pageable) throws Exception {
		try {
			Page<E> entidades = baseRepository.findAll(pageable);
			Page<D> dtos = entidades.map(new Function<E, D>() {
				
				@Override
				public D apply(E t) {
					
					return mapearDto(t);
				}
				
			});
			return dtos;
		} catch (Exception e) {
			throw new Exception(e.fillInStackTrace());
		}
	
	}

	@Override
	public D findById(ID id) throws Exception {
		try {
			return mapearDto(baseRepository.findById(id).get());
		} catch (Exception e) {
			throw new Exception(e.fillInStackTrace());
		}
	}

	@Override
	public D save(D dto) throws Exception {
		try {
			return mapearDto(baseRepository.save(mapearEntidad(dto)));
		} catch (Exception e) {
			throw new Exception(e.fillInStackTrace());
		}
	}

	@Override
	public D update(ID id, D dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ID id) throws Exception {
		try {
			baseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception(e.fillInStackTrace());
		}
		
	}



}
