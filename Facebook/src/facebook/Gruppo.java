package facebook;

import java.util.*;

public class Gruppo {
	
	private String nome;
	private List<Utente> membri = new ArrayList<Utente>();
	
	public Gruppo(){}
	public Gruppo(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Utente> getMembri() {
		return membri;
	}
	public void setMembri(List<Utente> membri) {
		this.membri = membri;
	}
	
	public void aggiungiUtente(Utente u){
		for(Utente utente: membri){
			if(!utente.getMail().equals(u.getMail())){
				membri.add(u);
			}
		}
	}
}
