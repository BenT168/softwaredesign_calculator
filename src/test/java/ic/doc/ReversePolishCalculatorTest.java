package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


public class ReversePolishCalculatorTest {

    private static final int FIRST_NUMBER = 1;
    private static final int SECOND_NUMBER = 2;

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Updatable calcView = context.mock(Updatable.class);
    private ReversePolishCalculatorModel calcModel =
            new ReversePolishCalculatorModel(calcView);

    @Test
    public void pressingFirstNumberPrintsNumber(){
        context.checking(new Expectations() {{
            exactly(1).of(calcView).update(calcModel);
        }});
        calcModel.setFirstNumber(FIRST_NUMBER);
    }

    @Test
    public void pressingSecondNumberPrintsNumber(){
        context.checking(new Expectations() {{
            exactly(2).of(calcView).update(calcModel);
        }});
        calcModel.setFirstNumber(FIRST_NUMBER);
        calcModel.setSecondNumber(SECOND_NUMBER);
    }

    @Test
    public void pressingCalculatePrintsResult(){
        context.checking(new Expectations() {{
            exactly(3).of(calcView).update(calcModel);
        }});
        calcModel.setFirstNumber(FIRST_NUMBER);
        calcModel.setSecondNumber(SECOND_NUMBER);
        calcModel.calculate("+");
    }


}
