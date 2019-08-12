/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retention.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alphonso
 */
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = -8335422720555978797L;
	
	private Integer idCategory;
	private String description; 
	private Integer idAnswer;
	private List<CategoryDTO> lstCategoryDTO;
	private Integer idParent;
	private Integer idUser;
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
	public Integer getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(Integer idAnswer) {
		this.idAnswer = idAnswer;
	}
	public List<CategoryDTO> getLstCategoryDTO() {
		return lstCategoryDTO;
	}
	public void setLstCategoryDTO(List<CategoryDTO> lstCategoryDTO) {
		this.lstCategoryDTO = lstCategoryDTO;
	}
	public Integer getIdParent() {
		return idParent;
	}
	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	 
	
	
}
