package br.com.fiap.domain.servico.view;

import br.com.fiap.domain.servico.model.Servico;

import javax.swing.*;
import java.time.LocalDateTime;

public abstract class ServicoView {
    public static Servico form() {
        Servico servico = new Servico();

        servico.setNome(JOptionPane.showInputDialog("Nome do serviço: "))
                .setDescricao(JOptionPane.showInputDialog("Descrição do serviço: "))
                .setDataAberturaServico(LocalDateTime.now());

        return servico;
    }
}
