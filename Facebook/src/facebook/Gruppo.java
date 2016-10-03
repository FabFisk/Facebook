package facebook;

import java.util.*;

public class Gruppo {
	
	private String nome;
	List<Utente> membri = new ArrayList<Utente>();
	
	public Gruppo(){}
	public Gruppo(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
