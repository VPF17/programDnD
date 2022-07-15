import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class health {
	public static void main(String[] args) throws Exception{
		InputStream stream = System.in;
		Scanner scanner = new Scanner(stream);
		String input = scanner.next();
		String[] inputDiv=input.split(",");
		if (inputDiv[0].equals("curar")) {
			curar(inputDiv[1],Integer.valueOf(inputDiv[2]));
		}
		scanner.close();
	}
	public static void curar(String nombre, int cantidad) throws Exception{
		FileInputStream excel_file= new FileInputStream(new File("C:\\Users\\victo\\Desktop\\D&D\\Da�o personajes.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(excel_file);
		XSSFSheet sh= wb.getSheet("Hoja1");
		XSSFRow row=sh.getRow(0);
		boolean noencontrado=true;
		for(int i =1;(row!=null)&&noencontrado;i++) {
			XSSFCell personaje=row.getCell(i);
			if(personaje!=null&&personaje.getStringCellValue().equals(nombre)) {
				sanarAcido(4*cantidad,sh.getRow(3).getCell(i),sh.getRow(1).getCell(i));
				noencontrado=false;
			}
		}
		excel_file.close();
		FileOutputStream output_file =new FileOutputStream(new File("C:\\Users\\victo\\Desktop\\D&D\\Da�o personajes.xlsx"));
		wb.write(output_file);
		output_file.close();
	}
	/*
	  ____da�o_____
	 |             |
	 da�os[0]      |
	 |     |       |
da�os2[0]          |
	 | da�os3[0]   |
	 | |           |
	 3*5/72+8*32/72 
	 */
	public static void sanarAcido(int cantidad, XSSFCell cell, XSSFCell salud) {
		String da�o=cell.getStringCellValue();
		String saludString=salud.getStringCellValue();
		String[] saludDiv=saludString.split("/");
		int puntosVida=Integer.valueOf(saludDiv[0]);
		if (!da�o.isEmpty()) {
			String[] da�os=da�o.split("\\+");
			for(int i=0;i<da�os.length;i++) {
				String[] da�os2=da�os[i].split("\\*");
				int puntos=Integer.valueOf(da�os2[0]);
				String[] da�os3=da�os2[1].split("/");
				int puntosActuales=Integer.valueOf(da�os3[0]);
				puntosActuales=puntosActuales+cantidad;
				while(puntosActuales>=72) {
					puntosActuales=puntosActuales-72;
					puntos--;
					puntosVida++;
				}
				if(puntos<=0) {
					da�os[i]="";
				}
				else {
					da�os[i]=puntos+"*"+puntosActuales+"/72";
				}
			}
			da�o=da�os[0];
			for(int i=1;i<da�os.length;i++) {
				da�o=da�o+"+"+da�os[i];
			}
			saludString=puntosVida+"/"+saludDiv[1];
			cell.setCellValue(da�o);
			salud.setCellValue(saludString);
		}
	}
}