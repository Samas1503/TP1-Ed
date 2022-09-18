import java.util.Random;
import java.util.Scanner;

public class Punto1 {
    Scanner sr = new Scanner(System.in);

    public void principal() {
        int dimesion;
        try {
            System.out.print("Ingrese un numero para el tamaño para los arreglos  : ");
            dimesion = sr.nextInt();
            int[] arreglo1 = new int[dimesion];
            int[] arreglo2 = new int[dimesion];
            int[] arreglo3 = new int[dimesion];
            int media; // guarda valor de la media del arreglo3
            System.out.println("Desea cargar los datos manualmente? [S/N] : ");
            String respuesta = sr.next();
            if (respuesta.equals("S") || respuesta.equals("s")) {
                arreglo1 = leerArreglo(arreglo1, true);// si es verdadero carga num deficientes
                arreglo2 = leerArreglo(arreglo2, false); // si es falso carga num compuestos
            } else {
                arreglo1 = generaRandom(arreglo1, true);// si se manda true como arg se genera num defiecientes
                arreglo2 = generaRandom(arreglo2, false);// si se manda falso como arg se generan num compuestos
            }
            arreglo3 = leerDiferencia(arreglo1, arreglo2);
            media = calcularMedia(arreglo3);
            mostrarArreglos(arreglo1, media, true); // si se manda true com arg se muestran los menores a la media
            mostrarArreglos(arreglo2, media, false); // si se manda flase como arg se muestras los mayores a la media

        } catch (Exception e) {
            System.out.println("ERROR DE INGRESO!" + e);
        }

    }

    private int[] leerArreglo(int[] arreglo, boolean carga) {
        System.out.println(carga ? "Cargando numeros deficientes..." : "Cargando numeros compuestos...");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el elemento " + i + 1 + " del arreglo");
            int num = sr.nextInt();
            if (carga == true ? validarDeficiente(num) : detCompuestos(num)) { // si carga verdadero se llama a la
                                                                               // funcion validarDeficiente y si no se
                                                                               // llama a la funcion detCompuestos
                arreglo[i] = num;
            } else {
                System.out.println(carga == true ? "El numero no es deficiente, intente nuevamente"
                        : "El numero no es compuesto intente nuevamente");
                i--;
            }
        }
        return arreglo;
    }

    private boolean validarDeficiente(int num) {
        int divisor = 1;
        int acum = 0;
        boolean deficiente = false;
        while (num > 0)
            if (num % divisor == 0)
                acum = acum + divisor;
            else
                divisor = divisor + 1;
        if (acum < num)
            deficiente = true;
        return deficiente;
    }

    private int contarDivisores(int numero) {
        int divisores = 0;
        for (int k = 1; k <= numero; k++)
            if (numero % k == 0)
                divisores++;
        return divisores;
    }

    private boolean detCompuestos(int numero) {
        if (contarDivisores(numero) != 2)
            return true; // numero compuesto
        else
            return false; // numero primo
    }

    private int[] leerDiferencia(int[] arreglo1, int[] arreglo2) {
        int[] arreglo3 = new int[arreglo1.length];
        for (int i = 0; i < arreglo1.length; i++) // cualquier arreglo tiene la misma dim
            arreglo3[i] = arreglo1[i] - arreglo2[i];
        return arreglo3;
    }

    private int calcularMedia(int[] arreglo) {
        int media = 0;
        for (int i = 0; i < arreglo.length; i++)
            media += arreglo[i];
        return media / arreglo.length;
    }

    // si el valor de tipo es true se muestran los valores del arreglo de num
    // deficientes que cumplen la condicion
    // sino se muestran los valores del arreglo de num complejos que cumplen la
    // condicion
    private void mostrarArreglos(int[] arreglo, int media, boolean tipo) {
        System.out.println(tipo ? "Los valores del arreglo de numeros deficientes menores a la media son : "
                : "Los valores del arreglo de numeros compuestos mayores a la media son: ");
        for (int i = 0; i < arreglo.length; i++)
            if (tipo ? (arreglo[i] < media) : (arreglo[i] > media))
                System.out.println(arreglo[i] + " ");
    }

    private int[] generaRandom(int[] arreglo, boolean carga) {
        Random ran = new Random();
        System.out.println(carga ? "Generando numeros deficientes..." : "Generenado numeros compuestos...");
        for (int i = 0; i < arreglo.length; i++) {
            int num = ran.nextInt();
            if (carga ? validarDeficiente(num) : detCompuestos(num))// si carga verdadero se llama a la funcion
                                                                    // validarDeficiente y si no se llama a la
                                                                    // funcion detCompuestos
                arreglo[i] = num;
            else
                i--;
        }
        return arreglo;
    }

}