package actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import entities.CustomCliente;
import utilities.ClientManager;

public class AccionFormularioCliente extends ActionSupport {

	private static final String			PATTERN_EMAIL			= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	// Variables del formulario
	private String dni = "";
	private String nombre = "";
	private String apellido = "";
	private String email = "";
	private String direccion = "";
	private String codigoPostal = "";
	private String telefono = "";
	
	private String accion = null;
	
	public String execute() throws Exception {
		if (validation()) {
			CustomCliente cc = new CustomCliente();
			cc.setDni(Integer.parseInt(getDni()));
			cc.setNombre(getNombre());
			cc.setApellido(getApellido());
			cc.setEmail(getEmail());
			cc.setDireccion(getDireccion());
			cc.setCodigoPostal(Integer.parseInt(getCodigoPostal()));
			cc.setTelefono(Integer.parseInt(getTelefono()));
			if (getAccion().equals("add")) {
				ClientManager.getInstance().saveCliente(cc);
			} else {
				ClientManager.getInstance().editCliente(cc);
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
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
	
	private boolean emailValidation(String email) {
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	private boolean codigoPostalValidation(String number) {
		try {
			Integer.parseInt(number);
			int numLength = String.valueOf(number).length();
			if (numLength != 5) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private boolean telefonoValidation(String number) {
		try {
			Long.parseLong(number);
			int numLength = String.valueOf(number).length();
			if (numLength != 9) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private boolean validation() {
		if (getDni().equals("") || getNombre().equals("") || getApellido().equals("") ||
				getEmail().equals("") || getDireccion().equals("") || getCodigoPostal().equals("") ||
				getTelefono().equals("")) {
			addActionError(getText("errors.formulario.cliente.requeridos"));
		} else {
			if (!dniValidation(getDni())){
				addActionError(getText("errors.formulario.cliente.dniFormat"));
			} 
			
			if (!emailValidation(getEmail())) {
				addActionError(getText("errors.formulario.cliente.emailFormat"));
			} 
			
			if (!codigoPostalValidation(getCodigoPostal())) {
				addActionError(getText("errors.formulario.cliente.codigoPostalFormat"));
			}
			
			if (!telefonoValidation(getTelefono())) {
				addActionError(getText("errors.formulario.cliente.telefonoFormat"));
			}
		}
		
		if (!getDni().equals("") && !getNombre().equals("") && !getApellido().equals("") &&
				!getEmail().equals("") && !getDireccion().equals("") && !getCodigoPostal().equals("") &&
				!getTelefono().equals("") && dniValidation(getDni()) && emailValidation(getEmail())
				&& codigoPostalValidation(getCodigoPostal()) && telefonoValidation(getTelefono())) {
			return true;
		} else {
			return false;
		}
	}
}
