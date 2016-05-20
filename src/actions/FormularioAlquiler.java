package actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomActividad;
import entities.CustomPropiedad;
import utilities.ClientManager;

public class FormularioAlquiler extends ActionSupport {
	
	// Variables del formulario
	private String idAlquiler = null;
	private String txtCliente = "";
	private String txtPropiedad = "";
	private String txtActividad = "";
	private String txtFechaInicio = "";
	private String txtFechaFin = "";
	private String txtPrecio = "";
	
	private String accion = null;
	
	private ArrayList<String> propiedades = null;
	private ArrayList<String> actividades = null;
	
	public String execute() throws Exception {
		propiedades = new ArrayList<String>();
		for (CustomPropiedad cp : ClientManager.getInstance().getAllPropiedades()) {
			propiedades.add(cp.getNombre());
		}
		
		actividades = new ArrayList<String>();
		for (CustomActividad ca : ClientManager.getInstance().getAllActividades()) {
			actividades.add(ca.getNombre());
		}
		
		return SUCCESS;
	}
	
	public String getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(String idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getTxtCliente() {
		return txtCliente;
	}
	
	public void setTxtCliente(String txtCliente) {
		this.txtCliente = txtCliente;
	}
	
	public String getTxtPropiedad() {
		return txtPropiedad;
	}
	
	public void setTxtPropiedad(String txtPropiedad) {
		this.txtPropiedad = txtPropiedad;
	}
	
	public String getTxtActividad() {
		return txtActividad;
	}
	
	public void setTxtActividad(String txtActividad) {
		this.txtActividad = txtActividad;
	}
	
	public String getTxtFechaInicio() {
		return txtFechaInicio;
	}
	
	public void setTxtFechaInicio(String txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}
	
	public String getTxtFechaFin() {
		return txtFechaFin;
	}
	
	public void setTxtFechaFin(String txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}
	
	public String getTxtPrecio() {
		return txtPrecio;
	}
	
	public void setTxtPrecio(String txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public ArrayList<String> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<String> propiedades) {
		this.propiedades = propiedades;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<String> actividades) {
		this.actividades = actividades;
	}
}
