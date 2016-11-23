package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReversePolishCalculatorApp {

    private ReversePolishCalculatorView calcView =
            new ReversePolishCalculatorView(new Controller());
    private ReversePolishCalculatorModel calcModel =
            new ReversePolishCalculatorModel(calcView);

    class Controller implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("+") || button.getText().equals("-")
                || button.getText().equals("*") || button.getText().equals("/")) {
                    calcModel.calculate(button.getText());
                } else {
                    String intText = ((JButton) e.getSource()).getText();
                    if (calcModel.count() == 0) {
                        calcModel.setFirstNumber(Integer.parseInt(intText));
                    } else if (calcModel.count() == 1) {
                        calcModel.setSecondNumber(Integer.parseInt(intText));
                    }
                    calcView.printNumber(intText);
                }
            }
        }
    }

    public static void main(String[] args){
        new ReversePolishCalculatorApp();
    }

}
