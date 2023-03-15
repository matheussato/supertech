package br.com.fiap.domain.equipamento.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;
import org.hibernate.exception.ConstraintViolationException;

import javax.swing.*;
import java.util.List;

public class TipoEquipamentoRepository extends Repository {
    public static TipoEquipamento save(TipoEquipamento te) {
        manager.getTransaction().begin();

        try {
            manager.persist(te);
            manager.getTransaction().commit();

            return te;
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de equipamento já consta no banco de dados!");

            return null;
        }
    }

    public static TipoEquipamento findById(Long id) {
        return manager.find(TipoEquipamento.class, id);
    }

    public static List<?> findAll() {
        return manager.createQuery("From TipoEquipamento").getResultList();
    }
}
