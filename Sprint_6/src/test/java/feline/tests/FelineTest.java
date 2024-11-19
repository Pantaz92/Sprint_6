package feline.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


import static core.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline = new Feline();

    @Test
    public void testGetKittensReturnsOne() {
        int actualKittensCount = feline.getKittens();
        Mockito.verify(feline).getKittens(DEFAULT_KITTENS_COUNT_ONE);
        assertEquals(DEFAULT_KITTENS_COUNT_ONE, actualKittensCount);
    }

    @Test
    public void testGetFamilyReturnsCats() {
        String actualFelineFamily = feline.getFamily();
        assertEquals(FELINE_FAMILY_CATS, actualFelineFamily);
    }

    @Test
    public void testEatMeatForFelineReturnsPredatorFood() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(PREDATOR_FOOD);
        List<String> actualFelineFood = feline.eatMeat();
        Mockito.verify(feline).getFood(PREDATOR);
        assertEquals(PREDATOR_FOOD, actualFelineFood);
    }
}
