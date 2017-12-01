package trabalho_urna;

public class Candidato {

    public String getNomeCandidato() {
        return NomeCandidato;
    }

    public String getPartidoCandidato() {
        return PartidoCandidato;
    }

    public String getNumeroCandidato() {
        return NumeroCandidato;
    }

    public String getTipoCandidato() {
        return TipoCandidato;
    }

    private String NomeCandidato;
    private String PartidoCandidato;
    private String NumeroCandidato;
    private String TipoCandidato;

    public int getNumeroVotos() {
        return NumeroVotos;
    }
    private int NumeroVotos;

    public Candidato(String strNome, String strPartido, String numeroCandidato, String strTipo) {
        this.NomeCandidato = strNome;
        this.PartidoCandidato = strPartido;
        this.NumeroCandidato = numeroCandidato;
        this.TipoCandidato = strTipo;
        this.NumeroVotos = 0;
    }

    public Candidato() {

    }

    public String RetornaCandidato(){
        return "Candidato: " + this.NomeCandidato + " ";
    }
    
    //METODO CRIADO PARA ADICIONAR VOTO AO CANDIDATO.
    public void AdicionaVoto() {
        this.NumeroVotos++;
    }

    //METODO CRIADO PARA RETORNAR A QUANTIDADE DE VOTOS DO CANDIDATO
    public int RetornaVotos() {
        return this.NumeroVotos;
    }    
}