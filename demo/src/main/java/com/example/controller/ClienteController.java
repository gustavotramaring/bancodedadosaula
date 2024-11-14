// ClienteController.java
package com.exemplo.demo.controller;

import com.exemplo.demo.model.Cliente;
import com.exemplo.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Exibe a lista de clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "index";
    }

    // Atualiza o limite de crédito do cliente
    @PostMapping("/atualizar/{id}")
    public String atualizarLimite(@PathVariable("id") Long id, @RequestParam("limite") BigDecimal novoLimite) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setLimite(novoLimite);
            clienteRepository.save(cliente);
        }
        return "redirect:/clientes";
    }
}
