/*
===========================================================
EXERCÍCIO – CONTROLE DE HORÁRIO DE TRABALHO
===========================================================

OBJETIVO:
Criar um programa em Java que utilize a API java.time
para controlar o horário de entrada e saída de um funcionário.

-----------------------------------------------------------
CONTEXTO:

Um funcionário registra o horário de entrada e o horário
de saída em um determinado dia. O sistema deve calcular
o tempo total trabalhado e verificar se houve hora extra.

-----------------------------------------------------------
REQUISITOS:

1) O programa deve ler:

   - A data do trabalho (formato: yyyy-MM-dd)
   - O horário de entrada (formato: HH:mm)
   - O horário de saída (formato: HH:mm)

2) O programa deve:

   - Criar dois objetos LocalDateTime:
       • Um para o início do expediente
       • Um para o fim do expediente

   - Calcular:
       • O total de horas trabalhadas no dia
       • Se o funcionário trabalhou mais de 8 horas

   - Exibir as datas e horários formatados.

-----------------------------------------------------------
REGRAS OBRIGATÓRIAS:

Você DEVE utilizar:

- LocalDate
- LocalTime
- LocalDateTime
- DateTimeFormatter
- ChronoUnit.HOURS

-----------------------------------------------------------
EXEMPLO DE ENTRADA:

Data de trabalho (yyyy-MM-dd): 2026-04-15
Hora de entrada (HH:mm): 08:00
Hora de saída (HH:mm): 18:30

-----------------------------------------------------------
EXEMPLO DE SAÍDA:

Entrada: 15/04/2026 08:00
Saída: 15/04/2026 18:30
Total trabalhado: 10 horas
Status: Hora extra realizada.

OU

Status: Jornada normal.

-----------------------------------------------------------
DESAFIO EXTRA (OPCIONAL):

- Calcular também os minutos trabalhados.
- Validar se o horário de saída é posterior ao de entrada.
- Caso o funcionário trabalhe menos de 8 horas,
  informar quantas horas faltaram.

===========================================================
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ExercicioDataEHora2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Data: yyyy-MM-dd");
        LocalDate data = LocalDate.parse(sc.nextLine());

        System.out.println("Horário de entrada: HH:mm");
        LocalTime horaEntrada = LocalTime.parse(sc.nextLine());

        System.out.println("Horário de saída: HH:mm");
        LocalTime horaSaida = LocalTime.parse(sc.nextLine());

        //Verificacao
        if(horaSaida.isBefore(horaEntrada)){
            System.out.println("O horário de saída nao pode ser antes da entrada!");
            sc.close();
        }

        LocalDateTime inicioExpediente = LocalDateTime.of(data, horaEntrada);
        LocalDateTime fimExpediente = LocalDateTime.of(data, horaSaida);

        //Quantidade de horas trabalhadas
        double horasTrabalhadas = ChronoUnit.HOURS.between(inicioExpediente, fimExpediente);
        
        //Data e Hora formatada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Controle de horário");
        System.out.println("Entrada :" + inicioExpediente.format(formatter));
        System.out.println("Entrada :" + fimExpediente.format(formatter));
        System.out.println("Total trabalhado: " + horasTrabalhadas + "horas");
        String horaExtra = horasTrabalhadas >= 18 ? "Jornada Normal" : "Hora extra realizada!";
        System.out.println(horaExtra);
        
    }
}
