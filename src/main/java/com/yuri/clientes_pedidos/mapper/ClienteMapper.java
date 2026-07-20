package com.yuri.clientes_pedidos.mapper;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.entity.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface ClienteMapper {

	ClienteEntity toEntity(ClienteRequestDto clienteRequestDto);

	ClienteResponseDto toResponseDto(ClienteEntity clienteEntity);
}
