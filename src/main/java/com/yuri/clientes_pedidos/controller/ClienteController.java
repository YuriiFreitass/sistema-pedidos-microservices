package com.yuri.clientes_pedidos.controller;

import com.yuri.clientes_pedidos.dto.ClienteRequestDto;
import com.yuri.clientes_pedidos.dto.ClienteResponseDto;
import com.yuri.clientes_pedidos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes.")
@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;

	@Operation(summary = "Listar clientes")
	@ApiResponse(responseCode = "200", description = "Clientes retornados com sucesso")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ClienteResponseDto> findAll(Pageable pageable) {
		return clienteService.findAll(pageable);
	}

	@Operation(summary = "Cadastrar clientes")
	@ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDto save(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
		return clienteService.save(clienteRequestDto);
	}

	@Operation(summary = "Buscar clientes por ID")
	@ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso")
	@ApiResponse(responseCode = "404", description = "Cliente não encontrado")
	@ApiResponse
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@Operation(summary = "Atualizar clientes")
	@ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponseDto update(@PathVariable Long id, @Valid @RequestBody ClienteRequestDto clienteRequestDto) {
		return clienteService.update(id, clienteRequestDto);
	}

	@Operation(summary = "Excluir cliente")
	@ApiResponse(responseCode = "204", description = "Livro removido com sucesso")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
}
