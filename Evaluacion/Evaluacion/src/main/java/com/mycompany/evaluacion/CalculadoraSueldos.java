/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluacion;


import java.util.Scanner;

public class CalculadoraSueldos {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== CALCULADORA DE SUELDOS ===");
            
            System.out.print("Nombre del trabajador: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Horas trabajadas: ");
            double horas = scanner.nextDouble();
            
            System.out.print("Pago por hora: ");
            double pagoHora = scanner.nextDouble();
            
            System.out.print("Minutos de tardanza: ");
            int minutosTardanza = scanner.nextInt();
            
            double sueldoBruto = horas * pagoHora;
            double descuentoAFP = sueldoBruto * 0.10;
            double descuentoTardanza = sueldoBruto * 0.0005 * minutosTardanza;
            double sueldoNeto = sueldoBruto - descuentoAFP - descuentoTardanza;
            
            System.out.println("\n=== RESULTADOS ===");
            System.out.println("Trabajador: " + nombre);
            System.out.printf("Sueldo Bruto: %.2f%n", sueldoBruto);
            System.out.printf("Descuento AFP (10%%): %.2f%n", descuentoAFP);
            System.out.printf("Descuento Tardanza: %.2f%n", descuentoTardanza);
            System.out.printf("Sueldo Neto: %.2f%n", sueldoNeto);
        }
    }
}