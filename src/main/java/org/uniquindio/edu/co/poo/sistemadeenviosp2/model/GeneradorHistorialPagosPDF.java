package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class GeneradorHistorialPagosPDF extends GeneradorDocumentoPDF{

    private final List<Pago> pagos;

    public GeneradorHistorialPagosPDF(List<Pago> pagos) {
        this.pagos = pagos;
    }

    @Override
    protected void dibujarEncabezado(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException {
        float pageWidth = page.getMediaBox().getWidth();


        content.setNonStrokingColor(30, 144, 255);
        content.addRect(0, 750, pageWidth, 50);
        content.fill();

        // Título
        content.setNonStrokingColor(255, 255, 255);
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 22);
        content.newLineAtOffset(30, 770);
        content.showText("Historial de Pagos");
        content.endText();


        content.setNonStrokingColor(0, 0, 0);
    }

    @Override
    protected void dibujarContenido(PDDocument doc, PDPage page, PDPageContentStream content) throws IOException {

        float y = 680;
        float rowSpacing = 18;

        content.setFont(PDType1Font.HELVETICA, 12);

        for (Pago pago : pagos) {

            if (y < 120) {

                content.close();
                page = new PDPage();
                doc.addPage(page);
                content = new PDPageContentStream(doc, page);
                y = 720;
            }


            content.moveTo(30, y);
            content.lineTo(570, y);
            content.stroke();
            y -= rowSpacing;


            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("ID: " + pago.getIdPago()); content.endText();
            y -= rowSpacing;

            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("Fecha: " + pago.getFechaPago()); content.endText();
            y -= rowSpacing;

            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("Método: " + pago.getMetodoDePago().name()); content.endText();
            y -= rowSpacing;

            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("Monto: " + pago.getMonto()); content.endText();
            y -= rowSpacing;

            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("Tributos: " + pago.getTributos()); content.endText();
            y -= rowSpacing;

            content.beginText(); content.newLineAtOffset(40, y);
            content.showText("Total: " + pago.getTotal()); content.endText();
            y -= rowSpacing;


            y -= 5;
            content.moveTo(30, y);
            content.lineTo(570, y);
            content.stroke();

            y -= 25;
        }
    }
}

