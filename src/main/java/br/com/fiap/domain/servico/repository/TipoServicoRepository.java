package br.com.fiap.domain.servico.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.servico.model.TipoServico;
import org.hibernate.exception.ConstraintViolationException;

import javax.swing.*;
import java.util.List;

public class TipoServicoRepository extends Repository {
    public static TipoServico save(TipoServico ts) {
        manager.getTransaction().begin();

        try {
            manager.persist(ts);
            manager.getTransaction().commit();

            return ts;
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de serviço já consta no banco de dados!");

            return null;
        }
    }

    public static TipoServico findById(Long id) { return manager.find(TipoServico.class, id); }

    public static List<?> findAll() { return manager.createQuery("From TipoServico").getResultList(); }
}
