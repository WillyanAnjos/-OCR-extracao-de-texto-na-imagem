package service;
import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImage {
	public String getImgText(String local) {
		ITesseract instance = new Tesseract();
		instance.setLanguage("por");
		
		try {
			String result = instance.doOCR(new File(local));
			return result;
		} catch (TesseractException e) {
			e.getMessage();
			return "Erro na leitura da imagem";
		}
	}
}
