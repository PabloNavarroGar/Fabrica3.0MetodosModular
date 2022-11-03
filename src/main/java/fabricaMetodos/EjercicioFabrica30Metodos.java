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
public class EjercicioFabrica30Metodos {

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
                    soliticarMateriaPrima();

                    // Solicitar y filtrar mano de obra
                    solicitarManoDeObra();
                    // Calcular coste de producción
                    costeProduccion(soliticarMateriaPrima(),solicitarManoDeObra());
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
        return (codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("m2")
                || codigo.equalsIgnoreCase("t1")
                || codigo.equalsIgnoreCase("t2")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("salir"));
    }

    public static String mostrarMenuCodigos() {
        String texto = """
                       Introduce el código del producto:
                        M1 - Matecados
                        T1 - Turrón de chocolate
                        M2 - Polvorones
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

    //Solicitar materia prima
    public static double soliticarMateriaPrima() {

        double costeMateriaPrima;

        //Bucle que se le introduce la materia prima
        do {
            String costeString = JOptionPane.showInputDialog("Introduce el "
                    + "coste de la materia prima(entre 0.1€ y 1€)");
            //Parse del string a double
            costeMateriaPrima = Double.parseDouble(costeString);
            //Salida de datos
            JOptionPane.showMessageDialog(null, "El coste de la"
                    + " materia es de " + costeMateriaPrima);
            //! y lo que este entre los parentesis  significa
            //que todo lo que no se haga en el parentesis , se repetira

            //lee el metodo de filtrado, pasa al metodo de filtrado para comprobarlo
        } while (!filtradoMateriaPrima(costeMateriaPrima));
        return costeMateriaPrima;
    }

    public static boolean filtradoMateriaPrima(double costeMateria) {

        return (costeMateria >= 0.1 && costeMateria <= 1.0);
    }

    public static double solicitarManoDeObra() {

        
        double costeManoDeObra;
        do {
            String costeObraString = JOptionPane.showInputDialog("Introduce el "
                    + "coste de la mano de obra(entre 0.5€ y 0.9€)");
            //Parse del string a double
            costeManoDeObra = Double.parseDouble(costeObraString);
            //Salida de datos
            JOptionPane.showMessageDialog(null, "El coste de la"
                    + " mano de obra " + costeManoDeObra);
            //! y lo que este entre los parentesis  significa
            //que todo lo que no se haga segun lo que le introduzca
            //en el parentesis , se repetira
            //Condicion del bucle
        } while (!filtradoManoDeObra(costeManoDeObra));
        return costeManoDeObra;
    }
    
    
    
    public static boolean filtradoManoDeObra(double costeMano){
        
        //El dato del return  tiene que ir con el mismo nombre que se pone 
        //en el parametro
        
        return  (costeMano >= 0.5 && costeMano<= 0.9);
    }
    
    public static double costeProduccion(double costeMateria, double costeMano){
        
        double costeProduccionUnidad;
        costeProduccionUnidad = costeMateria+costeMano;
        
        JOptionPane.showMessageDialog(null, " El coste de "
                + "produccion es de :" +costeProduccionUnidad);
        return costeProduccionUnidad;
    }
    
    
    
}
