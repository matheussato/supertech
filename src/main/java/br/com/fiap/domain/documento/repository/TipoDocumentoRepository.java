package br.com.fiap.domain.documento.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.documento.model.TipoDocumento;
import org.hibernate.exception.ConstraintViolationException;

import javax.swing.*;
import java.util.List;

public class TipoDocumentoRepository extends Repository {
    public static TipoDocumento save(TipoDocumento td) {
        manager.getTransaction().begin();

        try {
            manager.persist(td);
            manager.getTransaction().commit();

            return td;
        } catch (ConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de documento já consta no banco de dados!");

            return null;
        }
    }

    public static TipoDocumento findById(Long id) { return manager.find(TipoDocumento.class, id); }

    public static List<?> findAll() { return manager.createQuery("From TipoDocumento").getResultList(); }
}
