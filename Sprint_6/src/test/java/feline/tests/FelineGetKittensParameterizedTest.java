package feline.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class FelineGetKittensParameterizedTest {
    private final int inputKittensCount;
    private final int expectedKittenCount;

    public FelineGetKittensParameterizedTest(int inputKittensCount, int expectedKittenCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittenCount = expectedKittenCount;
    }

    @Parameterized.Parameters(name = "Набор данных {index}: inputKittensCount={0}, expectedKittenCount={1}")
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {0, 0},
                {3, 3},
                {5, 5},
                {10, 10}
        };
    }

    @Test
    public void felineGetKittensDifferentCount() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(inputKittensCount);
        assertThat(actualKittensCount, is(expectedKittenCount));
    }
}
