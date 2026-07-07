package com.mycompany.evaluacion;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionVentas {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Producto> productos = new ArrayList<>();
            
            System.out.println("=== SISTEMA DE GESTIÓN DE VENTAS ===");
            
            while (true) {
                System.out.print("\n¿Desea registrar un producto? (s/n): ");
                String continuar = scanner.nextLine().trim().toLowerCase();
                
                if (continuar.equals("n")) {
                    break;
                }
                
                System.out.print("Nombre del producto: ");
                String nombre = scanner.nextLine();
                
                System.out.print("Precio: ");
                double precio = scanner.nextDouble();
                
                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                productos.add(new Producto(nombre, precio, cantidad));
            }
            
            if (productos.isEmpty()) {
                System.out.println("No se registraron productos.");
                scanner.close();
                return;
            }
            
            // Cálculos
            double totalCompra = 0;
            Producto masCaro = productos.get(0);
            Producto mayorCantidad = productos.get(0);
            
            System.out.println("\n=== REPORTE DE VENTA ===");
            System.out.println("Total de productos registrados: " + productos.size());
            
            for (Producto p : productos) {
                double subtotal = p.getPrecio() * p.getCantidad();
                System.out.printf("%s - Cant: %d - Precio: %.2f - Subtotal: %.2f%n",
                        p.getNombre(), p.getCantidad(), p.getPrecio(), subtotal);
                
                totalCompra += subtotal;
                
                if (p.getPrecio() > masCaro.getPrecio()) masCaro = p;
                if (p.getCantidad() > mayorCantidad.getCantidad()) mayorCantidad = p;
            }
            
            double igv = totalCompra * 0.18;
            double totalPagar = totalCompra + igv;
            
            System.out.printf("%nTotal de la compra: %.2f%n", totalCompra);
            System.out.printf("IGV (18%%): %.2f%n", igv);
            System.out.printf("Total a pagar: %.2f%n", totalPagar);
            System.out.println("Producto más caro: " + masCaro.getNombre() + " ($" + masCaro.getPrecio() + ")");
            System.out.println("Producto con mayor cantidad: " + mayorCantidad.getNombre() +
                    " (" + mayorCantidad.getCantidad() + " unidades)");
        }
    }
}

// Clase auxiliar
class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
}