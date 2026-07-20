package com.yuri.clientes_pedidos.dto;

public record ClienteResponseDto(
		Long id,
		String nome,
		String email,
		String telefone
) {}
