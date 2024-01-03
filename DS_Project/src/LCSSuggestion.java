 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCSSuggestion {

    public ArrayList<Character> longestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        ArrayList<Character> lcs = new ArrayList<>();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.add(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        Collections.reverse(lcs);
        return lcs;
    }
    
    private String lcsResult(String X, String Y) {
        List<Character> lcs = longestCommonSubsequence(X, Y);

        StringBuilder result = new StringBuilder();
        for (Character ch : lcs) {
            result.append(ch);
        }

        return result.toString();
    }
    public  ArrayList<String> keywordSuggestions(ArrayList<String> titleList) {
        ArrayList<String> result = new ArrayList<>();

        if (titleList.isEmpty()) {
            return result;
        }

        String lcsResult = titleList.get(0);

        for (int i = 1; i < titleList.size(); i++) {
            lcsResult = lcsResult(lcsResult, titleList.get(i));
        }

        // 將每個標題與LCS進行比較，並將相同的字符添加到結果列表中
        for (String title : titleList) {
            ArrayList<Character> titleLCS = longestCommonSubsequence(lcsResult, title);
            StringBuilder suggestedKeyword = new StringBuilder();
            for (Character ch : titleLCS) {
                suggestedKeyword.append(ch);
            }
            result.add(suggestedKeyword.toString());
        }

        return result;
    }

}