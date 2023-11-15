package ArturKuznetsov.lab5.task9;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlackListFilter implements IBlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        if (comments == null ||  comments.isEmpty()) {
            throw new InvalidTextException("Список комментариев не может быть пустым или равным null");
        }
        if ( blackList == null || blackList.isEmpty()) {
            throw new InvalidTextException("Чёрный список не может быть пустым или равным null");
        }

        int commentIndex = 0;
        while (commentIndex < comments.size()) {
            String comment = comments.get(commentIndex);

            if (comment == null) {
                comments.remove(commentIndex);
                continue;
            }

            for (String wordFromBlackList : blackList) {
                if (commentContainsWordFromBlackList(wordFromBlackList, comment)) {
                    comment = comment.replaceAll(wordFromBlackList, "*".repeat(wordFromBlackList.length()));
                }
            }

            comments.set(commentIndex, comment);

            commentIndex++;
        }
    }

    private boolean commentContainsWordFromBlackList(String wordFromBlackList, String comment) {
        String regex = "\\b" + wordFromBlackList + "\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(comment);

        return matcher.find();
    }
}
