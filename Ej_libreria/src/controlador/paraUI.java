package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import modelo.Libro;
import vista.UI;

public class paraUI extends UI {
    private Libreria libreria = new Libreria();

    public paraUI() {
        // --- BOTÓN GUARDAR ---
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = textField.getText().trim();
                String titulo = textField_1.getText().trim();
                String autor = textField_2.getText().trim();
                String editorial = textField_3.getText().trim();

                // Validación ISBN
                if (!Libreria.validarISBNlibreria(isbn)) {
                    JOptionPane.showMessageDialog(
                        paraUI.this,
                        "El ISBN debe tener 13 dígitos numéricos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Validación precio
                float precio = 0;
                try {
                    precio = Float.parseFloat(textField_4.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(paraUI.this, "Introduce un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Formato
                String formato = rdbtnCartone.isSelected() ? "Cartoné" :
                                 rdbtngrapada.isSelected() ? "Grapada" :
                                 rdbtnrustica.isSelected() ? "Rústica" : "Espiral";

                // Estado
                String estado = rdbtnreedicion.isSelected() ? "Reedición" :
                                rdbtnnovedad.isSelected() ? "Novedad" : "";

                int stock = (int) spinner.getValue();

                // Verificar si ya existe
                if (libreria.existeISBN(isbn)) {
                    // Modificar existente
                    libreria.modificarLibro(isbn, titulo, autor, editorial, precio, estado, formato, stock);
                    JOptionPane.showMessageDialog(paraUI.this, "Libro modificado correctamente.");
                } else {
                    // Agregar nuevo
                    Libro li = new Libro(isbn, titulo, autor, editorial, precio, estado, formato, stock);
                    libreria.anadirlibros(li);
                    JOptionPane.showMessageDialog(paraUI.this, "Libro agregado correctamente.");
                }

                // Actualizar tabla
                libreria.rellenarTabla(tablaLibros);

                // Limpiar campos
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
            }
        });

        // --- BOTÓN BORRAR ---
        btnBorrar.addActionListener(e -> {
            String ISBN = JOptionPane.showInputDialog(paraUI.this, "Introduce el ISBN del libro a borrar:");
            if (ISBN != null && !ISBN.trim().isEmpty()) {
                boolean borrado = libreria.borrarLibroPorISBN(ISBN, tablaLibros, paraUI.this);
                if (borrado) {
                    JOptionPane.showMessageDialog(paraUI.this, "El libro con ISBN '" + ISBN + "' ha sido borrado.");
                } else {
                    JOptionPane.showMessageDialog(paraUI.this, "No se encontró ningún libro con ISBN '" + ISBN + "'.");
                }
            } else {
                JOptionPane.showMessageDialog(paraUI.this, "No introdujiste ningún ISBN.");
            }
        });

        // --- BOTÓN CONSULTAR ---
        btnConsultar.addActionListener(e -> {
            String ISBN = JOptionPane.showInputDialog(paraUI.this, "Introduce el ISBN del libro a consultar:");
            if (ISBN != null && !ISBN.trim().isEmpty()) {
                Libro encontrado = libreria.consultarlibroclaselibro(ISBN);
                if (encontrado != null) {
                    JOptionPane.showMessageDialog(paraUI.this, "Libro encontrado:\n" + encontrado.toString());
                } else {
                    JOptionPane.showMessageDialog(paraUI.this, "No se encontró ningún libro con ISBN '" + ISBN + "'.");
                }
            } else {
                JOptionPane.showMessageDialog(paraUI.this, "No introdujiste ningún ISBN.");
            }
        });

        // --- BOTÓN VENDER ---
        btnvender.addActionListener(e -> {
            String isbn = JOptionPane.showInputDialog(paraUI.this, "Introduce el ISBN del libro que deseas vender:");
            if (isbn == null || isbn.trim().isEmpty()) return;

            String cantidadStr = JOptionPane.showInputDialog(paraUI.this, "Introduce la cantidad que deseas vender:");
            if (cantidadStr == null || cantidadStr.trim().isEmpty()) return;

            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(paraUI.this, "La cantidad debe ser mayor que cero.");
                    return;
                }
                libreria.vender(isbn, cantidad, tablaLibros, paraUI.this);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(paraUI.this, "La cantidad debe ser un número válido.");
            }
        });

        // --- BOTÓN COMPRAR ---
        btncomprar.addActionListener(e -> {
            String isbn = JOptionPane.showInputDialog(paraUI.this, "Introduce el ISBN del libro que deseas comprar:");
            if (isbn == null || isbn.trim().isEmpty()) {
                JOptionPane.showMessageDialog(paraUI.this, "Debes introducir un ISBN.");
                return;
            }

            String cantidadStr = JOptionPane.showInputDialog(paraUI.this, "Introduce la cantidad que deseas agregar al stock:");
            if (cantidadStr == null || cantidadStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(paraUI.this, "Debes introducir una cantidad.");
                return;
            }

            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(paraUI.this, "La cantidad debe ser mayor que cero.");
                    return;
                }

                libreria.comprar(isbn, cantidad, tablaLibros, paraUI.this);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(paraUI.this, "La cantidad debe ser un número válido.");
            }
        });

        // --- BOTÓN MODIFICAR ---
        btnmod.addActionListener(e -> {
            int filaSeleccionada = tablaLibros.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(paraUI.this, "Selecciona un libro en el apartado libreria para modificar.");
                return;
            }

            textField.setText(tablaLibros.getValueAt(filaSeleccionada, 0).toString());
            textField_1.setText(tablaLibros.getValueAt(filaSeleccionada, 1).toString());
            textField_2.setText(tablaLibros.getValueAt(filaSeleccionada, 2).toString());
            textField_3.setText(tablaLibros.getValueAt(filaSeleccionada, 3).toString());
            textField_4.setText(tablaLibros.getValueAt(filaSeleccionada, 4).toString());

            // Cambiar a pestaña “Libro”
            JTabbedPane tabbedPane = (JTabbedPane) getContentPane().getComponent(1);
            tabbedPane.setSelectedIndex(0);
        });

        // --- BOTÓN HISTORIAL ---
        btnHistorialVentas.addActionListener(e -> {
            libreria.mostrarHistorialVentas(historialventya);
            JTabbedPane tabbedPane = (JTabbedPane) Mercado.getParent();
            tabbedPane.setSelectedComponent(Mercado);
            JOptionPane.showMessageDialog(paraUI.this, "Historial actualizado correctamente.");
        });
    }
}
