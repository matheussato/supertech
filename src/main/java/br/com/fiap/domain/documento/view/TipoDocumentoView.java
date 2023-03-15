package br.com.fiap.domain.documento.view;

import br.com.fiap.domain.documento.model.TipoDocumento;
import br.com.fiap.domain.documento.repository.TipoDocumentoRepository;

import javax.swing.*;
import java.util.List;

public abstract class TipoDocumentoView {
    public static TipoDocumento form(TipoDocumento td) {
        TipoDocumento tipoDoc = new TipoDocumento();

        tipoDoc.setNome(JOptionPane.showInputDialog("Nome do documento: "))
                .setId(td == null ? null : td.getId());

        return tipoDoc;
    }

    public static TipoDocumento select(TipoDocumento td) {
        List<?> tipos = TipoDocumentoRepository.findAll();

        if (tipos.isEmpty()) return form(null);

        return (TipoDocumento) JOptionPane.showInputDialog(
                null,
                "Tipo de documento",
                "Tipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos.toArray(),
                td == null ? 1 : td
        );
    }
}
