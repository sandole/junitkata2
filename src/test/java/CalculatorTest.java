import Calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void sumsEmptyString(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("")).isEqualTo(0);
    }

    @Test
    public void sumsSingleNumber(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("5")).isEqualTo(5);
    }

    @Test
    public void sumsTwoNumbers(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    public void sumsManyNumbers(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("1,2,3,4,5,6,7,8")).isEqualTo(36);
    }

    @Test
    public void cannotEndWithComma(){
        Calculator calculator = new Calculator();
        Assertions.assertThatThrownBy(() -> Calculator.sum("1,2,")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void sumsNumbersWithNewDelimiter(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("1\n2,3")).isEqualTo(6);
    }

    @Test
    public void sumsNumbersWithCustomDelimiter(){
        Calculator calculator = new Calculator();
        Assertions.assertThat(Calculator.sum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    public void cannotContainNegativeNumbers(){
        Calculator calculator = new Calculator();
        Assertions.assertThatThrownBy(() -> Calculator.sum("1,-2,3,-4")).isInstanceOf(IllegalArgumentException.class);
    }
}
