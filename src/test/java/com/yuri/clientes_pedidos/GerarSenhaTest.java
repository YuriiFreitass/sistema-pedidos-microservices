package com.yuri.clientes_pedidos;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenhaTest {

	@Test
	void gerarHash() {
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		System.out.println(enconder.encode("0855"));
	}
}
