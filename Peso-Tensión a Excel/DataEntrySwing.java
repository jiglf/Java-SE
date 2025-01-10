package com.example;

import javax.swing.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DataEntrySwing extends JFrame {

    // Creo los componentes para el peso
    private JTextField tWeight, tIMC, tFat, WResult;
    private JButton bCalculateWeight;

    // Creo los componentes para la tensión
    private JTextField tSystolic, tDiastolic, PResult;
    private JButton bCalculatePressure;

    // Creo el boton para exportar los datos
    private JButton bExport;

    //creo valores constantes que usare despues para las formulas con mis datos
    final double HEIGHT = 1.73; //establezco constante a mi altura
    final int AGE = 41; //establezco constante mi edad para la formula de Deurenberg
    final int MAN = 1; //establezco constante para el sexo hombre para la formula de Deurenberg

   
    public DataEntrySwing() {
        // ventana principal
        setTitle("Gestión de Datos");
        setSize(600, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);//para que no se pueda modificar el tamaño de la ventana

        

        // estructuro los componentes para el peso
        JLabel lblWeight = new JLabel("Introduce Peso");
        lblWeight.setBounds(100,60,100,25);
        add(lblWeight);

        tWeight = new JTextField();
        tWeight.setBounds(205,60,56,25);
        add(tWeight);

        JLabel lblIMC = new JLabel("IMC");
        lblIMC.setBounds(226,100,100,25);
        add(lblIMC);

        tIMC = new JTextField();
        tIMC.setBounds(280,100,56,25);
        add(tIMC);

        JLabel lblFat = new JLabel("% grasa");
        lblFat.setBounds(218,140,100,25);
        add(lblFat);

        tFat = new JTextField();
        tFat.setBounds(280,140,56,25);
        add(tFat);

        bCalculateWeight = new JButton("Calcular");
        bCalculateWeight.setBounds(100,115,82,39);
        add(bCalculateWeight);

        JLabel lblWResult = new JLabel("Valoración");
        lblWResult.setBounds(100,190,100,25);
        add(lblWResult);

        WResult = new JTextField();
        WResult.setBounds(197,190,142,25);
        add(WResult);


        // estructuro los componentes para la tension
        JLabel lblSystolic = new JLabel("Presión arterial sistólica");
        lblSystolic.setBounds(115,250,150,25);
        add(lblSystolic);

        tSystolic = new JTextField();
        tSystolic.setBounds(280,250,56,25);
        add(tSystolic);

        JLabel lblDiastolic = new JLabel("Presión arterial diastólica");
        lblDiastolic.setBounds(115,290,150,25);
        add(lblDiastolic);

        tDiastolic = new JTextField();
        tDiastolic.setBounds(280,290,56,25);
        add(tDiastolic);

        bCalculatePressure = new JButton("Calcular");
        bCalculatePressure.setBounds(100,340,82,39);
        add(bCalculatePressure);

        JLabel lblPResult = new JLabel("Valoración");
        lblPResult.setBounds(100,420,100,25);
        add(lblPResult);

        PResult = new JTextField();
        PResult.setBounds(203,420,142,25);
        add(PResult);

        // boton para exportar datos a excel, peso y valores de la tension
        bExport = new JButton("Exportar datos a Excel");
        bExport.setBounds(361,200,210,51);
        add(bExport);

        // etiqueta personalizada
        JLabel lblJIF = new JLabel("JIF");
        lblJIF.setBounds(550,450,150,25);
        add(lblJIF);

        // Hacer visible la ventana
        setVisible(true);
        
        // Acción de botones de calculo
        bCalculateWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWeight();
            }
        });

        bCalculatePressure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePressure();
            }
        });

        // Accion de los botones para exportar datos a excel
        bExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportData();
            }
        });
    }


    
    public static void main(String[] args) {
        new DataEntrySwing();
    }

    // metodos para el calculo del peso y la tensión
    private void calculateWeight() {
        try {
            String valoracion; // variable para almacenar el valor de la valoración del IMC
            double weight = Double.parseDouble(tWeight.getText());
            
            double imc = weight / (Math.pow(HEIGHT,2)); 
            tIMC.setText(String.format("%.2f", imc)); // formato de salida del IMC con 2 decimales

            double fatPercentage = (1.2 * imc) + (0.23 * AGE) - (10.8 * MAN) - 5.4; 
            //para el calculo de la grasa, uso la formula de Deurenberg
            //%grasa = 1,2 *imc + 0.23 * edad - 10,8 * (1 para hombres y 0 para mujeres) - 5,4

            tFat.setText(String.format("%.2f", fatPercentage)); // formato de salida

            
            // tabla de IMC
            if (imc < 18.4) {
                valoracion = "Insuficiencia ponderal";
            } else if (imc < 24.9) {
                valoracion = "Normal";  
            } else if (imc < 29.9) {
                valoracion = "Sobrepeso";   
            } else if (imc < 34.9) {
                valoracion = "Obesidad tipo I";      
            } else if (imc < 39.9) {
                valoracion = "Obesidad tipo II";          
            } else {
                valoracion = "Obesidad tipo III";
            }

            WResult.setText(valoracion); // muestro la valoracion según el dato del IMC

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce un peso válido.");
        }
    }

    private void calculatePressure() {
        try {
            int systolic = Integer.parseInt(tSystolic.getText());
            int diastolic = Integer.parseInt(tDiastolic.getText());

            // uso valores de la tensión para la edad de 40 a 49 años
            if (systolic > 15 || diastolic > 9) {
                PResult.setText("Hipertensión");
            } else if (systolic < 11 || diastolic < 7) {
                PResult.setText("Hipotensión");
            } else {
                PResult.setText("Normal");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce valores válidos para la presión.");
        }
    }


    // Métodos para exportar datos a Excel
    private void exportData() {
        // Abro el archivo, si no existe crea un nuevo libro de trabajo
        File file = new File("Datos.xlsx");
        try (FileInputStream fileExist = file.exists() ? new FileInputStream(file) : null;
            XSSFWorkbook workbook = fileExist != null ? new XSSFWorkbook(fileExist) : new XSSFWorkbook()) {
            
            // Se busca la hoja DATOS
            Sheet dateSheet = workbook.getSheet("DATOS");
            //sino existe la hoja datos se crea y creo las cabeceras de cada columna
            if (dateSheet == null) {
                dateSheet = workbook.createSheet("DATOS");
                //las cabeceras van en la primera fila y crea las cabeceras 
                Row headerRow = dateSheet.createRow(0);
                headerRow.createCell(0).setCellValue("Fecha");
                headerRow.createCell(1).setCellValue("Peso");
                headerRow.createCell(2).setCellValue("Presión Sistólica");
                headerRow.createCell(3).setCellValue("Presión Diastólica");
            }
            
            // Establecer la fecha actual
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            // añade los datos en la siguiente fila introducida
            Row dataRow = dateSheet.createRow(dateSheet.getPhysicalNumberOfRows()); // obtiene el numero de filas creadas previamente
            //escribe cada valor en su columna correspondiente
            dataRow.createCell(0).setCellValue(currentDate);
            dataRow.createCell(1).setCellValue(Double.parseDouble(tWeight.getText()));
            dataRow.createCell(2).setCellValue(Integer.parseInt(tSystolic.getText()));
            dataRow.createCell(3).setCellValue(Integer.parseInt(tDiastolic.getText()));

            // de esta forma aseguro que los datos no se sobreescriben y se guardan a continuación de los ya introducidos

            // guardo el excel confirmando la exportacion
            try (FileOutputStream fileOut = new FileOutputStream("Datos.xlsx")) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(this, "Datos exportados a Excel exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al exportar los datos.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer o crear el archivo de Excel.");
        }
    }

}