package com.yuri.clientes_pedidos.controller;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ClienteResponseDto> findAll(Pageable pageable) {
		return clienteService.findAll(pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDto  save(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
		return clienteService.save(clienteRequestDto);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto update(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto clienteRequestDto) {
		return clienteService.update(id, clienteRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
}
