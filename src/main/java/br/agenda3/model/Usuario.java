package br.agenda3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;
import br.agenda3.auxiliar.UniqueEmail;
import br.agenda3.auxiliar.UniqueLogin;

@Entity
@Component
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8238587905744175289L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	@Size(min = 4, max = 30, message = "Mínimo de 4 e máximo de 30 caracteres.")
	private String nome;

	@Column(nullable = false, unique = true)
	@UniqueEmail(message = "Esse e-mail já está cadastrado.")
	@Pattern(regexp = "^([\\w\\-]+\\.)*[\\w\\- ]+@([\\w\\- ]+\\.)+([\\w\\-]{2,3})$", message = "Insira um e-mail válido.")		
	private String email;

	@Column(unique = true, nullable = false)
	@UniqueLogin(message = "Esse login já está cadastrado.")
	@Size(min = 4, max = 12, message = "Mínimo de 4 e máximo de 12 caracteres.")
	private String login;

	@Column(nullable = false)
	@Size(min = 4, max = 10, message = "Mínimo de 4 e máximo de 10 caracteres.")
	private String senha;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}