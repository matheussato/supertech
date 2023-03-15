package br.com.fiap.domain.cliente.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.cliente.model.TipoCliente;
import org.hibernate.exception.ConstraintViolationException;

import javax.swing.*;
import java.util.List;

public class TipoClienteRepository extends Repository {
    public static TipoCliente save(TipoCliente tc) {
        manager.getTransaction().begin();

        try {
            manager.persist(tc);
            manager.getTransaction().commit();

            return tc;
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de cliente já consta no banco de dados!");

            return null;
        }
    }

    public static TipoCliente findById(Long id) { return manager.find(TipoCliente.class, id); }

    public static List<?> findAll() { return manager.createQuery("From TipoCliente").getResultList(); }
}
