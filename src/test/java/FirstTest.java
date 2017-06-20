import it.omigrade.tdd.template.TemplateCompilerFirst;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <br><br>Created by Omi087 on 16/06/2017.
 */

public class FirstTest {

    public static final String SELECT_TEMPLATE = "Select {{col1}} from tb1 where {{param1}} = {{value1}}";

    @Test
    public void getParamsList() throws Exception {
        TemplateCompilerFirst sut = new TemplateCompilerFirst(SELECT_TEMPLATE);
        Map<String, String> values = new HashMap<>();
        values.put("col1", "NOME");
        values.put("param1", "ID");
        values.put("param2", "123");

        String appliedTemplate = sut.apply(values);
        Assert.assertEquals("Select NOME from tb1 where ID = 123", appliedTemplate);
    }


}
