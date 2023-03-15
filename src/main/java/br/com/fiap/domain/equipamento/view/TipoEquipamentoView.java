package br.com.fiap.domain.equipamento.view;

import br.com.fiap.domain.equipamento.model.TipoEquipamento;
import br.com.fiap.domain.equipamento.repository.TipoEquipamentoRepository;

import javax.swing.*;
import java.util.List;

import static br.com.fiap.domain.equipamento.repository.TipoEquipamentoRepository.findAll;

public abstract class TipoEquipamentoView {
    public static TipoEquipamento form(TipoEquipamento te) {
        TipoEquipamento tipoEquip = new TipoEquipamento();

        tipoEquip.setNome(JOptionPane.showInputDialog("Tipo do equipamento: ", te == null ? "" : te.getNome()))
                .setId(te == null ? null : te.getId());

        return tipoEquip;
    }

    public static TipoEquipamento select(TipoEquipamento te) {
        List<?> tipos = TipoEquipamentoRepository.findAll();

        if (tipos.isEmpty()) return form(null);

        return (TipoEquipamento) JOptionPane.showInputDialog(
                null,
                "Tipo de Equipamento",
                "Tipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos.toArray(),
                te == null ? 1 : te
        );
    }
}
