package br.com.cadastro;

import java.util.ArrayList;
import java.util.Scanner; 

public class Main {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int opcao = 0;
		
		while (opcao != 4) {
			System.out.println("1. Adicionar Cliente");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Remover Cliente");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opcao: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
				case 1:
					adicionarCliente(scanner);
					break;
				case 2: 
					listarClientes();
					break;
				case 3: 
					removerCliente(scanner);
					break;
				case 4:
					System.out.print("Saindo...");
				default:
					System.out.print("Opcao Invalida! ");
					
				
			}
		}
		scanner.close();
	}
		
	private static void adicionarCliente(Scanner scanner) {
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Telefone: ");
		String telefone = scanner.nextLine();
		
		Cliente cliente = new Cliente(nome, email, telefone);
		clientes.add(cliente);
		System.out.println("Cliente adicionado com sucesso!");
	}
	
	private static void listarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastro. ");
		} else {
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
				
			}
		}
	}
	
	private static void removerCliente(Scanner scanner) {
		System.out.print("Digite o nome do cliente a ser removido: ");
		String nome = scanner.nextLine();
		
		Cliente clienteARemover = null; 
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				clienteARemover = cliente;
				break;
			}
		}
		
		if (clienteARemover != null) {
			clientes.remove(clienteARemover);
			System.out.println("Cliente removido com sucesso!");
		}else {
			System.out.println("Cliente nao encontrato. ");
		}
	
	}

}
