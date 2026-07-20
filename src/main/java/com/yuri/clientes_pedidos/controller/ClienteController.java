package com.yuri.clientes_pedidos.controller;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.service.ClienteService;
import lombok.RequiredArgsConstructor;
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
	public List<ClienteResponseDto> findAll() {
		return clienteService.findAll();
	}

	@PostMapping
	public ClienteResponseDto  save(@RequestBody ClienteRequestDto clienteRequestDto) {
		return clienteService.save(clienteRequestDto);
	}
}
