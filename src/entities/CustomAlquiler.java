package entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomAlquiler {

	private int				idAlquiler;
	private CustomCliente	cliente;
	private CustomActividad	actividad;
	private CustomPropiedad	propiedad;
	private Date			fecha_inicio;
	private Date			fecha_fin;
	private double			precio;

	public CustomAlquiler() {

	}

	public CustomAlquiler(CustomCliente cliente, CustomActividad actividad, CustomPropiedad propiedad, Date fechaInicio, Date fechaFin,
			double precio) {
		this.cliente = cliente;
		this.actividad = actividad;
		this.propiedad = propiedad;
		this.fecha_inicio = fechaInicio;
		this.fecha_fin = fechaFin;
		this.precio = precio;
	}

	public CustomAlquiler(int idAlquiler, CustomCliente cliente, CustomActividad actividad, CustomPropiedad propiedad, Date fechaInicio,
			Date fechaFin, double precio) {
		this.idAlquiler = idAlquiler;
		this.cliente = cliente;
		this.actividad = actividad;
		this.propiedad = propiedad;
		this.fecha_inicio = fechaInicio;
		this.fecha_fin = fechaFin;
		this.precio = precio;
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public CustomCliente getCliente() {
		return cliente;
	}

	public void setCliente(CustomCliente cliente) {
		this.cliente = cliente;
	}

	public CustomActividad getActividad() {
		return actividad;
	}

	public void setActividad(CustomActividad actividad) {
		this.actividad = actividad;
	}

	public CustomPropiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(CustomPropiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", cliente=" + cliente + ", actividad=" + actividad + ", propiedad=" + propiedad
				+ ", fechaInicio=" + fecha_inicio + ", fechaFin=" + fecha_fin + ", precio=" + precio + "]";
	}
}