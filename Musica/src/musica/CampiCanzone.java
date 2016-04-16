package musica;

public class CampiCanzone {
	private String titolo;
	private String artista;
	private String album;
	private String genere;
	private int durata;
	private int anno;
	
	public CampiCanzone(String titolo, String artista, String album, String genere, int durata, int anno) {
		this.titolo = titolo;
		this.artista = artista;
		this.album = album;
		this.genere = genere;
		this.durata = durata;
		this.anno= anno;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	
	
	

}
