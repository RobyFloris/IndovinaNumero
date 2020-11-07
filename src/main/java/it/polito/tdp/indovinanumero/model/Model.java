package it.polito.tdp.indovinanumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco ;
	
	private Set<Integer> tentativi;
	public Model() {
		this.inGioco= false;
		this.tentativiFatti= 0;
		
		
	}
	
	public void nuovaPartita() {
		//gestione dell'inizio di una nuova partita - Logica del gioco
		
		
    	this.segreto = (int)(Math.random() * NMAX) + 1;
    	this.tentativiFatti = 0;
    	this.tentativi = new HashSet<Integer> ();
    	this.inGioco = true; 
		
	}
		
		
	
	public int tentativo (int tentativo) { 
		// controllo se la partita è in corso
		if (!inGioco) {
			throw new IllegalStateException("La partita è già terminata!");
		
		}
		
		//Controllo l'input
		if (!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Devi usare un numero che non hai ancora utilizzato compreso tra 1 e "+TMAX+"\n");
			
			
		}
		//il tentativo è valido--> possiamo "provarlo"
		this.tentativiFatti ++;
		this.tentativi.add(tentativo);
		if (this.tentativiFatti== TMAX) {
			this.inGioco= false;
		}
		if (tentativo== this.segreto) {
			this.inGioco= false;
			return 0;
		}
		
		if (tentativo<this.segreto) {
			return -1;
			
		}
		else {
			return 1; 
		}
		
	}
	
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1 || tentativo>TMAX) {
			return false;
			
		}
		else {
			if (this.tentativi.contains(tentativo)) {
				return false;
			}
			return true; 
		}
		
	}

	public int getSegreto() {
		return segreto;
	}

	

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}

	
	
}

	

