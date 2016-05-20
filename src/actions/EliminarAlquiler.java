package actions;

import com.opensymphony.xwork2.ActionSupport;
import utilities.ClientManager;

public class EliminarAlquiler extends ActionSupport {
	
	private String dniCliente = null;
	private String idAlquiler = null;
	private String accion = null;
	
	public String execute() throws Exception {
		ClientManager.getInstance().deleteAlquiler(Integer.parseInt(getIdAlquiler()));
		return SUCCESS;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(String idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
