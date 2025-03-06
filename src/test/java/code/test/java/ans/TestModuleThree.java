package code.test.java.ans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import code.test.ans.java.modules.ListNode;
import code.test.ans.java.modules.ModuleThree;

public class TestModuleThree {

    // サイクルがあるリストを作成するためのヘルパーメソッド
    private ListNode createListWithCycle() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // リストを作成: 3 -> 2 -> 0 -> -4 -> 2 (サイクル)
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // サイクルを作成 (4 -> 2)

        return node1;
    }

    // サイクルがないリストを作成するためのヘルパーメソッド
    private ListNode createListWithoutCycle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        // リストを作成: 1 -> 2
        node1.next = node2;

        return node1;
    }

    // サイクルがあるリストでサイクルの開始ノードを検出するテストケース
    @Test
    public void testDetectCycle_WithCycle() {
        ModuleThree module = new ModuleThree();
        ListNode head = createListWithCycle();

        ListNode result = module.detectCycle(head);

        // サイクルが検出され、その開始ノード（値が2のノード）が返されることを確認
        assertNotNull(result);
        assertEquals(2, result.value);  // サイクルは値が2のノードで開始
    }

    // サイクルがないリストでサイクルがないことを確認するテストケース
    @Test
    public void testDetectCycle_WithoutCycle() {
        ModuleThree module = new ModuleThree();
        ListNode head = createListWithoutCycle();

        ListNode result = module.detectCycle(head);

        // サイクルがないので null が返されることを確認
        assertNull(result);
    }

    // 空のリスト（head が null）の場合をテスト
    @Test
    public void testDetectCycle_EmptyList() {
        ModuleThree module = new ModuleThree();
        ListNode head = null;
        ListNode result = module.detectCycle(head);

        // 空のリストでは null が返されることを確認
        assertNull(result);
    }

    // ノードが1つのリスト（サイクルなし）の場合をテスト
    @Test
    public void testDetectCycle_SingleNode() {
        ModuleThree module = new ModuleThree();
        ListNode head = new ListNode(1);

        ListNode result = module.detectCycle(head);

        // 1つのノードのリストではサイクルがないので null が返されることを確認
        assertNull(result);
    }

    // サイクルが最初から存在するリストをテスト
    @Test
    public void testDetectCycle_ImmediateCycle() {
        ModuleThree module = new ModuleThree();
        ListNode head = new ListNode(1);
        head.next = head;  // 即座にサイクルを作成 (1 -> 1)

        ListNode result = module.detectCycle(head);

        // サイクルの開始ノードがノード1であることを確認
        assertNotNull(result);
        assertEquals(1, result.value);
    }
}
