package co.edu.eam.ingesoft.pa2.registrodocentes.dto;

public class LoginOutDTO {

	private String token;
	private String usuario;
	private String cedula;
	
	public LoginOutDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginOutDTO(String token, String usuario, String cedula) {
		super();
		this.token = token;
		this.usuario = usuario;
		this.cedula = cedula;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
