package actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomActividad;
import entities.CustomAlquiler;
import entities.CustomCliente;
import entities.CustomPropiedad;
import utilities.ClientManager;

public class AccionFormularioAlquiler extends ActionSupport  {
	
	// Variables del formulario
	private String idAlquiler = null;
	private String dniCliente = null;
	private String propiedad = null;
	private String actividad = null;
	private String fechaInicio = null;
	private String fechaFin = null;
	private String precio = null;
	
	private String accion = null;
	
	private CustomCliente cc = null;
	private CustomPropiedad cp = null;
	private CustomActividad ca = null;
	
	public String execute() throws Exception {
		
		if (getDniCliente() != null && getPropiedad() != null && getActividad() != null
				&& getFechaInicio() != null && getFechaFin() != null && getPrecio() != null) {
			
			if (isDateFormat(getFechaInicio()) != null && 
					isDateFormat(getFechaFin()) != null) {
				
				// Inicialización
				setCc(ClientManager.getInstance().getClienteById(Integer.parseInt(getDniCliente()))); 
				for (CustomPropiedad customPropiedad : ClientManager.getInstance().getAllPropiedades()) {
					if (customPropiedad.getNombre().equals(getPropiedad())) {
						setCp(customPropiedad);
					}
				}
				for (CustomActividad customActividad : ClientManager.getInstance().getAllActividades()) {
					if (customActividad.getNombre().equals(getActividad())) {
						setCa(customActividad);
					}
				}
				
				CustomAlquiler customAlquiler = new CustomAlquiler();
				customAlquiler.setCliente(getCc());
				customAlquiler.setPropiedad(getCp());
				customAlquiler.setActividad(getCa());
				customAlquiler.setFecha_inicio(isDateFormat(getFechaInicio()));
				customAlquiler.setFecha_fin(isDateFormat(getFechaFin()));
				customAlquiler.setPrecio(Double.parseDouble(getPrecio()));
				if (getAccion().equals("add")) {
					ClientManager.getInstance().saveAlquiler(customAlquiler);
				} else {
					customAlquiler.setIdAlquiler(Integer.parseInt(getIdAlquiler()));
					ClientManager.getInstance().editAlquiler(customAlquiler);
				}
				return SUCCESS;
			} else {
				addActionError(getText("errors.formulario.alquiler.requeridos"));
	            return ERROR;
			}
		} else {
			addActionError(getText("errors.formulario.alquiler.requeridos"));
            return ERROR;
		}
	}

	public String getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(String idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public CustomCliente getCc() {
		return cc;
	}

	public void setCc(CustomCliente cc) {
		this.cc = cc;
	}

	public CustomPropiedad getCp() {
		return cp;
	}

	public void setCp(CustomPropiedad cp) {
		this.cp = cp;
	}

	public CustomActividad getCa() {
		return ca;
	}

	public void setCa(CustomActividad ca) {
		this.ca = ca;
	}
	
	private Date isDateFormat(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = formatter.parse(date);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
}
