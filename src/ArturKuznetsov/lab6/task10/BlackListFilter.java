package ArturKuznetsov.lab6.task10;

import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlackListFilter implements IBlackListFilter<String>{
    public Predicate<String> createPredicate(Set<String> blackList) {
        return str -> {
            if (str == null) {
                return false;
            }

            for (String wordFromBlackList : blackList) {
                if (commentContainsWordFromBlackList(wordFromBlackList, str)) {
                    return false;
                }
            }

            return true;
        };
    }

    private boolean commentContainsWordFromBlackList(String wordFromBlackList, String comment) {
        String regex = "\\b" + wordFromBlackList + "\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(comment);

        return matcher.find();
    }

}
