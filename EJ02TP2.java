package tp1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class CA {

	public static void main(String[] args) {
		
		// Principal
		
		Scanner teclado = new Scanner(System.in);
		ArrayList  <Integer> lista = new ArrayList  <Integer>() ;
		ArrayList  <Integer> listaMenores = new ArrayList  <Integer>() ;
		ArrayList  <Integer> listaMayores = new ArrayList  <Integer>() ;
		
		try {
		System.out.println("ingrese el tamaño de la lista");
		int a = teclado.nextInt();
		for (int i = 0; i<a;i++) {
			
			System.out.println("ingrese un numero primo");
			int numero = teclado.nextInt();
			int v = verificarPrimos(numero);
			lista.add(v);
			
		}
		// lista original 
		System.out.println("lista generada");
		for (int elemento: lista) {
			System.out.println(elemento);
		}
		
		System.out.print("ingresar x : ");
		int x =  teclado.nextInt();
		System.out.println("Valores menores a: " + x);
		for (int elementos: lista) {
			if (elementos<x) {
				listaMenores.add(elementos);
				System.out.println(elementos);
			}
		}
		System.out.println("lista invertida");
		Collections.reverse(listaMenores);
		for(int e:listaMenores) {
			System.out.println(e );
		}

		
		System.out.print("ingresar Y : ");
		int y =  teclado.nextInt();
		System.out.println("Valores mayores a: " + y);
		for (int elementos: lista) {
			if (elementos>y) {
				listaMayores.add(elementos);
				System.out.println(elementos);
			}
		
		}
		
		
		System.out.println("lista invertida");
		Collections.reverse(listaMayores);
		for(int e:listaMayores) {
			System.out.println(e );
		}
		}catch (java.util.InputMismatchException e) {
			System.out.println("error en la entrada de datos " + e);
		}
	
	}
		
		
		
	private static int verificarPrimos (int numero) {
		var ok = false; 
	       do {
	    	Scanner obtenerNumero = new Scanner(System.in);
	    	
	        int contador,I;
	        contador = 0;
	 
	        for(I = 1; I <= numero; I++)
	        {
	            if((numero % I) == 0)
	            {
	                contador++;
	            }
	        }
	 
	        if(contador <= 2 && numero != 2)
	        {
	            System.out.println(numero + "El numero es primo");
	            ok = true;
	           
	        }else{
	            System.out.println(numero + "El numero no es primo");
	            System.out.print("Ingresa un numero: ");
		        numero = obtenerNumero.nextInt();
	        }
	       } while(!ok);
	       return numero;
	}
	
	













}
