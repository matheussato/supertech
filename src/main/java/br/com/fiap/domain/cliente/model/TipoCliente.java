package br.com.fiap.domain.cliente.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_tp_cliente")
public class TipoCliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tp_cliente"
    )
    @SequenceGenerator(
            name = "seq_tp_cliente",
            sequenceName = "seq_tp_cliente",
            allocationSize = 1
    )
    @Column(name = "id_tp_cliente")
    private Long id;

    @Column(name = "nm_tp_cliente")
    private String nome;

    public Long getId() {
        return id;
    }

    public TipoCliente setId(Long id) {
        this.id = id;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoCliente setNome(String nome) {
        this.nome = nome;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCliente that = (TipoCliente) o;

        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoCliente {");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
