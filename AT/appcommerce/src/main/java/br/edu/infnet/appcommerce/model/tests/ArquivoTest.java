package br.edu.infnet.appcommerce.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.domain.Smartphone;
import br.edu.infnet.appcommerce.model.domain.Videogame;
import br.edu.infnet.appcommerce.model.domain.Remessa;
import br.edu.infnet.appcommerce.model.domain.Eletronico;
import br.edu.infnet.appcommerce.model.domain.Cliente;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemEletronicoException;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemClienteException;
import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class ArquivoTest {

	public static void main(String[] args) {
		
		try {
			String arq = "remessas.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();			
				String[] campos = null;
				
				List<Eletronico> eletronicos = new ArrayList<Eletronico>();
				Remessa remessa = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "R":					
						try {						
							remessa = new Remessa(new Cliente(campos[5], campos[3], campos[4]), eletronicos);
							remessa.setDescricao(campos[1]);
							remessa.setWeb(Boolean.valueOf(campos[2]));
						} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

	 					break;
					case "I":					
						try {
							Informatica informatica = new Informatica(campos[1], campos[2], Float.valueOf(campos[3]), campos[5]);
							informatica.setSsd(Boolean.valueOf(campos[3]));

							eletronicos.add(informatica);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "S":
						try {
							Smartphone smartphone = new Smartphone(campos[1], campos[2], Float.valueOf(campos[3]), null, null, 0);
							smartphone.setEsim(Boolean.valueOf(campos[3]));

							eletronicos.add(smartphone);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "V":		
						try {
							Videogame videogame = new Videogame(campos[1], campos[2], Float.valueOf(campos[3]), null, null, 0);
							videogame.setLeitordisco(Boolean.valueOf(campos[3]));

							eletronicos.add(videogame);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						
						break;

					default:
						System.out.println("Registro inválido!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(remessa.obterLinha());
				
				escrita.close();
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}		
	}
}