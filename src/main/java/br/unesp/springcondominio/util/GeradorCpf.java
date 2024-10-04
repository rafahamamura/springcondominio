package br.unesp.springcondominio.util;

import java.util.Random;

public class GeradorCpf {

   public static String gerarCPF() {
      Random random = new Random();
      StringBuilder cpf = new StringBuilder(11);

      // Gera os 9 primeiros dígitos aleatórios
      for (int i = 0; i < 9; i++) {
          cpf.append(random.nextInt(10));
      }

      // Calcula o primeiro dígito verificador
      int dv1 = calcularDigitoVerificador(cpf.toString());
      cpf.append(dv1);

      // Calcula o segundo dígito verificador
      int dv2 = calcularDigitoVerificador(cpf.toString());
      cpf.append(dv2);

      return cpf.toString();
  }

  private static int calcularDigitoVerificador(String cpf) {
      int total = 0;
      int peso = 10;

      for (int i = 0; i < cpf.length(); i++) {
          int digito = Character.getNumericValue(cpf.charAt(i));
          total += digito * peso;
          peso--;

          if (peso < 2) {
              peso = 9;
          }
      }

      int resto = total % 11;
      return resto < 2 ? 0 : 11 - resto;
  }
}
