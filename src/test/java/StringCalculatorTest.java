import Calculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void sumsEmptyString(){
        Assertions.assertThat(StringCalculator.sum("")).isEqualTo(0);
    }

    @Test
    public void sumsSingleNumber(){
        Assertions.assertThat(StringCalculator.sum("5")).isEqualTo(5);
    }

    @Test
    public void sumsTwoNumbers(){
        Assertions.assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    public void sumsManyNumbers(){
        Assertions.assertThat(StringCalculator.sum("1,2,3,4,5,6,7,8")).isEqualTo(36);
    }

    @Test
    public void cannotEndWithComma(){
        Assertions.assertThatThrownBy(() -> StringCalculator.sum("1,2,")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void sumsNumbersWithNewDelimiter(){
        Assertions.assertThat(StringCalculator.sum("1\n2,3")).isEqualTo(6);
    }

    @Test
    public void sumsNumbersWithCustomDelimiter(){
        Assertions.assertThat(StringCalculator.sum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    public void cannotContainNegativeNumbers(){
        Assertions.assertThatThrownBy(() -> StringCalculator.sum("1,-2,3,-4")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ignoresNumbersGreaterThan1000(){
        Assertions.assertThat(StringCalculator.sum("2,1001")).isEqualTo(2);
    }
}
