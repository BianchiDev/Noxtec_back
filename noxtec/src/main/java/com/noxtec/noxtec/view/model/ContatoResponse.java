package com.noxtec.noxtec.view.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoResponse {

    private String contatoNome;

    private String contatoEmail;

    private String contatoCelular;

    private String contatoTelefone;

    private String contatoSnFavorito;

    @JsonIgnore
    private String contatoSnAtivo;

}
