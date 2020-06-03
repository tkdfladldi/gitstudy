package swingsample.combobox;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class ExchangeCalc extends JFrame implements ActionListener {
	private static float USD = 1225.60F;
	private static float JPY = 1137.92F;
	private static float EUR = 1363.66F;
	private static float CNY = 171.89F;

	JComboBox<String> combo;
	String[] money = { "달러", "엔", "유로", "위안" };
	JPanel pane1, pane2;
	JLabel lbl;
	JTextField txt;
	JButton btn;

	public ExchangeCalc() {
		
		setTitle("환율 계산기");
		pane1 = new JPanel();
		pane2 = new JPanel();
		
		txt = new JTextField(11);
		combo = new JComboBox<>(money);
		btn = new JButton("변환");
		lbl = new JLabel("변환 결과"); // pane2

		getContentPane().setLayout(new FlowLayout());
		pane1.add(new JLabel("원화"));
		pane1.add(txt);
		pane1.add(combo);
		pane1.add(btn);

		pane2.add(lbl);

		getContentPane().add(pane1, "North"); // 자리 배치 (BorderLayout)
		getContentPane().add(pane2, "Center"); // 자리 배치 (BorderLayout)

		setBounds(300, 300, 400, 200); // x좌표 , y좌표 , width, height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		btn.addActionListener(this);
	}

	public static void main(String[] args) {
		new ExchangeCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		calculate();
	}

	public void calculate() {
		float won = Float.parseFloat(txt.getText()); // 입력된 문자를 실수로 변환
		String result = null;
		String money = combo.getSelectedItem().toString(); // 문자 형식
		
		if (money.equals("달러")) {
			result = String.format("%.2f", won/USD);
		} else if (money.equals("엔")) {
			result = String.format("%.2f", won/JPY);
        } else if (money.equals("유로")) {
			result = String.format("%.2f", won/EUR);
		} else if (money.equals("위안")) {
			result = String.format("%.2f", won/CNY);
		}
		lbl.setText(result);

	}
}
