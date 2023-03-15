package br.com.fiap.domain.cliente.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.cliente.model.Cliente;
import br.com.fiap.domain.cliente.model.TipoCliente;

import java.util.List;

public class ClienteRepository extends Repository {
    public static Cliente save(Cliente c) {
        TipoCliente tipoCli = c.getTipo();

        if (tipoCli != null) {
            if (tipoCli.getId() != null) {
                tipoCli = manager.find(TipoCliente.class, tipoCli.getId());
            } else {
                TipoClienteRepository.save(tipoCli);
            }

            c.setTipo(tipoCli);
        }

        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();

        return c;
    }

    public static Cliente findById(Long id) { return manager.find(Cliente.class, id); }

    public static List<?> findAll() { return manager.createQuery("From Cliente").getResultList(); }
}
