class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] a = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            a[i] = new StringBuilder();

        int r = 0, d = 1;

        for (char c : s.toCharArray()) {
            a[r].append(c);
            if (r == 0) d = 1;
            if (r == numRows - 1) d = -1;
            r += d;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder x : a) ans.append(x);

        return ans.toString();
    }
}