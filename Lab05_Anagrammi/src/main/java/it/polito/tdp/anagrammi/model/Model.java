package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.DAO;

public class Model {

	DAO dao;
	Set<String>  anagrammi;  //creo il set in cui vado ad inserire tutti gli anagrammi che trovo;
	

	
	public Model() {
		dao  = new DAO();
		anagrammi = new HashSet<String>(); 
	}

	public boolean corretto(String anagramma) {
		return this.dao.isCorrect(anagramma);
	}
	
	
	public Set<String> anagrammi(String parola){
		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		cerca(parola, parziale, 0, anagrammi);
		//System.out.print(anagrammi);
		return anagrammi;
	}
	
	//Obiettivo: 
	//dalla parola considero la prima lettera e aggiungo tutte le altre lettere volta per volta
	
	//FUNZIONE RICORSIVA
	public void cerca(String parola, String parziale, int L, Set<String> risultato) {
		
		//CASI TERMINALI --> quando finisce il mio algoritmo?
		if(parola.length()==0) { 	  //se la parola non ha piu lettere
			risultato.add(parziale);  //aggiungo il risultato parziale che a questo punto sarà totale
			return;
		}
		else {
		//qui potrei aggiungere qualche caso di uscita un po piu intelligente se volessi trovare direttamente solo le parole corrette
				for(int i=0; i<parola.length();i++) {
				
				//AGGIUNGO (modifico la struttura)
				String nuovaParola = parola.substring(0, i)+parola.substring(i+1);  //tolgo la lettera che sto analizzando
				String nuovaParziale = parziale + parola.charAt(i);
				
				//RICORSIONE (non perdo la testa a capire cosa succede dentro)
				cerca(nuovaParola,nuovaParziale, L+1, risultato);
			
				//BACKTRACKING (rimuovo) non serve in questo caso perchè ho creato delle nuove varibili da passare successivamente
				}
				
			}
	}
	
	
	
}
