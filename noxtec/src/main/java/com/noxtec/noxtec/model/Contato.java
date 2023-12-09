package com.noxtec.noxtec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "contato_nome", length = 100)
    private String contatoNome;

    @Column(name = "contato_email", length = 255)
    private String contatoEmail;

    @Column(name = "contato_celular", length = 11)
    private String contatoCelular;

    @Column(name = "contato_telefone", length = 10)
    private String contatoTelefone;

    @Column(name = "ontato_sn_favorito", length = 1)
    private String contatoSnFavorito;

    @Column(name = "contato_sn_ativo", length = 1)

    private String contatoSnAtivo;

    public Contato(Integer id, String contatoNome, String contatoEmail, String contatoCelular, String contatoTelefone,
            String contatoSnFavorito, String contatoSnAtivo) {
        this.id = id;
        this.contatoNome = contatoNome;
        this.contatoEmail = contatoEmail;
        this.contatoCelular = contatoCelular;
        this.contatoTelefone = contatoTelefone;
        this.contatoSnFavorito = contatoSnFavorito;
        this.contatoSnAtivo = contatoSnAtivo;
    }

    public Contato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public void setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }

    public void setContatoEmail(String contatoEmail) {
        this.contatoEmail = contatoEmail;
    }

    public String getContatoCelular() {
        return contatoCelular;
    }

    public void setContatoCelular(String contatoCelular) {
        this.contatoCelular = contatoCelular;
    }

    public String getContatoTelefone() {
        return contatoTelefone;
    }

    public void setContatoTelefone(String contatoTelefone) {
        this.contatoTelefone = contatoTelefone;
    }

    public String getContatoSnFavorito() {
        return contatoSnFavorito;
    }

    public void setContatoSnFavorito(String contatoSnFavorito) {
        this.contatoSnFavorito = contatoSnFavorito;
    }

    public String getContatoSnAtivo() {
        return contatoSnAtivo;
    }

    public void setContatoSnAtivo(String contatoSnAtivo) {
        this.contatoSnAtivo = contatoSnAtivo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
