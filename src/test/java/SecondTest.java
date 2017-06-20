import it.omigrade.tdd.template.MissingParamsException;
import it.omigrade.tdd.template.TemplateCompiler;
import it.omigrade.tdd.template.TemplateCompilerFirst;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br><br>Created by Omi087 on 16/06/2017.
 */

public class SecondTest {

    public static final String SELECT_TEMPLATE = "Select {{col1}} from tb1 where {{param1}} = {{value1}}";
    private TemplateCompiler sut;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        sut = new TemplateCompiler(SELECT_TEMPLATE);
    }

    @Test
    public void applyCorrectMatch() throws Exception {

        Map<String, String> values = new HashMap<>();
        values.put("col1", "NOME");
        values.put("param1", "ID");
        values.put("value1", "123");

        String appliedTemplate = sut.apply(values);
        Assert.assertEquals("Select NOME from tb1 where ID = 123", appliedTemplate);
    }

    @Test
    public void applyUncorrectMatch() throws Exception {
        exception.expect(MissingParamsException.class);
        exception.expectMessage("Almeno un parametro non è stato valorizzato");

        Map<String, String> values = new HashMap<>();
        values.put("col1", "NOME");
        values.put("param1", "ID");
        values.put("param2", "123");

        sut.apply(values);
    }

    @Test
    public void testCaseUnsensitive() throws Exception {
        Map<String, String> values = new HashMap<>();
        values.put("Col1", "NOME");
        values.put("Param1", "PROVINCIA");
        values.put("Value1", "'PR'");

        String appliedTemplate = sut.apply(values);
        Assert.assertEquals("Select NOME from tb1 where PROVINCIA = 'PR'", appliedTemplate);

    }

    @Test
    public void readParams() throws Exception {
        List<String> params = sut.getParams();
        Assert.assertEquals(3, params.size());
        Assert.assertEquals("col1", params.get(0));
        Assert.assertEquals("param1", params.get(1));
        Assert.assertEquals("value1", params.get(2));
    }
}
