package exemploDadosCRUD_aula05082022;

import java.util.Date;
import java.util.Scanner;

import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.ContatoModel;

public class AppContatosCRUD {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Scanner entrada = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("Escolha uma opção: \n 1. Listar | 2. Incluir"
												+ " | 3. Excluir | 0. Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();
			switch (opcao) {
			case 1:
				System.out.println("\t Lista de Contatos");
				for (ContatoModel c : dao.getContatoModel()) {
					System.out.println(c.getId() + " - " + c.getNome());
					System.out.println("Idade: " + c.getIdade());
					System.out.println("-----------------------------");
				}
				System.out.println("\t Fim da Lista \n");
				break;
			case 2:
				ContatoModel c = new ContatoModel();
				System.out.println("Nome: ");
				c.setNome(entrada.nextLine());
				System.out.println("Idade: ");
				c.setIdade(entrada.nextInt());
				System.out.println();
				c.setDataCadastro(new Date());
				dao.save(c);
				break;
			case 3:
				System.out.println("Qual o ID?");
				int id = entrada.nextInt();
				System.out.println();
				dao.removeById(id);
				break;
			}
		} while (opcao != 0);
		entrada.close();
	}
} 