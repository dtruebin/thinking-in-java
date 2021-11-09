/*
Apply the regular expression
(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
to
"Arline ate eight apples and one orange while Anita hadn’t any"
 */

package icu.trub.tij.chapter13_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E11_RegexMatcherFind {
    public static void main(String[] args) {
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        Pattern p = Pattern.compile(regex);

        String input = "Arline ate eight apples and one orange while Anita hadn’t any";
        Matcher m = p.matcher(input);

        System.out.println("Matches:");
        while (m.find()) {
            System.out.format("* pos. %2d-%-2d: \"%s\"\n", m.start(), m.end() - 1, m.group());
        }
    }
}
