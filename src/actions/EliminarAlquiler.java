package actions;

import com.opensymphony.xwork2.ActionSupport;
import utilities.ClientManager;

public class EliminarAlquiler extends ActionSupport {
	
	private String txtCliente = null;
	private String idAlquiler = null;
	private String accion = null;
	
	public String execute() throws Exception {
		ClientManager.getInstance().deleteAlquiler(Integer.parseInt(getIdAlquiler()));
		return SUCCESS;
	}
	
	public String getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(String txtCliente) {
		this.txtCliente = txtCliente;
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
