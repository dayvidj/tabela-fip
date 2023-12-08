package br.com.alura.TabelaFipe.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(
		@JsonAlias("Modelo") String modelo, 
		@JsonAlias("AnoModelo") Integer ano,
		@JsonAlias("Valor") String valor, 
		@JsonAlias("Combustivel") String combustivel
		/*@JsonAlias("Marca") String marca,
		@JsonAlias("TipoVeiculo") Integer tipo, 
		@JsonAlias("CodigoFipe") String codigo,
		@JsonAlias("MesReferencia") String referencia,
		@JsonAlias("SiglaCombustivel") String sigla*/) {
}
