package uloha.x1;

import uloha.x1.ClovekX.AdresaX;

public class Main {
	
	public static void main(String[] args) {
		Clovek clovek = new Clovek(22, "Luk�", "Sauer", new Adresa(37, "Tulip�nov�", "Mal� Ida"));
		System.out.println(clovek);
		
		
		ClovekX clovek2 = new ClovekX(22, "Luk�", "Sauer");
		ClovekX.AdresaX adresa2 = clovek2.new AdresaX(37, "Tulip�nov�", "Mal� Ida");
		clovek2.pridajAdresu(adresa2);
		System.out.println(clovek2);
	}	
}
