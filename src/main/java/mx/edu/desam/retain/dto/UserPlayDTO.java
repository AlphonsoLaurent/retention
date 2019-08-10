/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import mx.edu.desam.retain.entity.Category;

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
    private Date dateLastUse;
    private List<CategoryDTO> categoryListDTO;

    public UserPlayDTO() {
    }

    public UserPlayDTO(Integer idUserp) {
        this.idUserp = idUserp;
    }

    public UserPlayDTO(Integer idUserp, String nameUser, String eMail, String passwordUser) {
        this.idUserp = idUserp;
        this.nameUser = nameUser;
        this.eMail = eMail;
        this.passwordUser = passwordUser;
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

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Date getDateLastUse() {
        return dateLastUse;
    }

    public void setDateLastUse(Date dateLastUse) {
        this.dateLastUse = dateLastUse;
    }
    public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<CategoryDTO> getCategoryListDTO() {
		return categoryListDTO;
	}

	public void setCategoryListDTO(List<CategoryDTO> categoryListDTO) {
		this.categoryListDTO = categoryListDTO;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserp != null ? idUserp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPlayDTO)) {
            return false;
        }
        UserPlayDTO other = (UserPlayDTO) object;
        if ((this.idUserp == null && other.idUserp != null) || (this.idUserp != null && !this.idUserp.equals(other.idUserp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.desam.toapply.UserPlay[ idUserp=" + idUserp + " ]";
    }
    
}
