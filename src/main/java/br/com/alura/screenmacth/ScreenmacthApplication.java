package br.com.alura.screenmacth;

import br.com.alura.screenmacth.model.DadosSerie;
import br.com.alura.screenmacth.service.ConsumoAPI;
import br.com.alura.screenmacth.service.IConverteDados;
import br.com.alura.screenmacth.service.ConverteDados;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmacthApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmacthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		var consumoAPI =  new ConsumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=lost&apikey=270b9e");
		//System.out.println(json);
		//json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados = converteDados.conversor(json, DadosSerie.class);
		System.out.println(dados);
	}


}
