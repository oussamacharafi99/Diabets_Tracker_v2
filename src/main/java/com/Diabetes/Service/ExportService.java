package com.Diabetes.Service;

import com.Diabetes.Models.Rapport;
import com.Diabetes.Models.Users.User;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ExportService {

    public byte[] exportToPDF(List<Rapport> rapports, User user) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Liste des Rapports"));
        for (Rapport rapport : rapports) {
            document.add(new Paragraph("ID: " + rapport.getId()));
            document.add(new Paragraph("Date de Génération: " + rapport.getDateGeneration()));
            document.add(new Paragraph("Contenu: " + rapport.getContenu()));
            document.add(new Paragraph("-------------------------"));
        }

        document.add(new Paragraph("Détails de l'Utilisateur"));
        document.add(new Paragraph("ID: " + user.getId()));
        document.add(new Paragraph("Nom d'utilisateur: " + user.getUsername()));
        document.add(new Paragraph("Age: " + user.getAge()));
        document.add(new Paragraph("Email: " + user.getEmail()));

        document.close();
//        if (base64Image != null && !base64Image.isEmpty()) {
//            byte[] imageBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);
//            Image img = new Image(ImageDataFactory.create(imageBytes));
//            img.setAutoScale(true);
//            document.add(img);
//        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] exportToWord(List<Rapport> rapports, User user) throws IOException {
        XWPFDocument document = new XWPFDocument();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        XWPFParagraph title = document.createParagraph();
        XWPFRun run = title.createRun();
        run.setText("Liste des Rapports");
        run.setBold(true);

        for (Rapport rapport : rapports) {
            XWPFParagraph para = document.createParagraph();
            run = para.createRun();
            run.setText("ID: " + rapport.getId());
            run.addBreak();
            run.setText("Date de Génération: " + rapport.getDateGeneration());
            run.addBreak();
            run.setText("Contenu: " + rapport.getContenu());
            run.addBreak();
            run.setText("-------------------------");
        }

        XWPFParagraph userDetails = document.createParagraph();
        run = userDetails.createRun();
        run.setText("Détails de l'Utilisateur");
        run.setBold(true);
        run.addBreak();
        run.setText("ID: " + user.getId());
        run.addBreak();
        run.setText("Nom d'utilisateur: " + user.getUsername());
        run.addBreak();
        run.setText("Age: " + user.getAge());
        run.addBreak();
        run.setText("Email: " + user.getEmail());

        document.write(byteArrayOutputStream);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
