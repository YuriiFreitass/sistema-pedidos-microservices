package com.yuri.clientes_pedidos.repository;

import com.yuri.clientes_pedidos.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	boolean existsByEmail(String email);
}
