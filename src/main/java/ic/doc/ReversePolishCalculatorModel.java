package ic.doc;

public class ReversePolishCalculatorModel {
    private final Updatable calcView;
    private double result;
    private int count;
    private double firstNumber;
    private double secondNumber;
    private static boolean resultIsReady;

    public ReversePolishCalculatorModel(Updatable calcView) {
        this.calcView = calcView;
    }

    public void calculate(String op) {
        switch (op) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }
        resultIsReady = true;
        calcView.update(this);
    }

    public int count() {
        return count;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
        count++;
        calcView.update(this);
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
        count++;
        calcView.update(this);
    }


    public boolean resultIsReady() {
        return  resultIsReady;
    }

    public String getResult() {
        if (result == Math.rint(result)){
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }

}
