package br.com.fiap.domain.servico.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.servico.model.Servico;
import br.com.fiap.domain.servico.model.TipoServico;

import java.util.List;

public class ServicoRepository extends Repository {
    public static Servico save(Servico s) {
        TipoServico tipoServ = s.getTipo();

        if (tipoServ != null) {
            if (tipoServ.getId() != null) {
                tipoServ = manager.find(TipoServico.class, tipoServ.getId());
            } else {
                TipoServicoRepository.save(tipoServ);
            }

            s.setTipo(tipoServ);
        }

        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();

        return s;
    }

    public static Servico findById(Long id) { return manager.find(Servico.class, id); }

    public static List<?> findAll() { return manager.createQuery("From Servico").getResultList(); }
}
