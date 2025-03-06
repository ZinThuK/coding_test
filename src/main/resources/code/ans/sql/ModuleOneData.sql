-- ユーザー（スキーマ）が存在しない場合、作成します
BEGIN
    EXECUTE IMMEDIATE 'CREATE USER test_schema IDENTIFIED BY password';
EXCEPTION
    WHEN OTHERS THEN
        NULL; -- ユーザーがすでに存在する場合は無視します
END;

-- ユーザーに必要な権限を付与します
GRANT CONNECT, RESOURCE TO test_schema;

-- 作成したユーザーをスキーマとして設定します
ALTER SESSION SET CURRENT_SCHEMA = test_schema;

-- クエリ処理のために文字列を格納する一時テーブルを作成します
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE string_data';
EXCEPTION
    WHEN OTHERS THEN
        NULL; -- テーブルが存在しない場合は無視します
END;

-- 入力文字列を格納するテーブルを作成します
CREATE TABLE string_data (
    input_string VARCHAR2(255)
);

-- サンプル文字列（'leetcode'）をテーブルに挿入します
INSERT INTO string_data (input_string) VALUES ('leetcode');
INSERT INTO string_data (input_string) VALUES ('loveleetcode');
INSERT INTO string_data (input_string) VALUES ('aabb');
COMMIT;

-- 最初のユニークな文字のインデックスを求めるクエリを実行します
WITH char_counts AS (
    SELECT SUBSTR(input_string, LEVEL, 1) AS char, LEVEL AS idx
    FROM string_data
    CONNECT BY LEVEL <= LENGTH(input_string)
)
SELECT idx - 1 AS unique_char_idx  -- インデックスは0から始まるので、1を引いて調整します
FROM char_counts
GROUP BY char
HAVING COUNT(*) = 1
ORDER BY idx
FETCH FIRST 1 ROWS ONLY;
