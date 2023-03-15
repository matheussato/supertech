package br.com.fiap.domain.servico.view;

import br.com.fiap.domain.servico.model.TipoServico;
import br.com.fiap.domain.servico.repository.TipoServicoRepository;

import javax.swing.*;
import java.util.List;

public abstract class TipoServicoView {
    public static TipoServico form(TipoServico ts) {
        TipoServico tipoServ = new TipoServico();

        tipoServ.setNome(JOptionPane.showInputDialog("Digite o tipo do serviço: "));
        tipoServ.setId(ts == null ? null : ts.getId());

        return tipoServ;
    }

    public static TipoServico select(TipoServico ts) {
        List<?> tipos = TipoServicoRepository.findAll();

        if (tipos.isEmpty()) return form(null);

        return (TipoServico) JOptionPane.showInputDialog(
                null,
                "Tipo de Serviço",
                "Tipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos.toArray(),
                ts == null ? 1 : ts
        );
    }
}
