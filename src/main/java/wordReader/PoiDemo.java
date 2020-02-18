package wordReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * POI使用示例
 * @author Yang
 */
public class PoiDemo {
    public static void main(String[] args) {
        InputStream input = PoiDemo.class.getResourceAsStream("test.docx");
        try {
            readDemo(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得文档中所有字段
     * @param input
     * @throws IOException
     */
    public static void readDemo(InputStream input) throws IOException {
        XWPFDocument docx = new XWPFDocument(input);
        List<XWPFParagraph> paragraphs = docx.getParagraphs();
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph paragraph : paragraphs) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                sb.append(run.text());
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    public static void writeDemo(String path) throws InvalidFormatException, IOException {

    }
}

