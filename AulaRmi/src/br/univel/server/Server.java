package br.univel.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.common.ServicoRMI;

public class Server implements ServicoRMI {

	@Override
	public String greet(String nome) throws RemoteException {
		System.out.println(nome + " conectou.");
		return "Ol� " + nome;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Iniciando o server...");

		Server s = new Server();
		ServicoRMI servico;
		try {
			servico = (ServicoRMI) UnicastRemoteObject.exportObject(s, 0);
			Registry registry = LocateRegistry.createRegistry(1818);
			registry.rebind(ServicoRMI.NOME, servico);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
