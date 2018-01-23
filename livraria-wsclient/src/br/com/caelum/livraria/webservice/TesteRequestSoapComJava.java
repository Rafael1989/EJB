package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {
		LivrariaWS livrariaWS = new LivrariaWSProxy();
		Livro[] livrosPorTitulo = livrariaWS.getLivrosPorTitulo("Arquit");
		
		for (Livro livro : livrosPorTitulo) {
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor().getNome());
		}
	}
}
