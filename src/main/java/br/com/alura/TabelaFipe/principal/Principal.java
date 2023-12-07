package br.com.alura.TabelaFipe.principal;

import java.util.Scanner;

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

		System.out.print("Digite o tipo do veículo(caminhoes, carros, motos): ");
		var tipo = sc.nextLine().toLowerCase();
		String endereco = URL_API + tipo + "/marcas";
		var json = consumo.obterDados(endereco);
		//System.out.println(json);
		
		var dados = conversor.obterLista(json, DadosMarca.class);
		dados.forEach(System.out::println);

		System.out.println("Digite o código da marca: ");
		var codigoMarca = sc.nextLine();
		endereco += "/" + codigoMarca + "/modelos";
		json = consumo.obterDados(endereco);
//		System.out.println(json);
		
		var listaModelo = conversor.obterDados(json, ModeloVeiculo.class);
		listaModelo.modelos().forEach(System.out::println);
		
		System.out.print("Digite o código do modelo: ");
		var modelo = sc.nextLine();
		endereco += "/" + modelo + "/anos";
		json = consumo.obterDados(endereco);
//		System.out.println(json);
		
		var modeloAno = conversor.obterLista(json, DadosMarca.class);
		modeloAno.forEach(System.out::println);
		
		System.out.println("Digite o código do ano: ");
		var codigoAno = sc.nextLine();
		endereco += "/"+ codigoAno;
		json = consumo.obterDados(endereco);
//		System.out.println(json);
		
		var dadosVeiculo = conversor.obterDados(json, DadosVeiculo.class);
		System.out.println(dadosVeiculo);

	}

}
