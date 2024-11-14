// ClienteRepository.java
package com.exemplo.demo.repository;

import com.exemplo.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
