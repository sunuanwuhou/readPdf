package com.qm;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		String baseDir=System.getProperty("user.dir");
		Path basePath =Paths.get(baseDir,"src/com/qm/pdf/百旺测试发票.pdf");
		String filePath = basePath.toString();
		//无顺序
		ReadPdfUtil.readFileOfPDF(filePath);
		//有顺寻
		ReadPdfUtil.readPDF(filePath);
		
	}

}
