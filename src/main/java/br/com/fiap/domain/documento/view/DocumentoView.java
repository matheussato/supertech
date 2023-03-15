package br.com.fiap.domain.documento.view;

import br.com.fiap.domain.cliente.view.TipoClienteView;
import br.com.fiap.domain.documento.model.Documento;
import br.com.fiap.domain.documento.model.TipoDocumento;

import javax.swing.*;
import java.time.LocalDate;

public abstract class DocumentoView {
    public static Documento form(Documento d) {
        TipoDocumento tipo = TipoDocumentoView.select(d == null ? null : d.getTipo());
        Documento doc = new Documento();

        doc.setTipo(TipoDocumentoView.select(d == null ? null : d.getTipo()))
                .setCliente(d == null ? null : d.getCliente())
                .setNumero(JOptionPane.showInputDialog("Digite o número do documento: "))
                .setEmissao(LocalDate.now());

        return doc;
    }
}
