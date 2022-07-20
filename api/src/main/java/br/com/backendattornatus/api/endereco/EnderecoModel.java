package br.com.backendattornatus.api.endereco;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_endereco")
public class EnderecoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private Integer numero;
	private String cidade;

	@Enumerated(EnumType.STRING)
	private Enums tipo_endereco;

	public EnderecoModel() {
	}

	public EnderecoModel(String logradouro, Integer numero, String cidade, Enums tipo_endereco) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.tipo_endereco = tipo_endereco;
	}
	


	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public Enums getTipo_endereco() {
		return tipo_endereco;
	}

	public void setTipo_endereco(Enums tipo_endereco) {
		this.tipo_endereco = tipo_endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoModel other = (EnderecoModel) obj;
		return Objects.equals(id, other.id);
	}

}
