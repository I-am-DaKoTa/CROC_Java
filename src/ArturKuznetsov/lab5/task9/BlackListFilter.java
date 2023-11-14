package ArturKuznetsov.lab5.task9;


import java.util.HashSet;
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

            Set<String> newBlackList = new HashSet<>();
            for (String wordFromBlackList : blackList) {
                if (commentContainsWordFromBlackList(wordFromBlackList, comment)) {
                    newBlackList.add(wordFromBlackList);
                }
            }

            if (newBlackList.isEmpty()) {
                commentIndex++;
                continue;
            }

            comments.set(commentIndex, String.valueOf(checkWordsInComment(newBlackList, comment)));
            commentIndex++;
        }
    }

    private boolean commentContainsWordFromBlackList(String wordFromBlackList, String comment) {
        String regex = "\\b" + wordFromBlackList + "\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(comment);

        return matcher.find();
    }

    private StringBuilder checkWordsInComment(Set<String> newBlackList, String comment) {
        String regex = "[.,!?:;\\-\"'()\\s]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(comment);

        StringBuilder replacedComment = new StringBuilder();

        int start = 0;
        while (matcher.find()) {
            int end = matcher.start();
            if (end > start) {
                String wordFromComment = comment.substring(start, end);

                if (!isWordFromBlackList(newBlackList, wordFromComment, replacedComment)) {
                    replacedComment.append(wordFromComment);
                }

            }
            String match = matcher.group();
            replacedComment.append(match);
            start = matcher.end();
        }

        if (start < comment.length()) {
            String wordFromComment = comment.substring(start);
            replacedComment.append(wordFromComment);
        }

        return replacedComment;
    }

    private boolean isWordFromBlackList(Set<String> blackList, String wordFromComment, StringBuilder verifiedComment) {
        for (String word : blackList) {
            if (wordFromComment.equalsIgnoreCase(word)) {
                verifiedComment.append(replaceWithStars(wordFromComment));
                return true;
            }
        }
        return false;
    }

    private String replaceWithStars(String word) {
        return "*".repeat(word.length());
    }
}
