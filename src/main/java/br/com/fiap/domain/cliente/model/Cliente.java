package br.com.fiap.domain.cliente.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(
        name = "tb_cliente",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_email_cliente",
                        columnNames = "email_cliente"
                ),
                @UniqueConstraint(
                        name = "id_cliente",
                        columnNames = "id_cliente"
                )
        },
        indexes = {
                @Index(
                        name = "idx_nm_cliente",
                        columnList = "nm_cliente"
                ),
                @Index(
                        name = "idx_email_cliente",
                        columnList = "email_cliente"
                )
        }
)
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_cliente"
    )
    @SequenceGenerator(
            name = "seq_cliente",
            sequenceName = "seq_cliente",
            allocationSize = 1
    )
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nm_cliente")
    private String nome;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_tp_cliente",
            referencedColumnName = "id_tp_cliente",
            foreignKey = @ForeignKey(name = "fk_tp_cliente", value = ConstraintMode.CONSTRAINT)
    )
    private TipoCliente tipo;

    @Column(name = "email_cliente")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nasc_cliente")
    private LocalDate dtNascimento;

    @Embedded
    private Telefone telefone;

    public Cliente() {}

    public Cliente(Long id, String nome, TipoCliente tipo, String email, LocalDate dtNascimento, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
    }

    public Cliente(String nome, TipoCliente tipo, String email, LocalDate dtNascimento, Telefone telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;

        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;

        return this;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public Cliente setTipo(TipoCliente tipo) {
        this.tipo = tipo;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;

        return this;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public Cliente setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;

        return this;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(Telefone telefone) {
        this.telefone = telefone;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;

        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(tipo, cliente.tipo) && Objects.equals(email, cliente.email) && Objects.equals(dtNascimento, cliente.dtNascimento) && Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tipo, email, dtNascimento, telefone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente {");
        sb.append("id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append(", tipo = ").append(tipo);
        sb.append(", email = '").append(email).append('\'');
        sb.append(", dtNascimento = ").append(dtNascimento);
        sb.append(", telefone = ").append(telefone);
        sb.append('}');

        return sb.toString();
    }
}
