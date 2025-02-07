package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main( String[] args ) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes: ");
        int n = sc.nextInt();

        // Registra cada contribuinte

        for (int i=1; i<=n; i++) {
            System.out.println("Contribuinte #"  + i + " Dados: ");
            System.out.print("Pessoa física ('i') ou jurídica ('c') ?");
            char ch = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Renda anual: ");
            double annualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.println("Despesas com saúde: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthExpenditures));
            }
            else{
                System.out.println("Número de funcionarios: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        // Calcula o valor das taxas para cada individuo

        double sum = 0.0;
        System.out.println();
        System.out.println("Valor das taxas:");
        for (TaxPayer tp : list) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        // Calcula o valor total de todas as taxas

        System.out.println();
        System.out.println("Total das taxas: $ " + String.format("%.2f", sum));
    }
}
