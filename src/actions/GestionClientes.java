package actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomCliente;
import utilities.ClientManager;

public class GestionClientes extends ActionSupport {
	
	private ArrayList<CustomCliente> listaClientes = null;
	
	public String execute() throws Exception {
		setListaClientes(ClientManager.getInstance().getAllClientes());
		return SUCCESS;
	}

	public ArrayList<CustomCliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<CustomCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
