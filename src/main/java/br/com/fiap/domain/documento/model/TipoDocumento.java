package br.com.fiap.domain.documento.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tp_documento"
    )
    @SequenceGenerator(
            name = "seq_tp_documento",
            sequenceName = "seq_tp_documento",
            allocationSize = 1
    )
    @Column(name = "id_tp_documento")
    private Long id;

    @Column(name = "nm_tp_documento")
    private String nome;

    public TipoDocumento() {}

    public TipoDocumento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoDocumento(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoDocumento setId(Long id) {
        this.id = id;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDocumento setNome(String nome) {
        this.nome = nome;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDocumento that = (TipoDocumento) o;

        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoDocumento {");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
