package excelReader;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * easyExcel使用示例
 * 具体见官方demo
 * 还有@ExcelProperty CellData等
 * @author Yang
 */

public class EasyExcelDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelDemo.class);

    public static void main(String[] args) {
        InputStream input = EasyExcelDemo.class.getResourceAsStream("demo.xlsx");
        readExcel(input);
    }

    public static void readExcel(InputStream input) {
        ExcelReaderBuilder readerBuilder = EasyExcel.read(input, DemoData.class, new ReadListener());
//        第一张sheet sheetNo 0
        readerBuilder.sheet(1).doRead();

//        EasyExcel.readSheet();
    }
}

class ReadListener extends AnalysisEventListener<DemoData> {

    private static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<>();


    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        list.add(demoData);
        if (list.size() > BATCH_COUNT) {
            System.out.println(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        System.out.println("已经读完");
    }
}
