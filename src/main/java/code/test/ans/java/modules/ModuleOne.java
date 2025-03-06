package code.test.ans.java.modules;

public class ModuleOne {
    public int firstUniqChar(String s) {
        // 文字の出現回数をカウントするためのハッシュマップ
        int[] count = new int[26]; // アルファベットの数（a-z）
        
        // 1回目の走査: 各文字の出現回数を数える
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 2回目の走査: 出現回数が1回の最初の文字を見つける
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // ユニークな文字がない場合
        return -1;
    }
}