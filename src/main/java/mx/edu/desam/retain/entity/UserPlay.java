/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alphonso
 */
@Entity
@Table(name = "user_play", schema = "playit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPlay.findAll", query = "SELECT u FROM UserPlay u")
    , @NamedQuery(name = "UserPlay.findByIdUserp", query = "SELECT u FROM UserPlay u WHERE u.idUserp = :idUserp")
    , @NamedQuery(name = "UserPlay.findByNameUser", query = "SELECT u FROM UserPlay u WHERE u.nameUser = :nameUser")
    , @NamedQuery(name = "UserPlay.findByEMail", query = "SELECT u FROM UserPlay u WHERE u.eMail = :eMail")
    , @NamedQuery(name = "UserPlay.findByPasswordUser", query = "SELECT u FROM UserPlay u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "UserPlay.findByDateLastUse", query = "SELECT u FROM UserPlay u WHERE u.dateLastUse = :dateLastUse")})
public class UserPlay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_userp")
    private Integer idUserp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name_user")
    private String nameUser;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "e_mail")
    private String eMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "password_user")
    private String passwordUser;
    @Column(name = "date_last_use")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.LAZY)
    private List<Category> categoryList;

    public UserPlay() {
    }

    public UserPlay(Integer idUserp) {
        this.idUserp = idUserp;
    }

    public UserPlay(Integer idUserp, String nameUser, String eMail, String passwordUser) {
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

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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
        if (!(object instanceof UserPlay)) {
            return false;
        }
        UserPlay other = (UserPlay) object;
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
