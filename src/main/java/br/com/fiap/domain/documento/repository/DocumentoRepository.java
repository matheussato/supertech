package br.com.fiap.domain.documento.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.documento.model.Documento;
import br.com.fiap.domain.documento.model.TipoDocumento;

import java.util.List;

public class DocumentoRepository extends Repository {
    public static Documento save(Documento d) {
        TipoDocumento tipoDoc = d.getTipo();

        if (tipoDoc != null) {
            if (tipoDoc.getId() != null) {
                tipoDoc = manager.find(TipoDocumento.class, tipoDoc.getId());
            } else {
                TipoDocumentoRepository.save(tipoDoc);
            }

            d.setTipo(tipoDoc);
        }

        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();

        return d;
    }

    public static Documento findById(Long id) { return manager.find(Documento.class, id); }

    public static List<?> findAll() { return manager.createQuery("From Documento").getResultList(); }
}
