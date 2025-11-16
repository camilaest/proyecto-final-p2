package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;

public abstract class GeneradorDocumentoPDF {
    public final void generar(File file) throws IOException {
        // 1. Crear documento
        try (PDDocument doc = new PDDocument()) {

            // 2. Crear página y content stream
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);

            // 3. Dibujar encabezado genérico
            dibujarEncabezado(doc, page, content);

            // 4. Dibujar contenido específico (cada subclase lo implementa)
            dibujarContenido(doc, page, content);

            // 5. Cerrar y guardar
            content.close();
            doc.save(file);
        }
    }

    // Paso común pero personalizable (puedes dejarlo no abstracto con implementación por defecto)
    protected void dibujarEncabezado(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException {
        // Ej: barra azul y título, puedes usar parámetros o un título fijo
    }

    // Obligatorio para cada tipo de documento
    protected abstract void dibujarContenido(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException;


}
