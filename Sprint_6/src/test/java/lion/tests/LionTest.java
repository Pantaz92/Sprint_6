package lion.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static core.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testLionThrowsExceptionForInvalidSex() {
        try {
            Lion lion = new Lion(feline, INVALID_SEX);
            lion.doesHaveMane();
            fail("Исключение не выброшено");
        } catch (Exception exception) {
            assertEquals(EXPECTED_EXCEPTION, exception.getMessage());
        }
    }

    @Test
    public void testEatMeatForLionReturnsPredatorFood() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(PREDATOR_FOOD);
        Lion lion = new Lion(feline, MALE_SEX);
        List<String> actualLionFood = lion.getFood();
        Mockito.verify(feline).getFood(PREDATOR);
        assertEquals(PREDATOR_FOOD, actualLionFood);
    }

    @Test
    public void testGetKittensForLionReturnsCorrectValue() throws Exception{
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_COUNT_FIVE);
        Lion lion = new Lion(feline, MALE_SEX);
        int actualKittensCount = lion.getKittens();
        Mockito.verify(feline).getKittens();
        assertEquals(KITTENS_COUNT_FIVE, actualKittensCount);
    }
}
