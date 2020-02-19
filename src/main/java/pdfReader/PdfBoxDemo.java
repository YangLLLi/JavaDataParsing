package pdfReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

/**
 * PDFBox 使用示例
 * @author Yang
 */
public class PdfBoxDemo {
    public static void main(String[] args) {
        InputStream inputStream = PdfBoxDemo.class.getResourceAsStream("test.pdf");
        try {
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
}
