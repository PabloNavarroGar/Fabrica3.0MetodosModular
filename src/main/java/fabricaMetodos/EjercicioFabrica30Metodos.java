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
        //variables
        String opcion = "", codigoProducto = "";
        String codigo = "";
        final int PRECIO_BENEFICIO = 2500;
        //Precio fijo delimitado para calcular la unidades que se necesitan para
        //llegar a esa cantidad

        double unidadesParaObtenerBeneficio = 0;
        
        double costeMateria=0;
        double costeMano=0;
        double costeProduccion = 0;
        double costeVentaUnitaria;

        do {

            opcion = pedirOpcion(); // Opcion es "salir" o "calcular"

            // Si no es salir, pido el código de producto
            if (!opcion.equalsIgnoreCase("salir")) {
                // Pedir y filtrar código del producto
                codigoProducto = pedirCodigoProducto(); // Código m1,p1,t1,salir
                // Si ćodigo producto no es salir, realizo los cálculos
                if (!codigoProducto.equalsIgnoreCase("salir")) {
                    switch (codigoProducto) {
                        case "m1","m2","t1","t2","p1":
                            //En esta variable se almacena el valor devuelto por
                            //el método filtra rCosteMateriaPrima que tiene el filtro ya
                            soliticarMateriaPrima();

                            //En esta variable se almacena el valor devuelto por
                            //el método filtrarCosteManoObra
                            solicitarManoDeObra();
                            //En esta variable se almacena el valor devuelto por
                            //el método calcularCosteProduccion

                            costeProduccion(costeMateria,costeMano ,codigo);
                            //En esta variable se almacena el valor devuelto por
                            //el método calcular CosteVentaUnitaria que tiene el metodo y las 2 varibales
                            costeVentaUnitaria = calculoPrecioVenta(costeProduccion, codigo);

                            //En esta variable se almacena el valor devuelto por
                            //el método calcularUnidadesParaObtenerBeneficios
                            unidadesParaObtenerBeneficio
                                    = beneficiosObjetivo(
                                            costeProduccion,
                                            costeVentaUnitaria,
                                            PRECIO_BENEFICIO);
                            break;

                    }

//                    // Solicitar y filtrar materia prima
//                    soliticarMateriaPrima();
//
//                    // Solicitar y filtrar mano de obra
//                    solicitarManoDeObra();
//                    // Calcular coste de producción
//                    costeProduccion(soliticarMateriaPrima(), solicitarManoDeObra(),mostrarMenuCodigos());
//                    // Calcular precio venta unitario
//                    //if(!codigoProducto.equalsIgnoreCase("t1")||codigoProducto.equalsIgnoreCase("t2")){
//                    calculoPrecioVenta( 0,codigo);
//                 
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
       // se devuelve los codigo para que se filtren
        return (codigo.equalsIgnoreCase("m1")
                || codigo.equalsIgnoreCase("m2")
                || codigo.equalsIgnoreCase("t1")
                || codigo.equalsIgnoreCase("t2")
                || codigo.equalsIgnoreCase("p1")
                || codigo.equalsIgnoreCase("salir"));
    }
    //Menu de los codigos
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
    //devolvemos que si la opcion en salir o calcular
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

    public static boolean filtradoManoDeObra(double costeMano) {

        //El dato del return  tiene que ir con el mismo nombre que se pone 
        //en el parametro
        return (costeMano >= 0.5 && costeMano <= 0.9);
    }

    public static double costeProduccion(double costeMateria, double costeMano, String codigo) {

        double costeProduccionUnidad;
        costeProduccionUnidad = costeMateria + costeMano;

        JOptionPane.showMessageDialog(null, "El coste de producción del código " + codigo + " es: "
                + String.format("%.2f", costeProduccionUnidad) + "€");

        return costeProduccionUnidad;
    }

    public static double calculoPrecioVenta(double costeProduccion, String codigo) {
        double precioVenta;
        //Calculo del precio de venta

        final double PORCENTAJE_VENTA_UNITARIA_M1_M2_P1 = 0.5;
        final double PORCENTAJE_VENTA_RESTO_ARTICULOS = 0.65;

        //Mediante este switch hacemos un pequeño filtrado para calcular el
        //coste de venta unitaria dependiendo del codigo de producto
        switch (codigo) {
            case "M1","M2","P1":
                //Formula para calcular el coste de venta unitaria
                precioVenta = costeProduccion + costeProduccion
                        * PORCENTAJE_VENTA_UNITARIA_M1_M2_P1;

                break;

            default:
                //equivalente a otro case
                //ya que ya filtramos la entrada de datos anteriormente

                //Formula para calcular el coste de venta unitaria
                precioVenta = costeProduccion + costeProduccion
                        * PORCENTAJE_VENTA_RESTO_ARTICULOS;

        }

        //Mensaje que muestra el precio de venta unitaria según el código
        //Limitamos los decimales a 2
        JOptionPane.showMessageDialog(null,
                "El coste de venta unitaria del código " + " es: "
                + String.format("%.2f", precioVenta) + "€");

        //Devolvemos el valor que será guardada en una variable en el método
        //mostrarPrograma
        return precioVenta;
    }

    //Este método recibe por parámetros el coste de producción, el coste de 
    //venta unitaria y el precio de beneficio y devuelve un valor tipo entero
    //Calcula el número de unidades necesarias para llegar al beneficio
    //internamente con la fórmula
    private static int beneficiosObjetivo(double costeProduccion, double precioVenta, double precioBeneficio) {

        //Variable temporal para guardar el número de dulces
        //Será guardada en una variable en el método mostrarPrograma
        double unidadesParaBeneficio;

        //Formula para calcular las unidades
        unidadesParaBeneficio = Math.ceil(precioBeneficio
                / (precioVenta - costeProduccion));

        //Mensaje que muestra el numero de unidades necesarias
        JOptionPane.showMessageDialog(null,
                "El numero de unidades para el beneficio son: "
                + (int) unidadesParaBeneficio + " unidades");
        //Hacemos conversiones explícitas de int a double para que nos
        //devuelva valores enteros y no decimales
        return (int) unidadesParaBeneficio;

    }

}
