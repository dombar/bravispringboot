package br.com.bravi.service.Impl;

import br.com.bravi.service.BalancedService;
import com.google.common.primitives.Chars;
import org.springframework.stereotype.Service;

@Service
public class BalancedServiceImpl implements BalancedService {

    private static final char[] initCombination = {'{', '[', '('};
    private static final char[] finalCombination = {')', ']', '}'};
    private static final char[] initBracket = {'['};
    private static final char[] finalBracket = {']'};
    private static final char[] initParentheses = {'('};
    private static final char[] finalParentheses = {')'};
    private static final char[] initKeys = {'{'};
    private static final char[] finalKeys = {'}'};

    @Override
    public String balanced(String text) {

        String reg = text.replaceAll("[^a-zA-Z0-9]+", "");
        if (!reg.isEmpty()) {
            return "is not valid";
        }

        return isBlanced(text.toCharArray()) ? "is valid" : "is not valid";
    }

    private static boolean isBlanced(char[] text) {
        int count = 0;
        char[] result = new char[100];
        for (char c : text) {

            if (Chars.contains(initCombination, c)) {
                result[count++] = c;
                continue;
            }

            if (Chars.contains(finalCombination, c)) {

                if (isResultEmpty(result)) {
                    return false;
                }

                if (!checkPair(result[--count], c)) {
                    return false;
                }
            }

        }

        return count == 0;

    }

    private static boolean isResultEmpty(char[] result) {
        return result[0] == '\u0000';
    }

    private static boolean checkPair(char char1, char char2) {

        if (Chars.contains(initBracket, char1) && Chars.contains(finalBracket, char2)) {
            return true;
        }

        if (Chars.contains(initKeys, char1) && Chars.contains(finalKeys, char2)) {
            return true;
        }

        return Chars.contains(initParentheses, char1) && Chars.contains(finalParentheses, char2);

    }

}
