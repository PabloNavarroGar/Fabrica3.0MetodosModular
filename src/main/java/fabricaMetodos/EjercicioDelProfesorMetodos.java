/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabricaMetodos;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class EjercicioDelProfesorMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String opcion = "", codigoProducto = "";
        do {

            opcion = pedirOpcion(); // Opcion es "salir" o "calcular"

            // Si no es salir, pido el código de producto
            if (!opcion.equalsIgnoreCase("salir")) {
                // Pedir y filtrar código del producto
                codigoProducto = pedirCodigoProducto(); // Código m1,p1,t1,salir
                // Si ćodigo producto no es salir, realizo los cálculos
                if (!codigoProducto.equalsIgnoreCase("salir")) {
                    // Solicitar y filtrar materia prima

                    // Solicitar y filtrar mano de obra
                    // Calcular coste de producción
                    // Calcular precio venta unitario
                    // Calcular unidades hasta llegar al beneficio
                    // Mostrar toda la información
                } else { // Si es salir
                    opcion = "salir";
                }
            }

        } while (opcion.equalsIgnoreCase("calcular"));

    }

    // Métodos para mostrar códigos de productos
    // y filtrarlos hasta que sean correctos
    public static String pedirCodigoProducto() {
        String codigo;
        do {
            codigo = mostrarMenuCodigos();
        } while (!esCodigoProductoValido(codigo));
        return codigo;
    }

    public static boolean esCodigoProductoValido(String codigo) {
//        if(codigo.equalsIgnoreCase("m1")||codigo.equalsIgnoreCase("p1")
//                || codigo.equalsIgnoreCase("t1")){
//            return true;
//        }
//        else{
//            return false;
//        }
        return (codigo.equalsIgnoreCase("m1") || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("t1") || codigo.equalsIgnoreCase("salir"));
    }

    public static String mostrarMenuCodigos() {
        String texto = """
                       Introduce el código del producto:
                        M1 - Matecados
                        T1 - Turrón de chocolate
                        P1 - Polvorones
                        T2 - Turron Clasico
                        P1 - Mazapanes
                        Salir- Sales del progama
                       """;
        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;
    }

    // Métodos para mostrar opciones generales del programa
    // y filtrarlas hasta que sean correctas
    public static boolean esOpcionMenuInicialValida(String opcion) {
//        if (opcion.equalsIgnoreCase("salir") || opcion.equalsIgnoreCase("calcular")){
//            return true;
//        }
//        else{
//            return false;
//        }
        return opcion.equalsIgnoreCase("salir") || opcion.equalsIgnoreCase("calcular");
    }

    public static String mostrarMenu() {
        String texto = """
                        Escribe calcular para calcular
                        Escribe salir para terminar
                       """;
        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;
    }

    public static String pedirOpcion() {
        //Todo metodo tiene que ir con parametros y con el return
        String opcion;
        do {
            opcion = mostrarMenu();
        } while (!esOpcionMenuInicialValida(opcion));
        return opcion;
    }

}
