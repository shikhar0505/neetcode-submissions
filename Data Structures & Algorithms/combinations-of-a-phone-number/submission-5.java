class Solution {
    Map<Character, Set<Character>> map = Map.of(
        '2', Set.of('a','b','c'),
        '3', Set.of('d','e','f'),
        '4', Set.of('g','h','i'),
        '5', Set.of('j','k','l'),
        '6', Set.of('m','n','o'),
        '7', Set.of('p','q','r','s'),
        '8', Set.of('t','u','v'),
        '9', Set.of('w','x','y','z')
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        dfs(result, digits, "", 0);
        return result;
    }

    private void dfs(List<String> result, String digits, String curr, int i) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }

        Set<Character> chars = map.get(digits.charAt(i));
        for (char c : chars) {
            dfs(result, digits, curr + c, i + 1);
        }
    }
}