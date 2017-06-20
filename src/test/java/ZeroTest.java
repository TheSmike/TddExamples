import it.omigrade.tdd.counter.WordCounter;
import org.junit.Assert;
import org.junit.Test;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class ZeroTest {

    private static final String WORD1 = "Ciao, come stai?";

    @Test
    public void countWords() throws Exception {

        int counter = WordCounter.count(WORD1);
        Assert.assertEquals(3, counter);
    }

}
