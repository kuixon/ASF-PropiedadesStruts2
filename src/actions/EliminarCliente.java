package actions;

import com.opensymphony.xwork2.ActionSupport;

import utilities.ClientManager;

public class EliminarCliente extends ActionSupport {

	private String dni = null;
	private String accion = null;
	
	public String execute() throws Exception {
		ClientManager.getInstance().deleteCliente(Integer.parseInt(getDni()));
		return SUCCESS;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
