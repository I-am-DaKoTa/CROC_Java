package ArturKuznetsov.lab5.task9;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlackListFilter implements IBlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        String regex = "[.,!?:;\\-\"'()\\s]+";
        Pattern pattern = Pattern.compile(regex);
        int commentIndex = 0;
        while (commentIndex < comments.size()) {
            try {
                if (comments.get(commentIndex) == null) {
                    throw new InvalidTextException("Сообщение не может быть равным null");
                }
            } catch (InvalidTextException e) {
                System.out.println(e.getMessage());
                comments.remove(commentIndex);
                continue;
            }

            String comment = comments.get(commentIndex);
            StringBuilder verifiedComment = new StringBuilder();

            Matcher matcher = pattern.matcher(comment);
            int start = 0;
            while (matcher.find()) {
                int end = matcher.start();
                if (end > start) {
                    String wordFromComment = comment.substring(start, end);
                    if (!containsWordFromBlackList(blackList, wordFromComment, verifiedComment)) {
                        verifiedComment.append(wordFromComment);
                    }
                }
                String match = matcher.group();
                verifiedComment.append(match);
                start = matcher.end();
            }

            if (start < comment.length()) {
                String wordFromComment = comment.substring(start);
                verifiedComment.append(wordFromComment);
            }

            comments.set(commentIndex, String.valueOf(verifiedComment));
            commentIndex++;
        }
    }
    private String replaceWithStars(String word) {
        char[] stars = new char[word.length()];
        Arrays.fill(stars, '*');
        return new String(stars);
    }

    private boolean containsWordFromBlackList(Set<String> blackList, String wordFromComment, StringBuilder verifiedComment) {
        for (String word : blackList) {
            if (wordFromComment.equalsIgnoreCase(word)) {
                verifiedComment.append(replaceWithStars(wordFromComment));
                return true;
            }
        }
        return false;
    }
}
