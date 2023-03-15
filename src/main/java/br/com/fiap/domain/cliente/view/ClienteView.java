package br.com.fiap.domain.cliente.view;

import br.com.fiap.domain.cliente.model.Cliente;
import br.com.fiap.domain.cliente.model.Telefone;

import javax.swing.*;
import java.time.LocalDate;

public abstract class ClienteView {
    public static Cliente form(Cliente c) {
        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Nome do cliente: "))
                .setTipo(c == null ? null : c.getTipo())
                .setEmail(JOptionPane.showInputDialog("Email do cliente: "))
                .setTelefone(new Telefone(
                        JOptionPane.showInputDialog("Digite o DDI: "),
                        JOptionPane.showInputDialog("Digite o DDD: "),
                        JOptionPane.showInputDialog("Digite o número de celular: ")
                ))
                .setDtNascimento(LocalDate.now());

        return cliente;
    }
}
