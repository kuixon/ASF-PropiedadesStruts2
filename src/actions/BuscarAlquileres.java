package actions;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomAlquiler;
import entities.CustomCliente;
import utilities.ClientManager;

public class BuscarAlquileres extends ActionSupport {
	
	private String txtCliente = null;
	private ArrayList<CustomAlquiler> listaAlquileres = null;
	
	public String execute() throws Exception {
		if (validation()) {
			setListaAlquileres(ClientManager.getInstance().getAlquileresByDniCliente(Integer.parseInt(getTxtCliente())));
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(String txtCliente) {
		this.txtCliente = txtCliente;
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
	
	private boolean validation() {
		if (getTxtCliente() == null || getTxtCliente().equals("")) {
			addActionError(getText("errors.requerido.dniCliente"));
		} else {
			if (!dniValidation(getTxtCliente())) {
				addActionError(getText("errors.formato.incorrecto.dniCliente"));
			}
			
			boolean enc = false;
			if (getTxtCliente() != null && !getTxtCliente().equals("") && dniValidation(getTxtCliente())) {
				ArrayList<CustomCliente> clientes = ClientManager.getInstance().getAllClientes();
				for (CustomCliente cc : clientes) {
					if (cc.getDni() == Integer.parseInt(getTxtCliente())) {
						enc = true;
					}
				}
				if (!enc) {
					addActionError(getText("errors.inexistente.dniCliente"));
				}
			}
			
			if (getTxtCliente() != null && !getTxtCliente().equals("") && dniValidation(getTxtCliente())
					&& enc) {
				return true;
			}
		}
		return false;
	}
}
