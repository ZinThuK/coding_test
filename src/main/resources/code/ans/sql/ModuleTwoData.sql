-- スユーザー（スキーマ）が存在しない場合、作成します
BEGIN
    EXECUTE IMMEDIATE 'CREATE USER test_schema IDENTIFIED BY password';
EXCEPTION
    WHEN OTHERS THEN
        NULL; -- ユーザーがすでに存在する場合は無視します
END;

-- ユーザーに必要な権限を付与します
GRANT CONNECT, RESOURCE TO test_schema;

-- 現在のスキーマを上記で作成したユーザーのスキーマに設定します
ALTER SESSION SET CURRENT_SCHEMA = test_schema;

-- 配列のようなデータを格納するためのテスト用テーブルを削除・作成します
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE array_data';
EXCEPTION
    WHEN OTHERS THEN
        NULL; -- テーブルが存在しない場合は無視します
END;

-- 配列データ（nums）を格納するテーブルを作成します
CREATE TABLE array_data (
    element_id INT PRIMARY KEY,
    element_value INT
);

-- 配列データ（nums）をテーブルに挿入します
-- 最初のテストケース: [3, 2, 1, 5, 6, 4] と k = 2
INSERT INTO array_data (element_id, element_value) VALUES (1, 3);
INSERT INTO array_data (element_id, element_value) VALUES (2, 2);
INSERT INTO array_data (element_id, element_value) VALUES (3, 1);
INSERT INTO array_data (element_id, element_value) VALUES (4, 5);
INSERT INTO array_data (element_id, element_value) VALUES (5, 6);
INSERT INTO array_data (element_id, element_value) VALUES (6, 4);

-- テストケース 1 のデータ挿入をコミットします
COMMIT;

-- k 番目に大きい要素を見つけるためのクエリ
WITH sorted_array AS (
    SELECT element_value
    FROM array_data
    ORDER BY element_value DESC
)
SELECT element_value
FROM sorted_array
FETCH FIRST 2 ROWS ONLY; -- 例として、これは 2 番目に大きい要素（k = 2）です

-- 次のテストケースのために、前のデータをクリアし、新しい値を挿入します：
-- 新しいテストケースデータを挿入します（nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4）
BEGIN
    DELETE FROM array_data; -- 次のテストケースのためにテーブルをクリアします
    COMMIT;
    
    -- 新しいテストデータを挿入します
    INSERT INTO array_data (element_id, element_value) VALUES (1, 3);
    INSERT INTO array_data (element_id, element_value) VALUES (2, 2);
    INSERT INTO array_data (element_id, element_value) VALUES (3, 3);
    INSERT INTO array_data (element_id, element_value) VALUES (4, 1);
    INSERT INTO array_data (element_id, element_value) VALUES (5, 2);
    INSERT INTO array_data (element_id, element_value) VALUES (6, 4);
    INSERT INTO array_data (element_id, element_value) VALUES (7, 5);
    INSERT INTO array_data (element_id, element_value) VALUES (8, 5);
    INSERT INTO array_data (element_id, element_value) VALUES (9, 6);
    
    COMMIT;
END;

-- 2 番目のテストケース（k = 4）のための k 番目に大きい要素を見つけるクエリ
WITH sorted_array AS (
    SELECT element_value
    FROM array_data
    ORDER BY element_value DESC
)
SELECT element_value
FROM sorted_array
FETCH FIRST 4 ROWS ONLY; -- 例として、これは 4 番目に大きい要素（k = 4）です
