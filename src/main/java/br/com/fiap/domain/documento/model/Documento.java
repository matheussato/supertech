package br.com.fiap.domain.documento.model;

import br.com.fiap.domain.cliente.model.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_documento")
public class Documento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_documento"
    )
    @SequenceGenerator(
            name = "seq_documento",
            sequenceName = "seq_documento"
    )
    @Column(name = "id_documento")
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_cliente",
            referencedColumnName = "id_cliente",
            foreignKey = @ForeignKey(
                    name = "fk_doc_cliente",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Cliente cliente;

    @Column(name = "nr_documento")
    private String numero;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_tp_documento",
            referencedColumnName = "id_tp_documento",
            foreignKey = @ForeignKey(
                    name = "fk_tp_documento",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private TipoDocumento tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_emissao_documento")
    private LocalDate emissao;

    public Documento() {}

    public Documento(Long id, Cliente cliente, String numero, TipoDocumento tipo, LocalDate emissao) {
        this.id = id;
        this.cliente = cliente;
        this.numero = numero;
        this.tipo = tipo;
        this.emissao = emissao;
    }

    public Documento(Cliente cliente, String numero, TipoDocumento tipo, LocalDate emissao) {
        this.cliente = cliente;
        this.numero = numero;
        this.tipo = tipo;
        this.emissao = emissao;
    }

    public Long getId() {
        return id;
    }

    public Documento setId(Long id) {
        this.id = id;

        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Documento setCliente(Cliente cliente) {
        this.cliente = cliente;

        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Documento setNumero(String numero) {
        this.numero = numero;

        return this;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public Documento setTipo(TipoDocumento tipo) {
        this.tipo = tipo;

        return this;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public Documento setEmissao(LocalDate emissao) {
        this.emissao = emissao;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;

        return Objects.equals(id, documento.id) && Objects.equals(cliente, documento.cliente) && Objects.equals(numero, documento.numero) && Objects.equals(tipo, documento.tipo) && Objects.equals(emissao, documento.emissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, numero, tipo, emissao);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Documento {");
        sb.append("id = ").append(id);
        sb.append(", cliente = ").append(cliente);
        sb.append(", numero = '").append(numero).append('\'');
        sb.append(", tipo = ").append(tipo);
        sb.append(", emissao = ").append(emissao);
        sb.append('}');

        return sb.toString();
    }
}
