package br.com.fiap.domain.servico.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_servico")
public class Servico {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_servico"
    )
    @SequenceGenerator(
            name = "seq_servico",
            sequenceName = "seq_servico",
            allocationSize = 1
    )
    @Column(name = "id_servico")
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.REFRESH
    )
    @JoinColumn(
            name = "id_tp_servico",
            referencedColumnName = "id_tp_servico",
            foreignKey = @ForeignKey(name = "fk_tb_tp_servico", value = ConstraintMode.CONSTRAINT)
    )
    private TipoServico tipo;

    @Column(name = "nm_servico")
    private String nome;

    @Column(name = "descricao_servico")
    private String descricao;

    @Column(name = "dt_abertura_servico")
    private LocalDateTime dataAberturaServico;

    @Column(name = "dt_autorizacao_servico")
    private LocalDateTime dataAutorizacaoServico;

    @Column(name = "dt_inicio_servico")
    private LocalDateTime dataInicioServico;

    @Column(name = "dt_conclusao_servico")
    private LocalDateTime dataConclusaoServico;

    public Servico() {}

    public Servico(Long id, TipoServico tipo, String nome, String descricao, LocalDateTime dataAberturaServico, LocalDateTime dataAutorizacaoServico, LocalDateTime dataInicioServico, LocalDateTime dataConclusaoServico) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAberturaServico = dataAberturaServico;
        this.dataAutorizacaoServico = dataAutorizacaoServico;
        this.dataInicioServico = dataInicioServico;
        this.dataConclusaoServico = dataConclusaoServico;
    }

    public Servico(TipoServico tipo, String nome, String descricao, LocalDateTime dataAberturaServico, LocalDateTime dataAutorizacaoServico, LocalDateTime dataInicioServico, LocalDateTime dataConclusaoServico) {
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAberturaServico = dataAberturaServico;
        this.dataAutorizacaoServico = dataAutorizacaoServico;
        this.dataInicioServico = dataInicioServico;
        this.dataConclusaoServico = dataConclusaoServico;
    }

    public Long getId() {
        return id;
    }

    public Servico setId(Long id) {
        this.id = id;

        return this;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public Servico setTipo(TipoServico tipo) {
        this.tipo = tipo;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public Servico setNome(String nome) {
        this.nome = nome;

        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Servico setDescricao(String descricao) {
        this.descricao = descricao;

        return this;
    }

    public LocalDateTime getDataAberturaServico() {
        return dataAberturaServico;
    }

    public Servico setDataAberturaServico(LocalDateTime dataAberturaServico) {
        this.dataAberturaServico = dataAberturaServico;

        return this;
    }

    public LocalDateTime getDataAutorizacaoServico() {
        return dataAutorizacaoServico;
    }

    public Servico setDataAutorizacaoServico(LocalDateTime dataAutorizacaoServico) {
        this.dataAutorizacaoServico = dataAutorizacaoServico;

        return this;
    }

    public LocalDateTime getDataInicioServico() {
        return dataInicioServico;
    }

    public Servico setDataInicioServico(LocalDateTime dataInicioServico) {
        this.dataInicioServico = dataInicioServico;

        return this;
    }

    public LocalDateTime getDataConclusaoServico() {
        return dataConclusaoServico;
    }

    public Servico setDataConclusaoServico(LocalDateTime dataConclusaoServico) {
        this.dataConclusaoServico = dataConclusaoServico;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;

        return Objects.equals(id, servico.id) && Objects.equals(nome, servico.nome) && Objects.equals(descricao, servico.descricao) && Objects.equals(dataAberturaServico, servico.dataAberturaServico) && Objects.equals(dataAutorizacaoServico, servico.dataAutorizacaoServico) && Objects.equals(dataInicioServico, servico.dataInicioServico) && Objects.equals(dataConclusaoServico, servico.dataConclusaoServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dataAberturaServico, dataAutorizacaoServico, dataInicioServico, dataConclusaoServico);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Servico {");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append(", descricao = '").append(descricao).append('\'');
        sb.append(", dataAberturaServico = ").append(dataAberturaServico);
        sb.append(", dataAutorizacaoServico = ").append(dataAutorizacaoServico);
        sb.append(", dataInicioServico = ").append(dataInicioServico);
        sb.append(", dataConclusaoServico = ").append(dataConclusaoServico);
        sb.append('}');

        return sb.toString();
    }
}
