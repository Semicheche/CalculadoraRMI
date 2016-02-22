package br.univel.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.common.ServicoRMI;

public class Client {

	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1", 1818);
			ServicoRMI servico = (ServicoRMI) registry.lookup(ServicoRMI.NOME);
			String retorno = servico.greet("Hugo");
			System.out.println(retorno);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}