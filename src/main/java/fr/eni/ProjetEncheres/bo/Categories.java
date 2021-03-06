package fr.eni.ProjetEncheres.bo;

public class Categories extends ArticleVendu {

	
	private int noCategorie  ;
	private String libelle;
	
	
	
	public Categories() {
		super();
	}
	public Categories(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	
	public Categories(String libelle) {
		super();
		this.libelle = libelle;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		String s = String.format("%sCategories[Libelle=%s",super.toString(),getLibelle()  );
		return s;
	}
}
