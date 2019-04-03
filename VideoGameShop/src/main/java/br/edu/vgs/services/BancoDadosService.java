package br.edu.vgs.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.vgs.domain.Genero;
import br.edu.vgs.domain.Jogo;
import br.edu.vgs.repositories.GeneroRepository;
import br.edu.vgs.repositories.JogoRepository;

@Service
public class BancoDadosService {

	@Autowired
	private GeneroRepository generoRepository;

	@Autowired
	private JogoRepository jogoRepository;

	public void instantiateDatabase() throws ParseException {
		Genero genero1 = new Genero(null, "Ação");
		Genero genero2 = new Genero(null, "Aventura");
		Genero genero3 = new Genero(null, "Estratégia");
		Genero genero4 = new Genero(null, "RPG");
		Genero genero5 = new Genero(null, "Esporte");
		Genero genero6 = new Genero(null, "Corrida");
		Genero genero7 = new Genero(null, "Simulação");
		Genero genero8 = new Genero(null, "Puzzle");
		Genero genero9 = new Genero(null, "Terror");
		Genero genero10 = new Genero(null, "Indie");

		Jogo jogo1 = new Jogo(null, "Grand Theft Auto V", 69.99);
		Jogo jogo2 = new Jogo(null, "Assassin's Creed Odyssey", 159.99);
		Jogo jogo3 = new Jogo(null, "Overwatch", 149.00);
		Jogo jogo4 = new Jogo(null, "Diablo III: Reaper of Souls", 109.90);
		Jogo jogo5 = new Jogo(null, "Rocket League", 36.99);
		Jogo jogo6 = new Jogo(null, "Need For Speed Payback", 159.00);
		Jogo jogo7 = new Jogo(null, "Yu-Gi-Oh! Legacy of the Duelist", 39.00);
		Jogo jogo8 = new Jogo(null, "Portal 2", 20.69);
		Jogo jogo9 = new Jogo(null, "Antichamber", 34.99);
		Jogo jogo10 = new Jogo(null, "Devil May Cry 5", 129.99);
		Jogo jogo11 = new Jogo(null, "Outlast 2", 57.99);
		Jogo jogo12 = new Jogo(null, "South Park: The Fractured But Whole", 159.99);
		Jogo jogo13 = new Jogo(null, "Left 4 Dead 2", 19.99);

		genero1.getJogos().addAll(Arrays.asList(jogo1, jogo2, jogo3, jogo4, jogo8, jogo10, jogo13));
		genero2.getJogos().addAll(Arrays.asList(jogo1, jogo2, jogo4, jogo6, jogo8, jogo9, jogo10, jogo12, jogo13));
		genero3.getJogos().addAll(Arrays.asList(jogo3, jogo7, jogo12));
		genero4.getJogos().addAll(Arrays.asList(jogo2, jogo4, jogo12));
		genero5.getJogos().addAll(Arrays.asList(jogo5));
		genero6.getJogos().addAll(Arrays.asList(jogo5, jogo6));
		genero7.getJogos().addAll(Arrays.asList(jogo7));
		genero8.getJogos().addAll(Arrays.asList(jogo8, jogo9));
		genero9.getJogos().addAll(Arrays.asList(jogo11));
		genero10.getJogos().addAll(Arrays.asList(jogo9));

		jogo1.getGeneros().addAll(Arrays.asList(genero1, genero2));
		jogo2.getGeneros().addAll(Arrays.asList(genero1, genero2, genero4));
		jogo3.getGeneros().addAll(Arrays.asList(genero1, genero3));
		jogo4.getGeneros().addAll(Arrays.asList(genero1, genero2, genero4));
		jogo5.getGeneros().addAll(Arrays.asList(genero5, genero6));
		jogo6.getGeneros().addAll(Arrays.asList(genero2, genero6));
		jogo7.getGeneros().addAll(Arrays.asList(genero3, genero7));
		jogo8.getGeneros().addAll(Arrays.asList(genero1, genero2, genero8));
		jogo9.getGeneros().addAll(Arrays.asList(genero2, genero8, genero10));
		jogo10.getGeneros().addAll(Arrays.asList(genero1, genero2));
		jogo11.getGeneros().addAll(Arrays.asList(genero9));
		jogo12.getGeneros().addAll(Arrays.asList(genero2, genero3, genero4));
		jogo13.getGeneros().addAll(Arrays.asList(genero1, genero2));

		generoRepository.saveAll(Arrays.asList(genero1, genero2, genero3, genero4, genero5, genero6, genero7, genero8, genero9, genero10));
		jogoRepository.saveAll(Arrays.asList(jogo1, jogo2, jogo3, jogo4, jogo5, jogo6, jogo7, jogo8, jogo9, jogo10, jogo11, jogo12, jogo13));
	}
}