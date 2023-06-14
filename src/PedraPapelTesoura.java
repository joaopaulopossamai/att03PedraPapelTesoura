import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PedraPapelTesoura extends JFrame {
    private JRadioButton PedraButton;
    private JRadioButton PapelButton;
    private JRadioButton TesouraButton;
    private JButton jogarButton;
    public PedraPapelTesoura() {
        setTitle("Pedra, Papel, Tesoura");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PedraButton = new JRadioButton("Pedra");
        PapelButton = new JRadioButton("Papel");
        TesouraButton = new JRadioButton("Tesoura");
        jogarButton = new JButton("Jogar");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(PedraButton);
        buttonGroup.add(PapelButton);
        buttonGroup.add(TesouraButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(PedraButton);
        radioPanel.add(PapelButton);
        radioPanel.add(TesouraButton);

        add(radioPanel, BorderLayout.CENTER);
        add(jogarButton, BorderLayout.SOUTH);

        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogar();
            }
        });
    }

    private void jogar() {
        if (PedraButton.isSelected()) {
            exibirResultado("Pedra");
        } else if (PapelButton.isSelected()) {
            exibirResultado("Papel");
        } else if (TesouraButton.isSelected()) {
            exibirResultado("Tesoura");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma opção.");
        }
    }

    private void exibirResultado(String escolhaUsuario) {
        String escolhaComputador = obterEscolhaComputador();
        String resultado = determinarResultado(escolhaUsuario, escolhaComputador);
        JOptionPane.showMessageDialog(this, "Escolha do computador: " + escolhaComputador + "\nResultado: " + resultado);
    }

    private String obterEscolhaComputador() {
        Random random = new Random();
        int escolha = random.nextInt(3);
        switch (escolha) {
            case 0:
                return "Pedra";
            case 1:
                return "Papel";
            case 2:
                return "Tesoura";
            default:
                return "";
        }
    }

    private String determinarResultado(String escolhaUsuario, String escolhaComputador) {
        if (escolhaUsuario.equals(escolhaComputador)) {
            return "Empate!";
        } else if ((escolhaUsuario.equals("Pedra") && escolhaComputador.equals("Tesoura")) ||
                (escolhaUsuario.equals("Papel") && escolhaComputador.equals("Pedra")) ||
                (escolhaUsuario.equals("Tesoura") && escolhaComputador.equals("Papel"))) {
            return "Você ganhou!";
        } else {
            return "Você perdeu!";
        }
    }
}

