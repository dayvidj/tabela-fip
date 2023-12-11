package br.com.alura.TabelaFipe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloVeiculo (@JsonAlias("modelos") List<DadosMarca> listaModelos){
}
