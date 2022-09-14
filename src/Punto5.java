import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Models.Libro;

public class Punto5 {
    Scanner sc = new Scanner(System.in);
    private ArrayList<String> titulos = new ArrayList<String>() {
        {
            add("El señor de los Anillos");
            add("Harry Potter");
            add("El Alquimista");
            add("El Codigo da Vinci");
            add("Crepusculo");
            add("Lo que el Viento se Llevo");
            add("Piense y Hagase Rico");
            add("El Diario de Ana Frank");
            add("Los Ojos del Perro Siberiano");
            add("El Jamon del Sanguche");
            add("La Lluvia Sabe Porque");
            add("La Biblia");
            add("Citas del Presidente Mao Tse-Tung");
        }
    };
    private ArrayList<String> autores = new ArrayList<String>() {
        {
            add("John Ronald Reuel Tolkien");
            add("Joanne Rowling");
            add("Paulo Coelho");
            add("Daniel James Brown");
            add("Stephenie Meyer");
            add("Margaret Mitchell");
            add("Napoleon Hill");
            add("Ana Frank");
            add("Antonio Santa Ana");
            add("Graciela Bialet");
            add("María Fernanda Heredia");
            add("Dios");
            add("Mao Tse-Tung");
        }
    };
    private ArrayList<String> editoriales = new ArrayList<String>() {
        {
            add("Ediciones Minotauro");
            add("Planeta y Penguin Random House");
            add("Bloomsbury Salamandra Scholastic");
            add("Alfaguara Little");
            add("Umbriel Editores");
            add("Brown & Company");
            add("Macmillan Publishers");
            add("Ediciones Obelisco");
            add("Norma");
            add("Zona Libre");
            add("La Iglesia");
            add("Garbo");
        }
    };
    private ArrayList<Integer> anios = new ArrayList<Integer>() {
        {
            add(2017);
            add(1997);
            add(2000);
            add(2010);
            add(2020);
            add(2013);
            add(2005);
            add(1991);
            add(0);
            add(1995);
        }
    };
    private ArrayList<Double> precios = new ArrayList<Double>() {
        {
            add(500.00);
            add(999.99);
            add(1352.50);
            add(3025.20);
            add(1523.42);
            add(5245.22);
            add(3000.00);
            add(10529.30);
            add(9502.00);
        }
    };

