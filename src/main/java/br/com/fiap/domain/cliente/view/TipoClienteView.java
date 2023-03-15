package br.com.fiap.domain.cliente.view;

import br.com.fiap.domain.cliente.model.TipoCliente;
import br.com.fiap.domain.cliente.repository.TipoClienteRepository;

import javax.swing.*;
import java.util.List;

public abstract class TipoClienteView {
    public static TipoCliente form(TipoCliente tc) {
        TipoCliente tipoCli = new TipoCliente();

        tipoCli.setNome(JOptionPane.showInputDialog("Nome do tipo de cliente: "))
                .setId(tc == null ? null : tc.getId());

        return tipoCli;
    }

    public static TipoCliente select(TipoCliente tc) {
        List<?> tipos = TipoClienteRepository.findAll();

        if (tipos.isEmpty()) return form(null);

        return (TipoCliente) JOptionPane.showInputDialog(
                null,
                "Tipo de cliente",
                "Tipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos.toArray(),
                tc == null ? 1 : tc
        );
    }
}
