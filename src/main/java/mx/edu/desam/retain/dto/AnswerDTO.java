/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.desam.retain.dto;

import java.io.Serializable;

/**
 *
 * @author alphonso
 */
public class AnswerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAnswer;
    private String description;

    public AnswerDTO() {
    }

    public AnswerDTO(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public AnswerDTO(Integer idAnswer, String description) {
        this.idAnswer = idAnswer;
        this.description = description;
    }

    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswer != null ? idAnswer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnswerDTO)) {
            return false;
        }
        AnswerDTO other = (AnswerDTO) object;
        if ((this.idAnswer == null && other.idAnswer != null) || (this.idAnswer != null && !this.idAnswer.equals(other.idAnswer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.desam.toapply.Answer[ idAnswer=" + idAnswer + " ]";
    }
    
}
