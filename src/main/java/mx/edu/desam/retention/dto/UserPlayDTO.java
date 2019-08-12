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
 public class UserPlayDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idUserp;
    private String nameUser;
    private String eMail;
    private String passwordUser;
    private List<CategoryDTO> lstCategoryDTO; 
    
	public UserPlayDTO() {
		super();
	}
	public UserPlayDTO(Integer idUserp, String nameUser, String eMail, String passwordUser,
			List<CategoryDTO> lstCategoryDTO) {
		super();
		this.idUserp = idUserp;
		this.nameUser = nameUser;
		this.eMail = eMail;
		this.passwordUser = passwordUser;
		this.lstCategoryDTO = lstCategoryDTO;
	}
	public UserPlayDTO(Integer idUserp, String nameUser, String eMail) {
		super();
		this.idUserp = idUserp;
		this.nameUser = nameUser;
		this.eMail = eMail;
	}
	public Integer getIdUserp() {
		return idUserp;
	}
	public void setIdUserp(Integer idUserp) {
		this.idUserp = idUserp;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public List<CategoryDTO> getLstCategoryDTO() {
		return lstCategoryDTO;
	}
	public void setLstCategoryDTO(List<CategoryDTO> lstCategoryDTO) {
		this.lstCategoryDTO = lstCategoryDTO;
	}

    
    
}
