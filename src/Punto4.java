import java.util.ArrayList;
import java.util.Scanner;

public class Punto4 {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> serieFibo = new ArrayList<Integer>();
    String opc = "";

    public void pricipal() {
        this.serieFibo.clear();
        this.serieFibo.add(0);
        this.serieFibo.add(1);
        this.serieFibonacci();
        this.calculosFibonacci();
        sc.close();
    }

    private void serieFibonacci() {

        System.out.println("Primeros numeros de la serie de Fibonacci");
        try {
            do {
                this.serieFibo.add(sumaFibonacci());
                System.out.println(this.serieFibo);
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

    private int sumaFibonacci() {
        int ultimoNum = this.serieFibo.get(this.serieFibo.size() - 1);
        int penultimoNum = this.serieFibo.get(this.serieFibo.size() - 2);
        return ultimoNum + penultimoNum;
    }

    private void calculosFibonacci() {
        int contadorPares = 1;
        int contadorImpares = 0;
        int sumatoriaPares = 0;
        int sumatoriaImpares = 0;
        int contadorTotal = 0;
        int sumatoriaTotal = 0;
        int promedio = 0;
        int contadorNumMayores = 0;

        for (int i = 1; i < this.serieFibo.size(); i++) {
            if (this.serieFibo.get(i) % 2 == 0) {
                sumatoriaPares += this.serieFibo.get(i);
                contadorPares++;
            } else {
                sumatoriaImpares += this.serieFibo.get(i);
                contadorImpares++;
            }
        }

        System.out.println("La suma de los numeros pares es: " + sumatoriaPares);
        System.out.println("La cantidad de numeros impares es: " + contadorImpares);

        contadorTotal = contadorPares + contadorImpares;
        sumatoriaTotal = sumatoriaPares + sumatoriaImpares;
        promedio = sumatoriaTotal / contadorTotal;

        System.out.println("El promedio de los numeros generados es: " + promedio);

        for (int i = 0; i < this.serieFibo.size(); i++) {
            if (this.serieFibo.get(i) > promedio) {
                contadorNumMayores++;
            }
        }

        System.out.println("La cantidad de numeros mayores al promedio es: " + contadorNumMayores);
    }
}