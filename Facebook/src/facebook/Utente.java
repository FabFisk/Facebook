package facebook;

import java.util.*;

public class Utente {
	private String nome;
	private String cognome;
	private int eta;
	private char sesso;
	private String mail;
	private List<Utente> amici = new ArrayList<Utente>();
	
	public Utente(){};
	public Utente(String nome, String cognome, int eta, char sesso, String mail) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.mail = mail;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Utente> getAmici() {
		return amici;
	}
	public void setAmici(List<Utente> amici) {
		this.amici = amici;
	}
	
	public String etichetta(){
		String etic = this.nome + this.cognome;
		return etic;
	}
	public void addAmico(Utente u){
		this.amici.add(u);
	}
	public boolean isNull() {
		boolean bool;
		if(nome.isEmpty()==true 
				&& cognome.isEmpty()==true 
				&& eta==0
				&& sesso==0
				&& mail.isEmpty()==true){
			bool = true;
		}else{
			bool = false;
		}
		return bool;
	}
	public boolean isEquals(Utente u){
		boolean token = false;
		if(nome.equals(u.getNome())==true
				&& cognome.equals(u.getCognome())==true
				&& eta==u.getEta()
				&& sesso==u.getSesso()
				&& mail.equals(u.getMail())==true){
			token = true;
		}else{
			token = false;
		}
		return token;
	}

}
