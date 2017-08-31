package com.qm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ReadPdfUtil {
	public static void readFileOfPDF(String pdfName) throws FileNotFoundException {
        File file = new File(pdfName);// 创建一个文件对象
        FileInputStream infile = null;
        try {
            infile = new FileInputStream(pdfName);// 创建一个文件输入流
            // 新建一个PDF解析器对象
            PDFParser parser = new PDFParser(infile);
            // 对PDF文件进行解析
            parser.parse();
            // 获取解析后得到的PDF文档对象
            PDDocument pdfdocument = parser.getPDDocument();
            // 新建一个PDF文本剥离器
            PDFTextStripper stripper = new PDFTextStripper();
            // 从PDF文档对象中剥离文本
            String context = stripper.getText(pdfdocument);
            System.out.println("PDF文件" + file.getAbsolutePath() + "的文本内容如下：");
            System.out.println(context);

        } catch (Exception e) {
            System.out.println("读取PDF文件" + file.getAbsolutePath() + "失败！"
                    + e.getMessage());
        } finally {
            if (infile != null) {
                try {
                    infile.close();
                } catch (IOException e1) {
                }
            }
        }
    }
	
	 // 读取指定的PDF文件的内容，其中：pdfName表示要读取的PDF文件的路径
    public static void readPDF(String pdfName) throws FileNotFoundException {
        PDDocument document = null;
        try {
            document = PDDocument.load(pdfName);

            // 获取页码
            int pages = document.getNumberOfPages();
            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            String content = stripper.getText(document);
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
