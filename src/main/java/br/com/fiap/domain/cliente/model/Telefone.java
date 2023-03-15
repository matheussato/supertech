package br.com.fiap.domain.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Telefone {
    @Column(
            name = "ddi_tel",
            length = 4
    )
    private String ddi;

    @Column(
            name = "ddd_tel",
            length = 7
    )
    private String ddd;

    @Column(
            name = "nr_tel",
            length = 25
    )
    private String telefone;

    public Telefone() {}

    public Telefone(String ddi, String ddd, String telefone) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public String getDdi() {
        return ddi;
    }

    public Telefone setDdi(String ddi) {
        this.ddi = ddi;

        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public Telefone setDdd(String ddd) {
        this.ddd = ddd;

        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Telefone setTelefone(String telefone) {
        this.telefone = telefone;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone1 = (Telefone) o;

        return Objects.equals(ddi, telefone1.ddi) && Objects.equals(ddd, telefone1.ddd) && Objects.equals(telefone, telefone1.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddi, ddd, telefone);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telefone {");
        sb.append("ddi = '").append(ddi).append('\'');
        sb.append(", ddd = '").append(ddd).append('\'');
        sb.append(", telefone = '").append(telefone).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
