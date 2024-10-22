package com.example.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CodigoQR {

    public static void generateQRCodeImage(String text, int width, int height, String filePath) 
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();//creo un objeto qr writer
        
        //bitmatrix para pasar a bits los elementos añadidos al qr writer
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        //guarda el bitMatrix en imagen
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            String qrCodeText = "www.linkedin.com/in/jiglf"; //el texto que le quieres mandar al qr, en mi caso enlace a mi linkedin
            int width = 300;
            int height = 300;
            String filePath = "C:\\Users\\juani\\workspace\\Java Basic\\qr\\QRJuanLinkedin.png";//donde se guarda el qr y el nombre que le quieras dar al codigo creado

            generateQRCodeImage(qrCodeText, width, height, filePath);//genera el qr con la informacion proporcionada

            System.out.println("Código QR generado exitosamente en: " + filePath);
        } catch (WriterException | IOException e) {
            System.out.println("Ocurrió un error al generar el código QR: " + e.getMessage());
        }
    }
}