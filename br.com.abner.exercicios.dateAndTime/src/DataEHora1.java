/*
===========================================================
EXERCÍCIO – SISTEMA DE AGENDAMENTO DE EVENTO
===========================================================

OBJETIVO:
Criar um programa em Java que utilize a API java.time
para gerenciar o agendamento de um evento.

-----------------------------------------------------------
REQUISITOS:

1) O programa deve ler:

   - A data do evento (formato: yyyy-MM-dd)
   - O horário de início (formato: HH:mm)
   - A duração do evento em horas (número inteiro)

2) O programa deve:

   - Criar um LocalDateTime combinando a data e hora.
   - Calcular o horário de término do evento.
   - Calcular quantos dias faltam para o evento,
     considerando a data atual.
   - Informar se o evento:
        • Já ocorreu
        • É hoje
        • Ainda vai acontecer

-----------------------------------------------------------
REGRAS OBRIGATÓRIAS:

Você DEVE utilizar:

- LocalDate
- LocalTime
- LocalDateTime
- DateTimeFormatter
- ChronoUnit.DAYS

-----------------------------------------------------------
EXEMPLO DE ENTRADA:

Data do evento (yyyy-MM-dd): 2026-03-10
Hora de início (HH:mm): 19:30
Duração (horas): 3

-----------------------------------------------------------
EXEMPLO DE SAÍDA:

Evento começa em: 10/03/2026 19:30
Evento termina em: 10/03/2026 22:30
Faltam 20 dias para o evento.
Status: Evento futuro.

OU

Status: Evento já ocorreu.

OU

Status: Evento é hoje!

-----------------------------------------------------------
DESAFIO EXTRA (OPCIONAL):

- Mostrar também quantas horas faltam para o evento.
- Criar uma classe chamada "Evento" com:
    • LocalDate data
    • LocalTime hora
    • int duracao

  E métodos:
    • getInicio()
    • getFim()
    • diasRestantes()
    • jaOcorreu()

===========================================================
*/


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DataEHora1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Data de inicio: yyyy-MM-dd");
        LocalDate dataEvento = LocalDate.parse(sc.nextLine());

        System.out.println("Hora de início: HH:mm");
        LocalTime horaEvento = LocalTime.parse(sc.nextLine());

        System.out.println("Horas de duraçao  (horas)");
        int duracao = sc.nextInt();

        //Criando LocalDateTime do evento
        LocalDateTime inicioEvento = LocalDateTime.of(dataEvento, horaEvento);

        //Quantas horas faltam para terminar
        LocalDateTime fimEvento = inicioEvento.plusHours(duracao);

        //Quantos dias faltam para o evento (considerando o dia atual)
        LocalDate dataAtual = LocalDate.now();
        double diasRestantes = ChronoUnit.DAYS.between(dataAtual, dataEvento);

        //Fomatar Data e Hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        System.out.println("Informaçoes do Evento");
        System.out.println("O evento começa em: " + inicioEvento.format(formatter));
        System.out.println("O evento termina em: " + fimEvento.format(formatter));

        if(diasRestantes < 0){
            System.out.println("O evento já ocorreu!");
        }else if(diasRestantes == 0){
            System.out.println("O evento é hoje!");
        }else{
            System.out.println("Faltam" + diasRestantes + " para o evento!");
        }
    }
}
