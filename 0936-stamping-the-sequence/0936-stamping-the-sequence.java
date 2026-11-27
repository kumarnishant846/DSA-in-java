import java.util.*;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int m = stamp.length();
        int n = target.length();

        char[] arr = target.toCharArray();
        boolean[] visited = new boolean[n - m + 1];

        List<Integer> result = new ArrayList<>();

        int stars = 0;

        while (stars < n) {
            boolean changed = false;

            for (int i = 0; i <= n - m; i++) {
                if (visited[i]) {
                    continue;
                }

                boolean match = true;
                int count = 0;

                for (int j = 0; j < m; j++) {
                    if (arr[i + j] == '?') {
                        count++;
                    } else if (arr[i + j] != stamp.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match && count < m) {
                    visited[i] = true;

                    for (int j = 0; j < m; j++) {
                        if (arr[i + j] != '?') {
                            arr[i + j] = '?';
                            stars++;
                        }
                    }

                    result.add(i);
                    changed = true;
                }
            }

            if (!changed) {
                return new int[0];
            }
        }

        Collections.reverse(result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}