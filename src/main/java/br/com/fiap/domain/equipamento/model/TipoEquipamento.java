package br.com.fiap.domain.equipamento.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "tb_tp_equipamento",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_nome_tp_equipamento",
                        columnNames = "nm_tp_equipamento"
                )
        }
)
public class TipoEquipamento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tp_equipamento"
    )
    @SequenceGenerator(
            name = "seq_tp_equipamento",
            sequenceName = "seq_tb_equipamento",
            allocationSize = 1
    )
    @Column(name = "id_tp_equipamento")
    private Long id;

    @Column(name = "nm_tp_equipamento")
    private String nome;

    public TipoEquipamento() {}

    public TipoEquipamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoEquipamento(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoEquipamento setId(Long id) {
        this.id = id;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoEquipamento setNome(String nome) {
        this.nome = nome;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoEquipamento that = (TipoEquipamento) o;

        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
