package facebook;

import java.util.*;

public class Facebook {
	
	private List<Utente> registrati = new ArrayList<Utente>();
	
	public Facebook (){};
	
	public void registraUtente(String nome, String cognome, int eta, char sesso, String mail){
		if(mail.contains("@")==true){
				Utente user = new Utente(nome, cognome, eta, sesso, mail);
				registrati.add(user);
				System.out.println("Utente registrato con successo!");
			}else{	
				System.out.println("La mail è errata!");
			}
	}
	
	public void aggiungiAmici(String nomeCognome1, String nomeCognome2){
		Utente u1=null;
		Utente u2=null;
	
		for(Utente u : registrati){
			String nomCom = u.etichetta();
			if(nomCom.equals(nomeCognome1)==true){
				u1 = u;
				break;
			}else{
				continue;
			}		
		}
		for(Utente u : registrati){
			String nomCom = u.etichetta();
			if(nomCom.equals(nomeCognome2)==true){
				u2 = u;
				break;
			}else{
				continue;
			}		
		}
		if(u1.isNull()==true || u2.isNull()==true){
			System.out.println("Impossibile registrare Amicizia!");		
		}else{
			u1.addAmico(u2);
			u2.addAmico(u1);		
		}			
	}
	
	public List<Utente> getAmiciDiUnUtente(String nome, String cognome){
		List<Utente> amiciUtente = new ArrayList<Utente>();
		//String amico = "Amici di "+nome+" "+cognome+":\n";
		List<Utente> amici;		
		for (Utente u: registrati){
			if(u.getCognome().equals(cognome)==true 
					&& u.getNome().equals(nome)==true){
				amici = u.getAmici();
				
				for(Utente v: amici){
					amiciUtente.add(v);
					//amico = amico.concat(v.getCognome()+"\t"+v.getNome()+"\n");
				}
			}
		}
		return amiciUtente;
		//return amico;
	}

	public List<Utente> getAmiciDiAmici (String nome, String cognome){
		List<Utente> amiciAmici = new ArrayList<Utente>();
		//String amico = "Amici degli Amici di "+nome+" "+cognome+":\n";
		Utente user = null;
		List<Utente> amiciUtente=null, amiciAmico=null;
		for (Utente u : registrati){
			if(u.getCognome().equals(cognome)==true 
					&& u.getNome().equals(nome)==true){
				user = u;
				amiciUtente = u.getAmici();
				break;
			}
		}	
		for(Utente v : amiciUtente){
				amiciAmico = v.getAmici();
																			
				for(Utente a : amiciAmico){				
					if( a.isEquals(user)!= true){
						if(listContainsUser(amiciUtente,a)== false)
						{	
						amiciAmici.add(a);	
						//amico = amico.concat(a.getCognome()+"\t"+a.getNome()+"\n");
						}
					}
				}
		}
		return amiciAmici;
		//return amico;
	}
	
	public List<Utente> getAmiciComuni (String cognome1, String nome1, String cognome2, String nome2){
		List<Utente> comuni=new ArrayList<Utente>();
		//String amici="Amici comuni tra "+nome1+" "+cognome1+" e "+nome2+" "+cognome2+":\n";
		Utente u1 = null,u2 = null,u3=null;
		
		if(listContainsUser(registrati, nome1, cognome1)==true
				&& listContainsUser(registrati, nome2, cognome2)==true){
			u1 = getUser(registrati, nome1, cognome1);
			u2 = getUser(registrati, nome2, cognome2);
		}
		for(Utente u : u1.getAmici()){
			if(listContainsUser(u2.getAmici(), u)){
				//amici = amici.concat(u.getCognome()+"\t"+u.getNome()+"\n");
				u3 = u;
				comuni.add(u3);
				}
			}		
		return comuni;
		}

	public void creaGruppo (String nome, Utente u){
		
	} 
	
	
	
	public String listToString(List<Utente> lista){
		String str = "";
		for(Utente u : lista){
		str = str.concat(u.getCognome()+"\t"+u.getNome()+"\n");
		}
		return str;
	}
	
	private boolean listContainsUser(List<Utente> lista, Utente u) {
		boolean token = false;	
		for(Utente v : lista){
			if (v.isEquals(u)==true){
				token = true;
				break;
			}else{
				token = false;
			}
		}
		return token;
	}
	
	private boolean listContainsUser(List<Utente> lista, String nome, String cognome){
		boolean token = false;
		for(Utente u : lista){
			if (u.getNome().equals(nome)==true
					&& u.getCognome().equals(cognome)==true){
				token = true;
				break;
			}
		}
		return token;
	}
	
	private Utente getUser(List<Utente> lista, String nome, String cognome){
		Utente user = null;
		for(Utente u : lista){
			if (u.getNome().equals(nome)==true
					&& u.getCognome().equals(cognome)==true){
				user = u;
				break;
			}
		}
		return user;
	}
}


