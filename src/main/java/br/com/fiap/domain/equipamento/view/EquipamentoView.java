package br.com.fiap.domain.equipamento.view;

import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;

import javax.swing.*;

public abstract class EquipamentoView {
    public static Equipamento form(Equipamento e) {
        TipoEquipamento tipo = TipoEquipamentoView.select(e == null ? null : e.getTipo());
        Equipamento equip = new Equipamento();

        equip.setTipo(TipoEquipamentoView.select(e == null ? null : e.getTipo()))
                .setNome(JOptionPane.showInputDialog("Nome do " + tipo.getNome(), e == null ? "" : e.getNome()))
                .setNumeroDeSerie(JOptionPane.showInputDialog("Número de série do(a) " + tipo.getNome(), e == null ? "" : e.getNumeroDeSerie()))
                .setId(e == null ? null : e.getId());

        return equip;
    }
}
