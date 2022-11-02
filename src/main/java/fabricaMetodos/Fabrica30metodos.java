/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fabricaMetodos;

import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Fabrica30metodos {

    //1º metodo para mostarmuenu inicial
//    2º metodo de leer codigos
//    3º filtrarcodigos                
//    4º leerMateriaPrima
//    5º FiltrarMateriaPrima
//    6º leemanodeobra
//    7º filtrarManoObra
//    8º CosteProduccion
//    9º Calcular Precioventa
//    10º calcular unidadesBeneficio
    public static void main(String[] args) {
        //crear una variable string opcion para guardar el dato
        String opcion;
        opcion = menuInicial();
        /*asigno a la variable opción el valor de retorno de la función menú principal*/
 /**/
        boolean a = calcularYsalirConfirmacion(opcion);
        if (a == true) {
            String s = menuCodigos();
            filtrarCodigos(s);
            double coste =leerMateriaPrima();
            filtarCosteMateriaPrima(coste);
            double costeMano=leerManoDeObra();
            filtrarCosteManoDeObra();
                  
        } else {
            System.out.println(" SALIENDO DE PROGRAMA.");
        }

//        leerMateriaPrima();
//        filtarCosteMateriaPrima();
//        leerManoDeObra();
//        filtrarCosteManoDeObra();
//        costeProduccionDulces();
        //precioVentaM1_M2();
    }

    public static String menuInicial() {
        //declaracion variable que contiene el menu 
        String opcion;

        String menu = """
                        Escriba lo quiere hacer.
                  -----------------------------------------
                       Calcular=="Menu de los Productos"
                       Salir== "Salir del programa"
                  -----------------------------------------
                  
                  
                  
                  """;

        opcion = JOptionPane.showInputDialog(null, menu).toLowerCase();

        return opcion;
    }

    public static boolean calcularYsalirConfirmacion(String opcion) {

        //declarar el string con su nombre y relacionarlo con el menu inicial
        if (opcion.equalsIgnoreCase("calcular")) {

            JOptionPane.showMessageDialog(null, "Estoy dentro del menu de codigos");
            /**/
            return true;

        } else {
        }
        return false;
    }

    public static String menuCodigos() {

        String opcion2;
        String menu2 = """
                                "La Esteponera Turronera"
                    -----------------------------------------------------------------
                    Introduce el Codigo que quieres calcular
                    -----------------------------------------------------------------
                                1.Mantecadosde limon---> M1
                                2.Turron de chocolate--> T1
                                3.Polvorones-----------> M2
                                4.Turron clasico-------> T2
                                5.Mazapanes------------> P1
                                6.Escribar-->"Salir" para terminar programa.
                    """;
        //bucle del menu de los codigos

        opcion2 = JOptionPane.showInputDialog(null, menu2).toLowerCase();
        //while con las condiciones de cada codigo
        filtrarCodigos(opcion2);
        return opcion2;
    }

    //    3º filtrarcodigos
    @SuppressWarnings("empty-statement")
    public static String filtrarCodigos(String input) {

        String opcion3 = input;
        do {

        } while (!(opcion3.equalsIgnoreCase("M1")
                || opcion3.equalsIgnoreCase("T1")
                || opcion3.equalsIgnoreCase("M2")
                || opcion3.equalsIgnoreCase("T2")
                || opcion3.equalsIgnoreCase("P1")
                || opcion3.equalsIgnoreCase("Salir")));

        return opcion3;

    }

    //  leerMateriaPrima
    public static double leerMateriaPrima() {
        double costeMateriaPrima;
        String costeString = JOptionPane.showInputDialog("Introduce el "
                + "coste de la materia prima(entre 0.1€ y 1€)");
        //Parse del string a double
        costeMateriaPrima = Double.parseDouble(costeString);
        //Salida de datos
        JOptionPane.showMessageDialog(null, "El coste de la"
                + " materia es de " + costeMateriaPrima);

        return costeMateriaPrima;
    }
//
    // 5º FiltrarMateriaPrima

    public static double filtarCosteMateriaPrima(double filtradoMateriaPrima) {

       
        do {
            filtradoMateriaPrima = leerMateriaPrima();

        } while (!(filtradoMateriaPrima >= 0.1 && filtradoMateriaPrima <= 1));
        return filtradoMateriaPrima;
    }

    //6º leemanodeobra
    public static double leerManoDeObra() {

        double costeManoDeObra;
        String costeObraString = JOptionPane.showInputDialog("Introduce el "
                + "coste de la mano de obra(entre 0.5€ y 0.9€)");
       //Parse del string a double
        costeManoDeObra = Double.parseDouble(costeObraString);
       //Salida de datos
       JOptionPane.showMessageDialog(null, "El coste de la"
                + " mano de obra " + costeManoDeObra);

        return costeManoDeObra;
    }
   //7ºfiltrado coste mano de obra
    public static double filtrarCosteManoDeObra() {

        double filtradoCosteManoDeObra;

        do {
           filtradoCosteManoDeObra = leerManoDeObra();

        } while (!(filtradoCosteManoDeObra >= 0.5 && filtradoCosteManoDeObra <= 0.9));

        return filtradoCosteManoDeObra;
    }

//    //    8º CosteProduccion
//    public static double costeProduccionDulces() {
//
//        double costeProduccionUnidad;
//        double costeMateriaPrima;
//        double costeManoDeObra;
//
//        costeManoDeObra = leerManoDeObra();
//
//        costeMateriaPrima = leerMateriaPrima();
//
//        costeProduccionUnidad = costeManoDeObra + costeMateriaPrima;
//
//        JOptionPane.showMessageDialog(null, "Nos cuesta fabricar el siguiente dulce " + costeProduccionUnidad);
//
//        return costeProduccionUnidad;
//
//    }
//
//    public static double precioVentaM1_M2_P1(String precioVentaGrupo1) {
//
//        double precioVenta;
//        double costeProduccionUnidad;
//        costeProduccionUnidad = costeProduccionDulces();
//        String opcion3=precioVentaGrupo1;
//        
//        if (!opcion3.equalsIgnoreCase("M1")
//                ||!opcion3.equalsIgnoreCase("M2")
//                ||!opcion3.equalsIgnoreCase("P1"));  {
//        
//          precioVenta = costeProduccionUnidad
//                + (costeProduccionUnidad * 0.5);
//        } 
//                
//
//        JOptionPane.showMessageDialog(null,"El precio de los Mantecados o Polvorones o Mazapanes es de "+ precioVenta);
//        return precioVenta;
//    }
//    
//    
//    
//     public static double precioVentaT1_T2(String precioVentaGrupo2) {
//
//        double precioVenta;
//        double costeProduccionUnidad;
//        costeProduccionUnidad = costeProduccionDulces();
//        String opcion3;
//        opcion3=precioVentaGrupo2;
//        if (!opcion3.equalsIgnoreCase("T1")
//                ||!opcion3.equalsIgnoreCase("T2"));  {
//         
//         
//          precioVenta = costeProduccionUnidad
//                + (costeProduccionUnidad * 0.65);
//        }
//       
//        JOptionPane.showMessageDialog(null,"El precio del turron de Chocolate y Turron clasido es  "+ precioVenta);
//        return precioVenta;
//    }
//     
////     public static double beneficio(){
////           double beneficio;
////           
////         
////          beneficio = precioVenta - costeProduccionUnidad;
////         
////         
//         return beneficio;
//     }
}
