package actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomCliente;
import utilities.ClientManager;

public class FormularioAlquiler extends ActionSupport {
	
	// Variables del formulario
	private String txtCliente = "";
	private String txtPropiedad = "";
	private String txtActividad = "";
	private String txtFechaInicio = "";
	private String txtFechaFin = "";
	private String txtPrecio = "";
	
	/*
	public String execute() throws Exception {
		if (getDniCliente() == null || getDniCliente().equals("")) {
			addActionError(getText("errors.requerido.dniCliente"));
			return INPUT;
		} else if (!dniValidation(getDniCliente())) {
			addActionError(getText("errors.formato.incorrecto.dniCliente"));
            return ERROR;
		} else {
			ArrayList<CustomCliente> clientes = ClientManager.getInstance().getAllClientes();
			boolean enc = false;
			for (CustomCliente cc : clientes) {
				if (cc.getDni() == Integer.parseInt(getDniCliente())) {
					enc = true;
				}
			}
			if (enc) {
				setListaAlquileres(ClientManager.getInstance().getAlquileresByDniCliente(Integer.parseInt(getDniCliente())));
				return SUCCESS;
			} else {
				addActionError(getText("errors.inexistente.dniCliente"));
	            return ERROR;
			}
		}
		
	}
	*/
	
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
}
