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
	private String txtCliente = "";
	private String txtPropiedad = "";
	private String txtActividad = "";
	private String txtFechaInicio = "";
	private String txtFechaFin = "";
	private String txtPrecio = "";
	
	private String accion = null;
	
	private ArrayList<String> propiedades = null;
	private ArrayList<String> actividades = null;
	
	private CustomCliente cc = null;
	private CustomPropiedad cp = null;
	private CustomActividad ca = null;
	
	public String execute() throws Exception {
		
		// Inicialización propiedades y actividades
		propiedades = new ArrayList<String>();
		for (CustomPropiedad cp : ClientManager.getInstance().getAllPropiedades()) {
			propiedades.add(cp.getNombre());
		}
		
		actividades = new ArrayList<String>();
		for (CustomActividad ca : ClientManager.getInstance().getAllActividades()) {
			actividades.add(ca.getNombre());
		}
		
		if (!getTxtCliente().equals("") && !getTxtPropiedad().equals("") && !getTxtActividad().equals("")
				&& !getTxtFechaInicio().equals("") && !getTxtFechaFin().equals("") && !getTxtPrecio().equals("")) {
			
			if (isDateFormat(getTxtFechaInicio()) != null && 
					isDateFormat(getTxtFechaFin()) != null) {
				if (isNumber(getTxtPrecio())) {
					// Inicialización
					setCc(ClientManager.getInstance().getClienteById(Integer.parseInt(getTxtCliente()))); 
					for (CustomPropiedad customPropiedad : ClientManager.getInstance().getAllPropiedades()) {
						if (customPropiedad.getNombre().equals(getTxtPropiedad())) {
							setCp(customPropiedad);
						}
					}
					for (CustomActividad customActividad : ClientManager.getInstance().getAllActividades()) {
						if (customActividad.getNombre().equals(getTxtActividad())) {
							setCa(customActividad);
						}
					}
					
					CustomAlquiler customAlquiler = new CustomAlquiler();
					customAlquiler.setCliente(getCc());
					customAlquiler.setPropiedad(getCp());
					customAlquiler.setActividad(getCa());
					customAlquiler.setFecha_inicio(isDateFormat(getTxtFechaInicio()));
					customAlquiler.setFecha_fin(isDateFormat(getTxtFechaFin()));
					customAlquiler.setPrecio(Double.parseDouble(getTxtPrecio()));
					if (getAccion().equals("add")) {
						ClientManager.getInstance().saveAlquiler(customAlquiler);
					} else {
						customAlquiler.setIdAlquiler(Integer.parseInt(getIdAlquiler()));
						ClientManager.getInstance().editAlquiler(customAlquiler);
					}
					return SUCCESS;
				} else {
					addActionError(getText("errors.formulario.alquiler.formatoPrecio"));
		            return ERROR;
				}
			} else {
				addActionError(getText("errors.formulario.alquiler.formatoFechas"));
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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public ArrayList<String> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<String> propiedades) {
		this.propiedades = propiedades;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<String> actividades) {
		this.actividades = actividades;
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

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
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
