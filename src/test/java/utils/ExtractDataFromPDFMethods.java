package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ExtractDataFromPDFMethods {

	public static String ReadPDF1(String File_Location) {
		String data = null;
		try (PDDocument document = PDDocument.load(new File(File_Location))) {
			document.getClass();

			if (!document.isEncrypted()) {
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.setSortByPosition(true);

				PDFTextStripper tStripper = new PDFTextStripper();
				data = tStripper.getText(document);

//	            String lines[] = pdfFileInText.split("\\n");
//	            for (String line : lines) {
//	                System.out.println(line);
//	            }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String ReadPDF(String loc) throws IOException {
		String data = null;
		try {
			// Create PdfReader instance.
			PdfReader pdfReader = new PdfReader(loc);
			// Get the number of pages in pdf.
			int pages = pdfReader.getNumberOfPages();
			// Iterate the pdf through pages.
			for (int i = 1; i <= pages; i++) {
				// Extract the page content using PdfTextExtractor.
				data = PdfTextExtractor.getTextFromPage(pdfReader, i);
			}
			// Close the PdfReader.
			pdfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String readPdfContent(String url) throws IOException {
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		PDFTextStripper obj = new PDFTextStripper();
//		obj.setSortByPosition(true);
		return obj.getText(doc);
	}
}
