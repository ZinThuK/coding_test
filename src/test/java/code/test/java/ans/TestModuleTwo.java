package code.test.java.ans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import code.test.ans.java.modules.ModuleTwo;

public class TestModuleTwo {

    // 配列とkを使って、k番目に大きい要素を正しく取得できるか確認するテストケース
    @Test
    public void testFindKthLargest() {
        ModuleTwo module = new ModuleTwo();
        
        // サンプル入力
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        // 配列を降順にソートした場合、[6, 5, 4, 3, 2, 1] となる
        // 2番目に大きい要素は 5 であることを確認
        int result = module.findKthLargest(nums, k);
        
        // 結果が期待通りであることを確認
        assertEquals(5, result);  // 2番目に大きい要素は 5
    }

    // もう1つのテストケース - k番目に大きい要素を取得
    @Test
    public void testFindKthLargest_AnotherCase() {
        ModuleTwo module = new ModuleTwo();
        
        // サンプル入力
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        
        // 配列を降順にソートした場合、[6, 5, 5, 4, 3, 3, 2, 2, 1] となる
        // 4番目に大きい要素は 4 であることを確認
        int result = module.findKthLargest(nums, k);
        
        // 結果が期待通りであることを確認
        assertEquals(4, result);  // 4番目に大きい要素は 4
    }

    // 配列に1つしか要素がない場合
    @Test
    public void testFindKthLargest_SingleElement() {
        ModuleTwo module = new ModuleTwo();
        
        // サンプル入力（配列に1つしか要素がない場合）
        int[] nums = {10};
        int k = 1;
        
        // 配列に1つしか要素がないので、その要素がk番目に大きい要素となる
        int result = module.findKthLargest(nums, k);
        
        // 結果が期待通りであることを確認
        assertEquals(10, result);  // 1番目に大きい要素は 10
    }

    // 配列が負の数を含んでいる場合
    @Test
    public void testFindKthLargest_NegativeNumbers() {
        ModuleTwo module = new ModuleTwo();
        
        // サンプル入力（負の数を含む配列）
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 2;
        
        // 配列を降順にソートした場合、[-1, -2, -3, -4, -5] となる
        // 2番目に大きい要素は -2 であることを確認
        int result = module.findKthLargest(nums, k);
        
        // 結果が期待通りであることを確認
        assertEquals(-2, result);  // 2番目に大きい要素は -2
    }

    // 配列がすでに降順にソートされている場合
    @Test
    public void testFindKthLargest_SortedDescending() {
        ModuleTwo module = new ModuleTwo();
        
        // サンプル入力（すでに降順にソートされている配列）
        int[] nums = {6, 5, 4, 3, 2, 1};
        int k = 3;
        
        // 配列はすでに降順にソートされているので、3番目に大きい要素は 4 であることを確認
        int result = module.findKthLargest(nums, k);
        
        // 結果が期待通りであることを確認
        assertEquals(4, result);  // 3番目に大きい要素は 4
    }
}
