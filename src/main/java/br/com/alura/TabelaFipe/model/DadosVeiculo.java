package br.com.alura.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;


public record DadosVeiculo(
		@JsonAlias("TipoVeiculo") Integer tipo, 
		@JsonAlias("Valor") String valor, 
		@JsonAlias("Marca") String marca,
		@JsonAlias("Modelo") String modelo, 
		@JsonAlias("AnoModelo") Integer ano,
		@JsonAlias("Combustivel") String combustivel,
		@JsonAlias("CodigoFipe") String codigo,
		@JsonAlias("MesReferencia") String referencia,
		@JsonAlias("SiglaCombustivel") String sigla) {
}
