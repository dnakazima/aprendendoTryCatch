package application;

import java.util.Locale;
import java.util.Scanner;


import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		
		System.out.println("Informe os dados da conta");
		System.out.print("Número: ");
		int number = sc.nextInt();

		System.out.print("Titular: ");
		sc.nextLine();// consumir quebra de linha sc.nextInt() acima
		String holder = sc.nextLine();

		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();

		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		// tratamento final recomendada

	
			acc.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		} 
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
			
		}
		sc.close();
	}

}
