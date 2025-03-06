package code.test.ans.java.modules;

// リストノードを表すクラス
public class ModuleThree {
// サイクルの検出と開始位置を返すメソッド
public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null; 
    }

    ListNode slow = head;  // スロー（遅い）ポインタ
    ListNode fast = head;  // ファスト（速い）ポインタ

    // サイクルの検出
    while (fast != null && fast.next != null) {
        slow = slow.next;       // スローを1ステップ進める
        fast = fast.next.next;  // ファストを2ステップ進める

        // サイクルがあれば、スローとファストが一致する
        if (slow == fast) {
            // サイクルの開始位置を特定
            ListNode pointer = head;
            while (pointer != slow) {
                pointer = pointer.next;
                slow = slow.next;
            }
            return pointer;  // サイクルの開始ノード
        }
    }

    // サイクルがなければ null を返す
    return null;
}
}