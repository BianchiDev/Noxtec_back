package com.noxtec.noxtec.model.error;

public class ErroMenssage {

    private String titulo;

    private Integer status;

    private String menssage;

    public ErroMenssage(String titulo, Integer status, String menssage) {
        this.titulo = titulo;
        this.status = status;
        this.menssage = menssage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

}
