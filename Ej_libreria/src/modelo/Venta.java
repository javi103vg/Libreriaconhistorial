package modelo;

public class Venta {
    private String isbn;
    private String titulo;
    private int cantidadVendida;
    private double precioUnitario;
    private double totalVenta;

    public Venta(String isbn, String titulo, int cantidadVendida, double precioUnitario) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.cantidadVendida = cantidadVendida;
        this.precioUnitario = precioUnitario;
        this.totalVenta = cantidadVendida * precioUnitario;
    }

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	@Override
	public String toString() {
		return "Venta [isbn=" + isbn + ", titulo=" + titulo + ", cantidadVendida=" + cantidadVendida
				+ ", precioUnitario=" + precioUnitario + ", totalVenta=" + totalVenta + "]";
	}


}
