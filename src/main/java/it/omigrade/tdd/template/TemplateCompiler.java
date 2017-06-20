package it.omigrade.tdd.template;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <br><br>Created by Omi087 on 16/06/2017.
 */
public class TemplateCompiler {

    private String template;
    private final Pattern pattern;

    public TemplateCompiler(String template) {
        this.template = template;
        String patternStr = "\\{\\{.[^\\{\\}]+\\}\\}";
        pattern = Pattern.compile(patternStr);
    }

    public String apply(Map<String, String> values) throws MissingParamsException {

        Matcher matcher = pattern.matcher(template);
        Map<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.putAll(values);

        StringBuffer sb = new StringBuffer(template.length());
        while (matcher.find()) {
            String paramName = template.substring(matcher.start(), matcher.end());
            paramName = paramName.substring(2, paramName.length()-2);

            String value = map.get(paramName);
            if (value != null)
                matcher.appendReplacement(sb, value);
            else
                throw new MissingParamsException();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public List<String> getParams() {
        Matcher matcher = pattern.matcher(template);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String paramName = template.substring(matcher.start(), matcher.end());
            paramName = paramName.substring(2, paramName.length()-2);
            list.add(paramName);
        }
        return list;
    }
}
