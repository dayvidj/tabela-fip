package br.com.alura.TabelaFipe.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.TabelaFipe.model.DadosMarca;
import br.com.alura.TabelaFipe.model.DadosVeiculo;
import br.com.alura.TabelaFipe.model.ModeloVeiculo;
import br.com.alura.TabelaFipe.service.ConsumoApi;
import br.com.alura.TabelaFipe.service.ConverteDados;

public class Principal {
	private Scanner sc = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();
	
	private final String URL_API = "https://parallelum.com.br/fipe/api/v1/";

	public void exibeMenu() {

		System.out.println("INFORME O TIPO DE VEÍCULO PARA CONSULTA: \n-CARROS \n-MOTOS \n-CAMINHOES");
		var tipo = sc.nextLine().toLowerCase();
		String endereco = URL_API + tipo + "/marcas";
		var json = consumo.obterDados(endereco);
//		System.out.println(json);	
		var dadosMarca = conversor.obterLista(json, DadosMarca.class);
		dadosMarca.forEach(System.out::println);

		System.out.print("\nDigite o código da marca: ");
		var codigoMarca = sc.nextLine();
		endereco += "/" + codigoMarca + "/modelos";
		
		json = consumo.obterDados(endereco);
		var listaMarca = conversor.obterDados(json, ModeloVeiculo.class);
		listaMarca.modelos().forEach(System.out::println);
		
		System.out.print("\nDigite um trecho do nome do modelo (Ex.: Hilux): ");
		var nomeModelo = sc.nextLine().toUpperCase();
		List<DadosMarca> listaModelo = listaMarca.modelos().stream().filter(m -> m.nome().toUpperCase().contains(nomeModelo)).collect(Collectors.toList());
		listaModelo.forEach(System.out::println);
		
		System.out.print("\nDigite o código do modelo a ser consultado: ");
		var codigoModelo = sc.nextLine();
		endereco += "/" + codigoModelo + "/anos";
		json = consumo.obterDados(endereco);
		
		var modeloAno = conversor.obterLista(json, DadosMarca.class);
//		modeloAno.forEach(System.out::println);
		
		List<DadosVeiculo> veiculos = new ArrayList<>();
		for(DadosMarca d: modeloAno) {
			json = consumo.obterDados(endereco + "/"+ d.codigo());
			veiculos.add(conversor.obterDados(json, DadosVeiculo.class));
		}
		System.out.println("\nTodos os veículo filtrados com avaliações por ano:");
		veiculos.forEach(System.out::println);
		
	}

}
