package com.yuri.clientes_pedidos.dto;

import java.util.List;

public record ErrorResponseDto(
		int status,
		String mensagem,
		List<CampoErrorDto> campos
) {}
