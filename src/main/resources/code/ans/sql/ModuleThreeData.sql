-- データベース作成 (存在しない場合のみ)
CREATE DATABASE test_db;

-- スキーマ（ユーザー）の作成 (存在しない場合のみ)
CREATE USER test_schema IDENTIFIED BY password;
GRANT CONNECT, RESOURCE TO test_schema;

-- 使用するスキーマに切り替え
ALTER SESSION SET CURRENT_SCHEMA = test_schema;

-- テーブルが存在する場合は削除
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE linked_list CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN
      NULL; -- テーブルが存在しない場合でもエラーを無視
END;

-- テーブルの作成
CREATE TABLE linked_list (
    node_id INT PRIMARY KEY,
    value INT,
    next_node_id INT
);

-- データの挿入（例: サンプルデータ）
INSERT INTO linked_list (node_id, value, next_node_id) VALUES (1, 3, 2);
INSERT INTO linked_list (node_id, value, next_node_id) VALUES (2, 2, 3);
INSERT INTO linked_list (node_id, value, next_node_id) VALUES (3, 0, 4);
INSERT INTO linked_list (node_id, value, next_node_id) VALUES (4, -4, 2); -- サイクルの開始ノード

-- コミット
COMMIT;

WITH RECURSIVE cycle_detection (node_id, value, next_node_id, path) AS (
    -- 初期ノードを再帰的に取得
    SELECT node_id, value, next_node_id, CAST(node_id AS VARCHAR(255)) AS path
    FROM linked_list
    WHERE node_id = 1  -- 最初のノードのID (例えば 1)

    UNION ALL

    -- 次のノードを再帰的に取得し、サイクルを検出
    SELECT ll.node_id, ll.value, ll.next_node_id, 
           CONCAT(cd.path, '->', ll.node_id) AS path
    FROM linked_list ll
    JOIN cycle_detection cd ON ll.node_id = cd.next_node_id
    WHERE POSITION(CAST(ll.node_id AS VARCHAR(255)) IN cd.path) = 0  -- サイクル検出
)
SELECT node_id, value
FROM cycle_detection
WHERE POSITION(CAST(node_id AS VARCHAR(255)) IN path) > 0  -- サイクル開始ノードを特定
FETCH FIRST 1 ROWS ONLY;  -- 最初のサイクル開始ノードを返す



