package com.espe.p1gib.vasquezlady;
import org.json.simple.JSONObject;//Librería para trabajar con archivos JSON
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VasquezRegistroNotas {
    private float VasquezNota1, VasquezNota2, VasquezNota3, VasquezProm;
    private static final String NOMBRE_ARCHIVO = "notas.json"; // Nombre de archivo

    public void VasquezMostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int VasquezOpcion;
       // do {
            System.out.println("REGISTRO DE NOTAS");
            System.out.print("Seleccione una opción");
            System.out.println("1. Ingreso de notas");
            System.out.println("2. Calculo de promedio");
            System.out.println("3. Salir");
            VasquezOpcion = scanner.nextInt();
            switch (VasquezOpcion) {
                case 1:
                    VasquezIngresarDatos();
                    VasquezMostrarMenu();
                    break;
                case 2:
                    VasquezMostrarPromedio();
                    VasquezMostrarMenu();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa.");
                    break;
                default: System.out.println("Error, ingrese nuevamente.");
                VasquezMostrarMenu();
                    break;
            }
      //  } while (VasquezOpcion != 3);
        scanner.close();
    }

    private void VasquezIngresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota 1 (0-20): ");
        VasquezNota1 = scanner.nextFloat();
        while (VasquezNota1 < 0 || VasquezNota1 > 20) {
            System.out.print("Rango incorrecto, ingrese nuevamente: ");
            VasquezNota1 = scanner.nextFloat();
        }
        
        System.out.print("Ingrese la nota 2 (0-20): ");
        VasquezNota2 = scanner.nextFloat();
        while (VasquezNota2 < 0 || VasquezNota2 > 20) {
            System.out.print("Rango incorrecto, ingrese nuevamente: ");
            VasquezNota2 = scanner.nextFloat();
        }
        
        System.out.print("Ingrese la nota 3 (0-20): ");
        VasquezNota3 = scanner.nextFloat();
        while (VasquezNota3 < 0 || VasquezNota3 > 20) {
            System.out.print("Rango incorrecto, ingrese nuevamente: ");
            VasquezNota3 = scanner.nextFloat();
        }
        
        VasquezProm = (VasquezNota1 + VasquezNota2 + VasquezNota3) / 3;
        VasquezGuardarDatos(VasquezNota1, VasquezNota2, VasquezNota3, VasquezProm);
    }

    private void VasquezMostrarPromedio() {
        System.out.println("El promedio es: " + VasquezProm);
        System.out.println(VasquezProm < 14 ? "Reprobado" : "Aprobado");
    }

    private void VasquezGuardarDatos(float VasquezNota1, float VasquezNota2, float VasquezNota3, float VasquezProm) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nota1", VasquezNota1);
        jsonObject.put("nota2", VasquezNota2);
        jsonObject.put("nota3", VasquezNota3);
        jsonObject.put("promedio", VasquezProm);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.write(jsonObject.toJSONString()); // Usar toJSONString() para escribir el JSON4
            System.out.println("Datos guardados correctamente en archivo JSON: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON: " + e.getMessage());
        }
    }


}
