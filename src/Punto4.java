import java.util.Scanner;
import java.util.ArrayList;


public class Punto4 {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> arreglo = new ArrayList<Integer>();
    String opc = "";

    public void principal() {
        arreglo.clear();
        arreglo.add(0);
        arreglo.add(1);
        serieFibonacci();
        calculosFibonacci();
        sc.close();
    }

    public void serieFibonacci() {

        System.out.println("Primeros numeros de la serie de Fibonacci");
        try {
            do {
                arreglo.add(sumaFibonacci());
                System.out.println(arreglo);
                System.out.println("Desea continuar? (S/N)");
                opc = sc.nextLine();
            } while (opc.equalsIgnoreCase("s"));
            if (!opc.equalsIgnoreCase("n")) {
                System.out.println("Se ingreso una opcion incorrecta");
            }
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos: " + e);
        }
    }

    public Integer sumaFibonacci() {
        Integer ultimoNum = arreglo.get(arreglo.size()-1);
        Integer penultimoNum = arreglo.get(arreglo.size()-2);
        Integer sumatoria = ultimoNum + penultimoNum;
        return sumatoria;
    }

    public void calculosFibonacci() {
        Integer contadorPares = 1;
        Integer contadorImpares = 0;
        Integer sumatoriaPares = 0;
        Integer sumatoriaImpares = 0;
        Integer contadorTotal = 0;
        Integer sumatoriaTotal = 0;
        Integer promedio = 0;
        Integer contadorNumMayores = 0;

        for (int i = 1; i < arreglo.size(); i++) {
            if (arreglo.get(i) % 2 == 0) {
                sumatoriaPares += arreglo.get(i);
                contadorPares ++;
            } else {
                sumatoriaImpares += arreglo.get(i);
                contadorImpares ++;
            }
        }

        System.out.println("La suma de los numeros pares es: " + sumatoriaPares);
        System.out.println("La cantidad de numeros impares es: " + contadorImpares);

        contadorTotal = contadorPares + contadorImpares;
        sumatoriaTotal = sumatoriaPares + sumatoriaImpares;
        promedio = sumatoriaTotal / contadorTotal;

        System.out.println("El promedio de los numeros generados es: " + promedio);

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i) > promedio) {
                contadorNumMayores ++;
            }
        }

        System.out.println("La cantidad de numeros mayores al promedio es: " + contadorNumMayores);
    }
}