package com.yuri.clientes_pedidos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDto(
		@NotBlank String nome,
		@Email String email,
		@NotBlank String telefone
) {}
