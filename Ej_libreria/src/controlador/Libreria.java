package controlador;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Libro;
import modelo.Venta;

public class Libreria {
    private ArrayList<Libro> arraylibro = new ArrayList<>();
    private ArrayList<Venta> historialVentas = new ArrayList<>();

    // ---- TABLA LIBROS ----
    public void rellenarTabla(JTable tablaLibros) {
        String[] nombresColumnas = { "ISBN", "TITULO", "EDITORIAL", "AUTOR", "PRECIO", "FORMATO", "ESTADO", "STOCK" };
        String[][] filasTabla = new String[arraylibro.size()][nombresColumnas.length];

        for (int i = 0; i < arraylibro.size(); i++) {
            Libro l = arraylibro.get(i);
            filasTabla[i][0] = l.getISBN();
            filasTabla[i][1] = l.getTitulo();
            filasTabla[i][2] = l.getEditorial();
            filasTabla[i][3] = l.getAutor();
            filasTabla[i][4] = String.valueOf(l.getPrecio());
            filasTabla[i][5] = l.getFormato();
            filasTabla[i][6] = l.getEstado();
            filasTabla[i][7] = String.valueOf(l.getStock());
        }

        DefaultTableModel modelo = new DefaultTableModel(filasTabla, nombresColumnas);
        tablaLibros.setModel(modelo);
    }

    // ---- AGREGAR / BORRAR ----
    public void anadirlibros(Libro libro) {
        arraylibro.add(libro);
    }

    public void borrarlibros(Libro libro) {
        arraylibro.remove(libro);
    }

    public boolean borrarLibroPorISBN(String ISBN, JTable tablaLibros, JFrame parent) {
        if (ISBN == null || ISBN.trim().isEmpty()) return false;

        for (int i = 0; i < arraylibro.size(); i++) {
            if (ISBN.equals(arraylibro.get(i).getISBN())) {
                int opcion = JOptionPane.showConfirmDialog(
                    parent,
                    "¿Estás seguro de que deseas borrar el libro con ISBN: " + ISBN + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    arraylibro.remove(i);
                    DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
                    modelo.removeRow(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // ---- CONSULTAS ----
    public boolean existeISBN(String isbn) {
        for (Libro l : arraylibro) {
            if (l.getISBN().equals(isbn)) return true;
        }
        return false;
    }

    public Libro consultarlibroclaselibro(String ISBN) {
        if (ISBN == null || ISBN.trim().isEmpty()) return null;

        for (Libro libro : arraylibro) {
            if (libro.getISBN().equals(ISBN)) return libro;
        }
        return null;
    }

    // ---- VENDER ----
    public void vender(String isbn, int cantidad, JTable tablaLibros, JFrame parent) {
        Libro libro = consultarlibroclaselibro(isbn);

        if (libro == null) {
            JOptionPane.showMessageDialog(parent, "No se encontró el libro con ISBN: " + isbn);
            return;
        }

        int stockActual = libro.getStock();
        if (cantidad > stockActual) {
            JOptionPane.showMessageDialog(parent, "⚠No hay suficiente stock. Stock disponible: " + stockActual);
            return;
        }

        libro.setStock(stockActual - cantidad);
        JOptionPane.showMessageDialog(parent, "Venta realizada. Nuevo stock: " + libro.getStock());

        historialVentas.add(new Venta(libro.getISBN(), libro.getTitulo(), cantidad, libro.getPrecio()));
        rellenarTabla(tablaLibros);
    }

    // ---- COMPRAR ----
    public boolean comprar(String isbn, int cantidad, JTable tablaLibros, JFrame parent) {
        for (Libro libro : arraylibro) {
            if (libro.getISBN().equals(isbn)) {
                int nuevoStock = libro.getStock() + cantidad;
                libro.setStock(nuevoStock);
                JOptionPane.showMessageDialog(parent, "Compra realizada. Nuevo stock: " + libro.getStock());
                rellenarTabla(tablaLibros);
                return true;
            }
        }
        JOptionPane.showMessageDialog(parent, "No se encontró ningún libro con ese ISBN.");
        return false;
    }

    // ---- HISTORIAL VENTAS ----
    public void mostrarHistorialVentas(JTable tablaHistorial) {
        String[] columnas = { "ISBN", "TÍTULO", "CANTIDAD", "PRECIO UNITARIO", "TOTAL VENTA" };
        String[][] datos = new String[historialVentas.size()][columnas.length];

        for (int i = 0; i < historialVentas.size(); i++) {
            Venta v = historialVentas.get(i);
            datos[i][0] = v.getIsbn();
            datos[i][1] = v.getTitulo();
            datos[i][2] = String.valueOf(v.getCantidadVendida());
            datos[i][3] = String.valueOf(v.getPrecioUnitario());
            datos[i][4] = String.valueOf(v.getTotalVenta());
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaHistorial.setModel(modelo);
    }

    // ---- MODIFICAR ----
    public boolean modificarLibro(String isbn, String titulo, String autor, String editorial,
                                  float precio, String estado, String formato, int stock) {
        for (Libro libro : arraylibro) {
            if (libro.getISBN().equals(isbn)) {
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setEditorial(editorial);
                libro.setPrecio(precio);
                libro.setEstado(estado);
                libro.setFormato(formato);
                libro.setStock(stock);
                return true;
            }
        }
        return false;
    }

    // ---- VALIDACIONES ----
    public static boolean isNumber(String texto) {
        if (texto == null || texto.isEmpty()) return false;
        return Pattern.matches("[0-9]+", texto);
    }
    
    public static boolean validarISBNlibreria(String isbn) {
        if (isbn == null) return false;
        return isbn.length() == 13 && isNumber(isbn);
    }

    // GET HISTORIAL
    public ArrayList<Venta> getHistorialVentas() {
        return historialVentas;
    }

    public ArrayList<Libro> getLibreria() {
        return arraylibro;
    }
}
