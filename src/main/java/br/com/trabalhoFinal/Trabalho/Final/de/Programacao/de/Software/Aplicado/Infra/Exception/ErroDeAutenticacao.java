package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception;

public class ErroDeAutenticacao extends RuntimeException{
    public ErroDeAutenticacao(String e) {
        super(e);
    }
}
