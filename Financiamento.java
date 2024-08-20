import java.util.Scanner;

public class Financiamento {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double vt, taxa, taxaMensal, fator;
        int tMeses, prazo;



        System.out.println("Insira o valor total do empréstimo: ");
        vt = input.nextDouble();

        System.out.println("Insira a taxa de juros anual: ");
        taxa = input.nextDouble();

        System.out.println("Insira o prazo em anos: ");
        prazo = input.nextInt();

        taxaMensal = (taxa / 100 ) / 12;

        tMeses = prazo * 12;

        fator = elevarPotencia(1+taxaMensal, tMeses);

        double parcela = (vt * taxaMensal) / (1-(1/fator));

        System.out.printf("O Usuário deverá pagar por mês até quitar: %.2f", parcela);

        input.close();

    }

    public static double elevarPotencia(double base, int expoente){
        if(expoente == 0){
            return 1;
        } else if (expoente == 1) {
            return base;
        }
        else {
            double metade = elevarPotencia(base, expoente /2);

            if(expoente %2==0){
                return  metade*metade;
            }
            else {
                return base*metade*metade;
            }
        }
    }
}
