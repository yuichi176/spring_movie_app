/**
  accountテーブルのDML
 */
INSERT INTO account (user_name, password)
VALUES ('user01', '$2a$10$kMKCHYGtNoHq11OHu0tAF.8J80pR0ZIxIvc3E7kdazNPbdEPdB8mW');

INSERT INTO account (user_name, password)
VALUES ('user02', '$2a$10$kMKCHYGtNoHq11OHu0tAF.8J80pR0ZIxIvc3E7kdazNPbdEPdB8mW');

INSERT INTO account (user_name, password, role_id)
VALUES ('admin01', '$2a$10$kMKCHYGtNoHq11OHu0tAF.8J80pR0ZIxIvc3E7kdazNPbdEPdB8mW', 0);


/**
  movieテーブルのDML
 */
INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval, movie_genre)
VALUES (1, 'アイアンマン', '2022-05-10', '最高', 4, 'アクション');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'キャプテン・アメリカ', '2022-05-10', 'まあまあ', 5, 'アクション');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'スターウォーズ', '2022-05-10', 'テキストテキストテキストテキストテキストテキスト', 2, 'SF');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'ミスタービーン', '2022-05-10', 'まあまあ', 5, 'コメディ');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'ラ・ラ・ランド', '2022-05-10', 'まあまあ', 5, 'ミュージカル');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval, movie_genre)
VALUES (2, 'アイアンマン', '2022-05-10', '最高', 4, 'アクション');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (2, 'キャプテン・アメリカ', '2022-05-10', 'まあまあ', 5, 'アクション');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (2, 'アオハライド', '2022-05-10', 'まあまあ', 5, '恋愛');

/**
  genreテーブルのDML
 */
INSERT INTO genre (genre_name)
 VALUES ('アクション');
INSERT INTO genre (genre_name)
VALUES ('SF');
INSERT INTO genre (genre_name)
VALUES ('コメディ');
INSERT INTO genre (genre_name)
VALUES ('サスペンス');
INSERT INTO genre (genre_name)
VALUES ('ミステリー');
INSERT INTO genre (genre_name)
VALUES ('ホラー');
INSERT INTO genre (genre_name)
VALUES ('ヒューマンドラマ');
INSERT INTO genre (genre_name)
VALUES ('恋愛');
INSERT INTO genre (genre_name)
VALUES ('アニメ');
INSERT INTO genre (genre_name)
VALUES ('ミュージカル');
INSERT INTO genre (genre_name)
VALUES ('その他');
