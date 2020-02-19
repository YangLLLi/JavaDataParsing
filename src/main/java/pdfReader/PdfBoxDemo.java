package pdfReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * PDFBox 使用示例
 * @author Yang
 */
public class PdfBoxDemo {
    public static void main(String[] args) {
        InputStream inputStream = PdfBoxDemo.class.getResourceAsStream("test.pdf");
        URL resource = PdfBoxDemo.class.getResource("test.pdf");
        try {
            pdfWriter(resource.getPath());
            pdfReader(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取pdf文件内容
     * @param input
     * @throws IOException
     */
    public static void pdfReader(InputStream input) throws IOException {
        PDDocument pdf = PDDocument.load(input);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(pdf);
        System.out.println(text);
        pdf.close();
    }

    /**
     * 写内容到文件
     * @param path
     * @throws IOException
     */
    public static void pdfWriter(String path) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN,12);
        contentStream.newLineAtOffset(25, 700);
        contentStream.showText("hello");
        contentStream.endText();
        contentStream.close();

        document.save(path);
        document.close();

    }
}
