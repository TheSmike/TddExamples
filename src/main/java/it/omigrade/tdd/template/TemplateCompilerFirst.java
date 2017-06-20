package it.omigrade.tdd.template;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <br><br>Created by Omi087 on 16/06/2017.
 */
public class TemplateCompilerFirst {

    private String selectTemplate;

    public TemplateCompilerFirst(String selectTemplate) {
        this.selectTemplate = selectTemplate;
    }

    public int getDistinctParamsNumber(String template) {
        String patternStr = "\\{\\{.[^\\{\\}]+\\}\\}";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(template);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String apply(Map<String, String> values) {
        return selectTemplate;
    }
}
