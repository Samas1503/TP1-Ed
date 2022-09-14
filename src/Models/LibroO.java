package Models;

public class LibroO {
	//* Atributos
    private String titulo;
    private String[] autor;
    private String editorial;
    private int anioPublicacion;
    private double precio;
    private String generoLit;
    
    //* Constructores
    
    public LibroO(String titulo, String[] autor, String editorial, int anioPublicacion, double precio, String generoLit) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.generoLit = generoLit;
    }
    
    public LibroO() {
    }

    //* Getters
    public String[] getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public double getPrecio() {
        return precio;
    }

    //* Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String[] autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setGeneroLiterario(String generoLit) {
    	this.generoLit = generoLit;
    }
    
    @Override
    public String toString() {
        return "LibroO: "+(titulo != null ? "Titulo=" + titulo : "") +
                "\n" + (anioPublicacion!=0 ? "    Año de Publicacion: " + anioPublicacion : "") +
                "\n" + (autor != null ? "    Autor: " + autor  : "") +
                "\n" + (editorial != null ? "    Editorial: " + editorial : "") +
                "\n" + (precio!=0 ? "    Precio: " + precio : "    Gratis") +
        		"\n" + (generoLit != null ? "		Genero Literario: " + generoLit : "");
    }
}