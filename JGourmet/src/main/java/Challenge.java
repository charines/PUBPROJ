/**
 * Classe Classe de controle do formul�rio, possui a logica de negocio 
 * 
 * 
 * Laboratorio para validacao em aptidao JAVA 
 * 
 * @author Charles Rodrigues
 * @version 1.0, 2/2/2021
 * <pre>
 * https://www.linkedin.com/in/charlesrodrigues/
 * </pre>
 */


import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.ListPratos;
import model.Prato;

public class Challenge extends JGourmetFRM {

	private static final long serialVersionUID = 8610863398366577203L;

	private Prato massa = null;
	private Prato naoMassa = null;

	private ListPratos pratosMassa = new ListPratos();
	private ListPratos pratosNaoMassa = new ListPratos();

	private int resposta;

	private PropReaderHLP prop = PropReaderHLP.getInstance();

	public Challenge() {
		super();
		init();

	}

	/**
	 * 
	 * Inicializa o projeto
	 * 
	 */

	public void go() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println(prop.getValue("err_msg_1001"));
		}

		java.awt.EventQueue.invokeLater(() -> {
			new Challenge().setVisible(true);
		});
	}

	private void init() {
		massa = new Prato(prop.getValue("massa"), "");
		naoMassa = new Prato(prop.getValue("nao_massa"), "");

		this.pratosMassa.getPratos().add(massa);
		this.pratosNaoMassa.getPratos().add(naoMassa);

	}

	private void initJogo() {
		resposta = JOptionPane.showConfirmDialog(rootPane, prop.getValue("aka_20001"),
				prop.getValue("aka_IConfirm_btn_face"), JOptionPane.YES_NO_OPTION);

		if (resposta == JOptionPane.YES_OPTION) {
			advinharPratos(pratosMassa);
			return;
		}

		advinharPratos(pratosNaoMassa);
	}

	@Override
	protected void jBtOkActionPerformed(java.awt.event.ActionEvent evt) {
		setVisible(false);
		initJogo();
		setVisible(true);

	}

	private void advinharPratos(ListPratos pratos) {
		int contador;
		int tamanhoList = pratos.getPratos().size() - 1;

		for (contador = tamanhoList; contador > 0; contador--) {
			resposta = perguntaPrato(pratos, contador, true);

			if (resposta == JOptionPane.YES_OPTION) {

				resposta = perguntaPrato(pratos, contador, false);

				/*
				 * Se o prato apresentado for o que o usuário pensou apresento a mensagem de
				 * que acertei o prato que o mesmo pensou. Caso os pratos apresentados não
				 * forem o que o usuário pensou então é realizado o cadastro do novo prato
				 * pensado informando a descrição e característica do prato. exemplo:
				 * Pizza/Grande.
				 */
				if (resposta == JOptionPane.YES_OPTION) {

					acertei();
					break;
				} else if ((resposta == JOptionPane.NO_OPTION) && (contador == 0)) {

					adicionarPrato(pratos, contador);
					break;
				}
			}
		}

		/*
		 * O numero de op��es da lista esgotou entao significa que tenho que perguntar
		 * qual o prato que ele quer
		 */
		if (contador == 0) {

			resposta = perguntaPrato(pratos, contador, false);

			if (resposta == JOptionPane.YES_OPTION) {

				acertei();
				return;

			}

			adicionarPrato(pratos, contador);
		}
	}

	private void adicionarPrato(ListPratos pratos, int ordemPrato) {
		pratos.getPratos().add(montaObjetoPratoNovo(pratos, ordemPrato));
	}

	private void acertei() {
		JOptionPane.showMessageDialog(rootPane, prop.getValue("aka_ImRight"), prop.getValue("aka_ImRight_btn_face"),
				JOptionPane.INFORMATION_MESSAGE);
	}

	private int perguntaPrato(ListPratos pratos, int contador, boolean caracteristica) {
		if (caracteristica) {
			return JOptionPane
					.showConfirmDialog(
							rootPane, prop.getValue("aka_20002")
									.concat(pratos.getPratos().get(contador).getCaracteristica()).concat(" ?"),
							prop.getValue("aka_IConfirm_btn_face"), JOptionPane.YES_NO_OPTION);
		}

		return JOptionPane
				.showConfirmDialog(
						rootPane, prop.getValue("aka_20002").concat(" ")
								.concat(pratos.getPratos().get(contador).getDescricao()).concat(" ?"),
						prop.getValue("aka_IConfirm_btn_face"), JOptionPane.YES_NO_OPTION);
	}

	private Prato montaObjetoPratoNovo(ListPratos pratos, int ordemPrato) {
		String descricaoPrato = JOptionPane.showInputDialog(rootPane, prop.getValue("aka_20003"),
				prop.getValue("aka_IQuit_btn_face"), JOptionPane.QUESTION_MESSAGE);
		String caracteristicaPrato = JOptionPane.showInputDialog(rootPane,
				descricaoPrato.concat(prop.getValue("aka_eh")).concat(pratos.getPratos().get(ordemPrato).getDescricao())
						.concat(prop.getValue("aka_nao")),
				prop.getValue("aka_IComplete_btn_face"), JOptionPane.QUESTION_MESSAGE);

		Prato prato = new Prato(descricaoPrato, caracteristicaPrato);

		return prato;
	}

}
