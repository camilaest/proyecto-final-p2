package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;

public abstract class GeneradorDocumentoPDF {
    public final void generar(File file) throws IOException {

        try (PDDocument doc = new PDDocument()) {


            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);


            dibujarEncabezado(doc, page, content);


            dibujarContenido(doc, page, content);


            content.close();
            doc.save(file);
        }
    }


    protected void dibujarEncabezado(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException {

    }


    protected abstract void dibujarContenido(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException;


}
