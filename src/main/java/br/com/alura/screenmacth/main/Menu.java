package br.com.alura.screenmacth.main;

import br.com.alura.screenmacth.model.DadosSerie;
import br.com.alura.screenmacth.model.DadosTemporada;
import br.com.alura.screenmacth.service.ConsumoAPI;
import br.com.alura.screenmacth.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    private ConsumoAPI consumo = new ConsumoAPI();

    private ConverteDados converteDados = new ConverteDados();

    private final String API_KEY = "&apikey=270b9e";

    private final String ENDERECO = "http://omdbapi.com/?t=";


    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca: ");
        var nomeSerie = scanner.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = converteDados.conversor(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = converteDados.conversor(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);


    }
}
