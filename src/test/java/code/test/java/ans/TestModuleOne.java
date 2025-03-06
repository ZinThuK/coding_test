package code.test.java.ans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import code.test.ans.java.modules.ModuleOne;

public class TestModuleOne {

    // 最初のユニークな文字が存在する場合のテストケース
    @Test
    public void testFirstUniqChar_WithUniqueChar() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力
        String input = "leetcode";
        
        // 'l' は最初のユニークな文字であり、インデックス0にある
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(0, result);  // 'l' のインデックスは 0
    }

    // 最初のユニークな文字が他の位置に存在する場合のテストケース
    @Test
    public void testFirstUniqChar_AnotherUniqueChar() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力
        String input = "loveleetcode";
        
        // 'v' は最初のユニークな文字であり、インデックス2にある
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(2, result);  // 'v' のインデックスは 2
    }

    // ユニークな文字が存在しない場合のテストケース
    @Test
    public void testFirstUniqChar_NoUniqueChar() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力
        String input = "aabb";
        
        // ユニークな文字がないので -1 が返されることを確認
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(-1, result);  // ユニークな文字は存在しないので -1
    }

    // 文字列が空の場合のテストケース
    @Test
    public void testFirstUniqChar_EmptyString() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力（空の文字列）
        String input = "";
        
        // 空の文字列ではユニークな文字がないので -1 が返されることを確認
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(-1, result);  // 空の文字列では -1
    }

    // 1文字だけの文字列の場合のテストケース
    @Test
    public void testFirstUniqChar_SingleCharacter() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力（1文字）
        String input = "a";
        
        // 1文字の文字列ではその文字がユニークであり、インデックス0が返される
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(0, result);  // 'a' のインデックスは 0
    }

    // 同じ文字が繰り返し登場する場合のテストケース
    @Test
    public void testFirstUniqChar_AllSameChar() {
        ModuleOne module = new ModuleOne();
        
        // サンプル入力（同じ文字が繰り返し）
        String input = "bbbbbb";
        
        // ユニークな文字がないので -1 が返されることを確認
        int result = module.firstUniqChar(input);
        
        // 結果が期待通りであることを確認
        assertEquals(-1, result);  // ユニークな文字は存在しないので -1
    }
}
