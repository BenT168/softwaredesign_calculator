package ic.doc;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReversePolishCalculatorView implements Updatable {

    private ArrayList<JButton> buttons = new ArrayList<>();
    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton multiply = new JButton("*");
    private final JButton divide = new JButton("/");
    private final JTextField textField = new JTextField(30);

    public ReversePolishCalculatorView(ActionListener controller){
        JFrame frame = new JFrame("Reverse Polish Calculator");
        frame.setSize(400, 250);
        for(int i = 0; i < 9; i++) {
            buttons.add(new JButton("" + (i +1)));
        }
        buttons.add(plus);
        buttons.add(minus);
        buttons.add(multiply);
        buttons.add(divide);
        JPanel panel = new JPanel();
        panel.add(textField);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).addActionListener(controller);
            panel.add(buttons.get(i));
        }
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    @Override
    public void printNumber(String s) {
        textField.setText(s);
    }

    public void update(ReversePolishCalculatorModel calcModel){
        if(calcModel.resultIsReady()){
            textField.setText(String.valueOf(calcModel.getResult()));
        } else {
            switch (calcModel.count()) {
                case 2 :
                    buttonReference();
                    return;
                default :
                    textField.setText("Please insert 2 inputs for calculation");
                    setOperatorButtons(false);
            }
        }
    }

    private void buttonReference() {
        for (int i = 0; i < buttons.size(); i++) {
            JButton button = buttons.get(i);
            if (!(button.getText().equals("plus")
                    || button.getText().equals("minus")
                    || button.getText().equals("multiply")
                    || button.getText().equals("divide"))) {
                button.setEnabled(false);
                setOperatorButtons(true);
            }
        }
    }

    public void setOperatorButtons(boolean operatorButtons) {
        plus.setEnabled(operatorButtons);
        minus.setEnabled(operatorButtons);
        multiply.setEnabled(operatorButtons);
        divide.setEnabled(operatorButtons);
    }
}