    public void Principal() {
        ArrayList<Libro> libros = new ArrayList<Libro>();
        ArrayList<Libro> aux = new ArrayList<Libro>();
        int op = -1;
        double precio;
        String palabra;
        try {
            do {
                System.out.println("*********************************************");
                System.out.println("*                    MENU                   *");
                System.out.println("*********************************************");
                System.out.println("*   1- Ingresar Nuevos Libros.              *");
                System.out.println("*   2- Agregar Libros Aleatoriamente.       *");
                System.out.println("*   3- Buscar Libros por Autor o Editorial. *");
                System.out.println("*   4- Buscar libros segun Precio.          *");
                System.out.println("*********************************************");
                System.out.println("*                 0- SALIR                  *");
                System.out.println("*********************************************");
                op = sc.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Saliendo del Programa...");
                        break;
                    case 1:
                        libros = agregarLibros(libros);
                        System.out.println("Esta seria la lista completa de Libros almacenados");
                        mostrarLibros(libros);
                        break;
                    case 2:
                        libros = agregarLibrosAleatorios(libros);
                        System.out.println("Esta seria la lista completa de Libros almacenados");
                        mostrarLibros(libros);
                        break;
                    case 3:
                        System.out.println("Ingrese el Nombre del Autor o de la Editorial para Realizar la busqueda: ");
                        palabra = sc.nextLine();
                        aux = filtrarAutorEditorial(libros, palabra);
                        mostrarLibros(aux);
                        break;
                    case 4:
                        System.out.println("Ingrese un Precio para contar los libros que tengan un precio menor: ");
                        precio = sc.nextDouble();
                        System.out.println("Se encontraron " + filtarMenorPrecio(libros, precio)
                                + " Libros cuyo precio es menor a $" + precio);
                        break;
                    default:
                        System.out.println(op == -1 ? "" : "Opcion incorrecta");
                }
            } while (op != 0);
        } catch (Exception e) {
            System.out.println("Error al ingresar datos: " + e);
        }
        sc.close();
    }

    // * Se ingresa la cantidad de lobros que se desean ingresar
    private ArrayList<Libro> agregarLibros(ArrayList<Libro> libros) {
        Scanner sc = new Scanner(System.in);
        int cant;
        try {
            System.out.println("Cuantos libros desea agregar? \n Cantidad:");
            cant = sc.nextInt();
            if (cant >= 1) {
                Libro nuevo = new Libro();
                for (int i = 1; i <= cant; i++) {
                    nuevo = cargarLibro(nuevo, i);
                    if (nuevo != null) {
                        libros.add(nuevo);
                        System.out.println("Se agrego el libro Correctamente \n");
                    } else {
                        System.out.println("Ingrese nuevamente.");
                        i--;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de ingreso: " + e);
        }
        sc.close();
        return libros;
    }

    // * Pide y carga los datos en una objeto Libro
    private Libro cargarLibro(Libro nuevo, int i) {
        Scanner sc = new Scanner(System.in);
        String titulo, editorial, autor;
        int anio;
        double precio;
        try {
            System.out.println("Ingrese el Titulo del Libro nro. " + i + " a agregar: ");
            titulo = sc.nextLine();
            System.out.println("Ingrese la Editorial del Libro nro. " + i + " a agregar: ");
            editorial = sc.nextLine();
            System.out.println("Ingrese el nombre del Autor del Libro nro. " + i + " a agregar: ");
            autor = sc.nextLine();
            System.out.println("Ingrese Año de Publicacion del Libro nro. " + i + " a agregar: ");
            anio = sc.nextInt();
            System.out.println("Ingrese Precio del Libro nro. " + i + " a agregar: ");
            precio = sc.nextDouble();
            nuevo = new Libro(titulo, autor, editorial, anio, precio);
        } catch (Exception e) {
            System.out.println("Error al ingresar los datos del libro " + i + ": " + e);
        }
        sc.close();
        return nuevo;
    }

    // * Se ingresa la cantidad de libros aleatorios que se cargaran
    private ArrayList<Libro> agregarLibrosAleatorios(ArrayList<Libro> libros) {
        int cant;
        try {
            System.out.println("Cuantos libros desea agregar? \n Cantidad:");
            cant = sc.nextInt();
            if (cant >= 1) {
                for (int i = 1; i <= cant; i++)
                    libros.add(cargarLibroAleatorio());
            }
        } catch (Exception e) {
            System.out.println("Error de ingreso: " + e);
        }
        return libros;
    }

    // * se cargan los datos de las ArrayList con datos precargados
    private Libro cargarLibroAleatorio() {
        Random random = new Random();
        Libro nuevo = new Libro();
        nuevo.setTitulo(this.titulos.get(random.nextInt(this.titulos.size())));
        nuevo.setEditorial(this.editoriales.get(random.nextInt(this.editoriales.size())));
        nuevo.setAutor(this.autores.get(random.nextInt(this.autores.size())));
        nuevo.setAnioPublicacion(this.anios.get(random.nextInt(this.anios.size())));
        nuevo.setPrecio(this.precios.get(random.nextInt(this.precios.size())));
        return nuevo;
    }

    // * Filtra los libros cuyo precio sea menor al ingresado
    private int filtarMenorPrecio(ArrayList<Libro> libros, double precio) {
        int cont = 0;
        for (Libro l : libros)
            if (l.getPrecio() < precio)
                cont++;
        return cont;
    }

    // * Filtra los Libros segun su editorial o autor
    private ArrayList<Libro> filtrarAutorEditorial(ArrayList<Libro> libros, String palabra) {
        ArrayList<Libro> filtrado = new ArrayList<Libro>();
        for (Libro l : libros)
            if (l.getAutor().equals(palabra) || l.getEditorial().equals(palabra))
                filtrado.add(l);
        return filtrado;
    }

    // * Muestra los libros
    private void mostrarLibros(ArrayList<Libro> libros) {
        for (Libro l : libros)
            System.out.println(l.toString());
    }
}
