package br.com.fiap.domain.servico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tp_servico")
public class TipoServico {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tp_servico"
    )
    @SequenceGenerator(
            name = "seq_tp_servico",
            sequenceName = "seq_tp_servico",
            allocationSize = 1
    )
    @Column(name = "id_tp_servico")
    private Long id;

    @Column(name = "nm_tp_servico")
    private String nome;

    public TipoServico() {}

    public TipoServico(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoServico(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoServico setId(Long id) {
        this.id = id;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoServico setNome(String nome) {
        this.nome = nome;

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoServico {");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
