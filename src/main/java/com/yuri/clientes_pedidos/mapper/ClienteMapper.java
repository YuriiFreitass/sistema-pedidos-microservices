package com.yuri.clientes_pedidos.mapper;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	ClienteEntity toEntity(ClienteRequestDto clienteRequestDto);

	ClienteResponseDto toResponseDto(ClienteEntity clienteEntity);

	void updateEntityFromDto(
			ClienteRequestDto clienteRequestDto,
			@MappingTarget ClienteEntity clienteEntity
	);
}
