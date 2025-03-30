package com.abastek.api.controllers;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.abastek.api.dtos.RelatorioDTO;
import com.abastek.api.services.RelatorioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {
    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RelatorioDTO>> gerar() {
        return ResponseEntity.ok(service.gerarRelatorio());
    }

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> gerarRelatorioPDF() {
        List<RelatorioDTO> dados = service.gerarRelatorio(); // Obtém os dados do relatório

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            //Adicionar a logo
            String imagePath = "src/main/resources/static/logo.png"; // Caminho da imagem
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image logo = new Image(imageData);
            logo.scaleToFit(100, 100); // Ajusta o tamanho da logo
            logo.setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(logo);

            //Fonte em negrito para o título
            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            //Adiciona título
            Text title = new Text("Relatório de Manutenções").setFont(boldFont).setFontSize(16);
            document.add(new Paragraph(title));

            //Criando a tabela
            Table table = new Table(5);
            table.addCell(new Cell().add(new Paragraph("Equipamento").setFont(boldFont)));
            table.addCell(new Cell().add(new Paragraph("Setor").setFont(boldFont)));
            table.addCell(new Cell().add(new Paragraph("Descrição").setFont(boldFont)));
            table.addCell(new Cell().add(new Paragraph("Data").setFont(boldFont)));
            table.addCell(new Cell().add(new Paragraph("Codigo").setFont(boldFont)));

            //Preenchendo a tabela com os dados
            for (RelatorioDTO dto : dados) {
                table.addCell(new Cell().add(new Paragraph(dto.getEquipamentoNome())));
                table.addCell(new Cell().add(new Paragraph(dto.getSetor())));
                table.addCell(new Cell().add(new Paragraph(dto.getDescricaoManutencao())));
                table.addCell(new Cell().add(new Paragraph(dto.getDataManutencao().toString())));
                table.addCell(new Cell().add(new Paragraph(dto.getCodigoEquipamento())));
            }

            document.add(table);
            document.close();

            //Retorna o PDF
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o PDF", e);
        }
    }
}
