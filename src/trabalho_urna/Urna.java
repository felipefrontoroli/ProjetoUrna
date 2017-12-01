package trabalho_urna;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Urna {

    private List<Candidato> candidatosList = new ArrayList<Candidato>();

    public Urna() {
    }

    //METODO UTILIZADO PARA RETORNAR A ELEIÇÃO FINALIZADA
    //PASSANDO COMO PARAMETRO O TIPO DE CANDIDATO BUSCADO E RETORNANDO TODOS OS ATRIBUTOS DO CANDIDATO
    //FAÇO UM FOREACH PARA "VARRER" A LISTA
    public List<Candidato> ResultadoEleicao(String strTipoCandidato) {

        List<Candidato> candidatosOrdenado = new ArrayList<Candidato>();
        
        candidatosList.forEach((c) -> {
            
            
            
            if (c.getTipoCandidato().equals(strTipoCandidato)){
                candidatosOrdenado.add(c);
            }
        });
        
        candidatosOrdenado.sort(Comparator.comparing(Candidato::getNumeroVotos).reversed());       

        return candidatosOrdenado;
    }

    //METODO PARA CADASTRAR OS CANDIDATOS
    //AQUI ELE RECEBE COMO PARAMETRO UM OBJETO DE CANDIDATO.
    //ESSE OBJETO É UMA CLASSE DE CANDIDATO COM SEUS ATRIBUTOS DENTRO DELA.
    public void CadastroCandidatos(Candidato objCandidato) {
        candidatosList.add(objCandidato);
    }

    //METODO CHAMADO DA NOSSA INTERFACE, NO MOMENTO QUE VAMOS CADASTRAR UM CANDIDATO
    //VERIFICA SE O NUMERO QUE O OPERADOR ESTA PASSANDO PARA CADASTRO JA EXISTE VINCULADO PARA OUTRO CANDIDATO
    //SE JÁ EXISTIR O SISTEMA NAO PERMITE O USUARIO PROSSEGUIR COM O CADASTRO DO CANDIDATO
    public boolean VerificaNumeroCandidato(String strNumeroCandidato) {

        for (int i = 0; i < candidatosList.size(); i++) {

            if (candidatosList.get(i).getNumeroCandidato().equals(strNumeroCandidato)) {
                return true;
            }
        }
        return false;
    }

    //METODO CRIADO PARA RETORNA O CANDIDATO
    //BASEANDO-SE COMO BUSCA O NUMERO DO CANDIDATO
    //ESSE METODO RECEBE COMO PARAMETRO 2 STRINGS - 1 STRING RECEBENDO O NUMERO CADASTRADO
    //E A OUTRA STRING É O TIPO DE CANDIDATO (SE ELE É VEREADOR OU PREFEITO)
    //***************************
    //AQUI ELE FAZ UM FOR NA LISTA DE CANDIDATOS E QUANDO ENCONTRA O CANDIDATO
    //RETORNA ESSE CANDIDATO PARA A TELA
    public Candidato RetornaCandidato(String strNumeroCandidato, String strTipoCandidato) {

        for (int i = 0; i < candidatosList.size(); i++) {

            if (candidatosList.get(i).getNumeroCandidato().equals(strNumeroCandidato)
                    && candidatosList.get(i).getTipoCandidato().equals(strTipoCandidato)) {
                return candidatosList.get(i);
            }

        }
        return null;
    }

    //ESSE METODO RECEBE UMA STRING COMO PARAMETRO - ESSA STRING SERIA O NUMERO DO CANDIDATO
    //COM ISSO ELE FAZ UM FOREACH NA LISTA DE CANDIDATOS E ENCONTRANDO O CANDIDATO CONFORME O NUMERO PASSADO
    //ELE CHAMA UM METODO DA CLASSE CANDIDATO QUE ESSE METODO É RESPONSAVEL POR SOMAR MAIS 1 VOTO PARA AQUELE CANDIDATO
    public void VotaCandidato(String strNumeroCandidato) {

        candidatosList.forEach((c) -> {

            if (c.getNumeroCandidato().equals(strNumeroCandidato)) {
                c.AdicionaVoto();
            }
        });
    }
}
