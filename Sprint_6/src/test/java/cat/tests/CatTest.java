package cat.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static core.Constants.EXPECTED_CAT_FOOD;
import static core.Constants.CAT_SOUND_MEW;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetSoundReturnMew() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertEquals(CAT_SOUND_MEW, actualSound);
    }

    @Test
    public void testCatGetFoodReturnExpectedCatFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(EXPECTED_CAT_FOOD);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertThat(actualFood, is(EXPECTED_CAT_FOOD));
    }
}
