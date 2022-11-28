package main;

import dominio.Aluno;
import dominio.Pessoa;
import dominio.Professor;
import exceptions.EmailInvalidoException;
import exceptions.NomeIncompletoException;
import java.util.Scanner;
import static auxiliar.Constante.QTD;
public class ControleAcademico {
    static Scanner in = new Scanner(System.in);
    private static int indice = 0;
    private static Pessoa[] pessoas;
    public static void main(String[] args) {

        pessoas = new Pessoa[QTD];
        String opcao;

        try {

            do {
                System.out.println("Sistema de controle acadêmico");
                System.out.println("Selecione uma das opções abaixo:");
                System.out.println("[1] Cadastrar professor.");
                System.out.println("[2] Cadastrar aluno.");
                System.out.println("[3] Consultar situação de um docente/discente.");
                System.out.println("[4] Sair");
                System.out.println("Informe a opção desejada:");
                opcao = in.next();

                switch (opcao) {
                    case "1":
                        try {
                            cadastrarProfessor();
                        } catch (EmailInvalidoException | NomeIncompletoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            cadastrarAluno();
                        } catch (EmailInvalidoException | NomeIncompletoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "3":
                        consultarDocenteDiscente();
                        break;
                    case "4":
                        System.out.println("Finalizar");
                        break;
                    default:
                        System.out.println("Opção inválica");
                        break;
                }
            } while (!opcao.equals("4"));

        } finally {
            in.close();
        }

    }

    private static void cadastrarProfessor() throws EmailInvalidoException, NomeIncompletoException {
        Professor professor = new Professor();

        System.out.println("Cadastrar Professor");
        if (indice < QTD) {
            System.out.println("Informe o nome do professor:");
            in.nextLine();
            professor.setNome(in.nextLine());

            int idade = recebeVariavelInt("Informe a idade do professor:");
            professor.setIdade(idade);

            System.out.println("Informe o e-mail do professor:");
            professor.setEmail(in.next());

            System.out.println("Informe a disciplina que do professor:");
            professor.setDisciplina(in.next());

            int cargaHoraria = recebeVariavelInt("Informe a carga horária do professor:");
            professor.setCargaHoraria(cargaHoraria);

            float valorHora = recebeVariavelFloat("Informe o valor hora do professor:");
            professor.setValorHora(valorHora);
            professor.setId(indice);

            pessoas[indice] = professor;
            System.out.println("Cadastro realizado:");
            pessoas[indice].imprimir();
            indice += 1;

        } else {
            System.out.println("Limite para cadastramento de pessoas atingido.");
        }
    }

    private static void cadastrarAluno() throws EmailInvalidoException, NomeIncompletoException {
        Aluno aluno = new Aluno();
        System.out.println("Cadastrar Aluno");
        if (indice < QTD) {
            System.out.println("Informe o nome do aluno:");
            in.nextLine();
            aluno.setNome(in.nextLine());

            int idade = recebeVariavelInt("Informe a idade do aluno:");
            aluno.setIdade(idade);

            System.out.println("Informe o e-mail do aluno:");
            aluno.setEmail(in.next());

            System.out.println("Informe o curso do aluno:");
            aluno.setCurso(in.next());

            boolean matriculado = recebeVariavelBoolean("Informe se o aluno está matriculado ou não (0 - não 1 - sim):");
            aluno.setMatriculado(matriculado);

            float valorMensalidade = recebeVariavelFloat("Informe o valor da mensalidade:");
            aluno.setValorMensalidade(valorMensalidade);
            aluno.setId(indice);
            pessoas[indice] = aluno;

            System.out.println("Cadastro realizado:");
            pessoas[indice].imprimir();
            indice += 1;

        } else {
            System.out.println("Limite para cadastramento de pessoas atingido.");
        }
    }

    private static int recebeVariavelInt(String texto) {
        String variavel;
        int variavelInt;
        while (true) {
            System.out.println(texto);
            variavel = in.next();
            try {
                variavelInt = Integer.parseInt(variavel);
                break;
            } catch (NumberFormatException e) {
                System.out.println("A informação deve ser um número inteiro.");
            }
        }
        return variavelInt;
    }

    private static float recebeVariavelFloat(String texto) {
        String variavel;
        float variavelFloat;
        while (true) {
            System.out.println(texto);
            variavel = in.next();
            try {
                variavelFloat = Float.parseFloat(variavel);
                break;
            } catch (NumberFormatException e) {
                System.out.println("A informação deve ser um número.");
            }
        }
        return variavelFloat;
    }

    private static boolean recebeVariavelBoolean(String texto) {
        String variavel;
        int variavelInt;
        boolean variavelBoolean;
        while (true) {
            System.out.println(texto);
            variavel = in.next();

            try {
                variavelInt = Integer.parseInt(variavel);
                if (variavelInt == 1) {
                    variavelBoolean = true;
                    break;
                } else {
                    if (variavelInt == 0) {
                        variavelBoolean = false;
                        break;
                    } else {
                        System.out.println("A informação deve ser 0 ou 1.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("A informação deve ser um número: 0 ou 1.");
            }
        }
        return variavelBoolean;
    }

    private static void consultarDocenteDiscente() {
        int pos = indice + 1;
        while (pos > indice) {
            pos = recebeVariavelInt("Informe a posição que deseja visualizar:");
        }
        pessoas[pos].imprimir();
    }
}