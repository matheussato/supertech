package br.com.fiap.domain.equipamento.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;

import java.util.List;

public class EquipamentoRepository extends Repository {
    public static Equipamento save(Equipamento e) {
        TipoEquipamento tipoEquip = e.getTipo();

        if (tipoEquip != null) {
            if (tipoEquip.getId() != null) {
                tipoEquip = manager.find(TipoEquipamento.class, tipoEquip.getId());
            } else {
                TipoEquipamentoRepository.save(tipoEquip);
            }

            e.setTipo(tipoEquip);
        }

        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();

        return e;
    }

    public static Equipamento findById(Long id) {
        return manager.find(Equipamento.class, id);
    }

    public static List<?> findAll() {
        return manager.createQuery("From Equipamento").getResultList();
    }
}
