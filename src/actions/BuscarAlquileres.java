package actions;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomAlquiler;
import entities.CustomCliente;
import utilities.ClientManager;

public class BuscarAlquileres extends ActionSupport {
	
	private String dniCliente = null;
	private ArrayList<CustomAlquiler> listaAlquileres = null;
	
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

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public ArrayList<CustomAlquiler> getListaAlquileres() {
		return listaAlquileres;
	}

	public void setListaAlquileres(ArrayList<CustomAlquiler> listaAlquileres) {
		this.listaAlquileres = listaAlquileres;
	}
	
	private boolean dniValidation(String number) {
		try {
			Long.parseLong(number);
			int numLength = String.valueOf(number).length();
			if (numLength != 8) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
