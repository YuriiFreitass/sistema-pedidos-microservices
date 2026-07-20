package com.yuri.clientes_pedidos.service;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.entity.ClienteEntity;
import com.yuri.clientes_pedidos.exception.ClienteNaoEncontradoException;
import com.yuri.clientes_pedidos.exception.EmailDuplicadoException;
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
	public ClienteResponseDto findById(Long id) {
		ClienteEntity cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
	return clienteMapper.toResponseDto(cliente);

	}

	public ClienteResponseDto save(ClienteRequestDto clienteRequestDto) {
		if(clienteRepository.existsByEmail(clienteRequestDto.email())) {
			throw new EmailDuplicadoException("Email já cadastrado");

		}
		ClienteEntity cliente = clienteMapper.toEntity(clienteRequestDto);

		ClienteEntity clienteSalvo = clienteRepository.save(cliente);

		return clienteMapper.toResponseDto(clienteSalvo);
	}
}
