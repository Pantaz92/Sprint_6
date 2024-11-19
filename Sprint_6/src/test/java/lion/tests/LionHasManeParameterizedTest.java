package lion.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class LionHasManeParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionHasManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Набор данных {index}: inputSex={0}, expectedHasMane={1}")
    public static Object[][] getSex() {
        return new Object[][] {
            {"Самец", true},
            {"Самка", false}
        };
    }

    @Test
    public void isLionHaveMane() throws Exception{
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, sex);
        assertThat(lion.doesHaveMane(), is(expectedHasMane));
    }
}