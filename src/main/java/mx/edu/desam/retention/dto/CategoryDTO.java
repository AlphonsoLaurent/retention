/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retention.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import mx.edu.desam.retention.entity.Answer;
import mx.edu.desam.retention.entity.Category;
import mx.edu.desam.retention.entity.UserPlay;

/**
 *
 * @author alphonso
 */
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = -8335422720555978797L;
	private Integer idCategory;

	private String description;
	private boolean activo;
	private Date dateLastUse;
	private Answer idAnswer;
	private List<CategoryDTO> categoryList;
	//private CategoryDTO idParent;
	private UserPlay idUser;

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getDateLastUse() {
		return dateLastUse;
	}

	public void setDateLastUse(Date dateLastUse) {
		this.dateLastUse = dateLastUse;
	}

	public Answer getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Answer idAnswer) {
		this.idAnswer = idAnswer;
	}
 

	public UserPlay getIdUser() {
		return idUser;
	}

	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

	public void setIdUser(UserPlay idUser) {
		this.idUser = idUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
