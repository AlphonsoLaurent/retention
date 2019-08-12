/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retention.dto;

import java.io.Serializable;

/**
 *
 * @author alphonso
 */
public class CategoryCatDTO implements Serializable {

	private static final long serialVersionUID = -8335422720555978797L;
	
	private Integer idCategory;
	private String description;
	
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
	
}
