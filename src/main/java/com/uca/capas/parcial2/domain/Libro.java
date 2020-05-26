package com.uca.capas.parcial2.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name="c_libro")
	private Integer codigoLibro;

	@Column(name="s_titulo")
	@Size(message="El campo no debe contener mas de 500 caracteres", max=500)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String titulo;
	
	@Column(name="s_autor")
	@Size(message="El campo no debe contener mas de 150 caracteres", max=150)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String autor;
	
	@Column(name="s_isbn")
	@Size(message="El campo no debe contener mas de 10 caracteres", max=10)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String isbn;
	
	@Column(name="b_estado")
	@NotNull(message="Este campo no puede estar vacio")
	private String estado;
	
	@Column(name = "f_ingreso")
	private Date fechaIngreso;
	
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;
	
	public Libro() {super();}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFechaIngresoDelegate(){
		if(this.fechaIngreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String shortdate = sdf.format(this.fechaIngreso.getTime());
			return shortdate;
		}
	}
	
}
