package com.yuri.clientes_pedidos.service;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.entity.ClienteEntity;
import com.yuri.clientes_pedidos.mapper.ClienteMapper;
import com.yuri.clientes_pedidos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;

	public List<ClienteResponseDto> findAll() {
		return clienteRepository.findAll()
				.stream()
				.map(clienteMapper::toResponseDto)
				.toList();
	}

	public ClienteResponseDto save(ClienteRequestDto clienteRequestDto) {
		ClienteEntity cliente = clienteMapper.toEntity(clienteRequestDto);

		ClienteEntity clienteSalvo = clienteRepository.save(cliente);

		return clienteMapper.toResponseDto(clienteSalvo);
	}
}
