package com.yuri.clientes_pedidos.service;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.entity.ClienteEntity;
import com.yuri.clientes_pedidos.exception.ClienteNaoEncontradoException;
import com.yuri.clientes_pedidos.exception.EmailDuplicadoException;
import com.yuri.clientes_pedidos.mapper.ClienteMapper;
import com.yuri.clientes_pedidos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;

	public Page<ClienteResponseDto> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable)
				.map(clienteMapper::toResponseDto);


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

	public ClienteResponseDto update(Long id, ClienteRequestDto clienteRequestDto) {
		ClienteEntity cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException("O cliente não foi encontrado"));
		if (clienteRepository.existsByEmailAndIdNot(clienteRequestDto.email(), id)) {
			throw new EmailDuplicadoException("Email já cadastrado");
		}
		clienteMapper.updateEntityFromDto(clienteRequestDto, cliente);

		ClienteEntity clienteSalvo = clienteRepository.save(cliente);

		return clienteMapper.toResponseDto(clienteSalvo);
	}

	public void deleteById(Long id) {
		ClienteEntity cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException("O cliente com ID " + id + " não foi encontrado"));
		clienteRepository.delete(cliente);
	}
}
