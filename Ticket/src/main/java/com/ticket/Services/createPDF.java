package com.ticket.Services;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.ticket.Model.Bilet;

public class createPDF {

	Bilet bilet;

	public createPDF(Bilet bilet) {
		this.bilet = bilet;
	}

	// funkcja tworząca plik pdf
	public void run() {
		final String FILE = "C:/Users/Tasaczek/Desktop/Bilet_" + bilet.getMiejsce() + ".pdf";
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addContent(Document document) throws DocumentException {
			try {
				//dla polskich znakow
				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1250,BaseFont.EMBEDDED);
				Font pl = new Font(bf,12);
				Font redFont = new Font(bf,12,Font.BOLD,BaseColor.RED);
				Font header = new Font(bf,18,Font.BOLD);
				Font smallBold = new Font(bf,12,Font.BOLD);
				
				Paragraph preface = new Paragraph();

				addEmptyLine(preface, 1);
				preface.add(new Paragraph("Bilet", header));

				addEmptyLine(preface, 1);
				preface.add(new Paragraph("Rezerwacji dokonano: " + new Date(), smallBold));

				addEmptyLine(preface, 1);
				preface.add(new Paragraph("Bilet należy okazać w kinie w celu potwierdzenia rezerwacji miejsca.\n"
						+ "Rezerwację należy potwierdzić 15 min przed rozpoczęciem seansu.",pl));

				addEmptyLine(preface, 1);
				createList(preface, bilet);
				
				addEmptyLine(preface, 1);
				preface.add(new Paragraph(
						"Kino nie ponosi odpowiedzialności za przybycie po czasie i anulację rezerwacji na dane miejsce.",
						redFont));
				
				addEmptyLine(preface, 1);

				document.add(preface);	
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

	private void createList(Paragraph p, Bilet b) {
		try {
			//dla polskich znakow
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1250,BaseFont.EMBEDDED);
			Font f = new Font(bf);

		List list = new List(false, false, 10);
		list.add(new ListItem("Imie i Nazwisko: " + bilet.getImie() + " " + bilet.getNazwisko(),f));
		list.add(new ListItem("Tytul filmu: " + bilet.getFilm().getTytul(),f));
		list.add(new ListItem("Wersja: " + bilet.getFilm().getWersja().getNazwa(),f));
		list.add(new ListItem("Gatunek: " + bilet.getFilm().getGatunek().getNazwa(),f));
		list.add(new ListItem("Rezyser: " + bilet.getFilm().getRezyser().getImie() + " "
				+ bilet.getFilm().getRezyser().getNazwisko(),f));
		list.add(new ListItem(
				"Termin: " + bilet.getFilm().getTermin().getDzien() + " " + bilet.getFilm().getTermin().getGodzina(),f));
		list.add(new ListItem("Rodzaj biletu: " + bilet.getRodzaj().getNazwa(),f));
		list.add(new ListItem("Cena: " + bilet.getRodzaj().getCena() + " pln",f));
		list.add(new ListItem("Miejsce: " + bilet.getMiejsce(),f));
		p.add(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
