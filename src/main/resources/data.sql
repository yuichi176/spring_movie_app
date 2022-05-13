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
VALUES (1, 'Spider man', '2022-05-10', 'good', 4, 'action');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'Super man', '2022-05-10', 'very good', 5, 'SF');

INSERT INTO movie (user_id, movie_name, add_date, movie_comment, movie_eval,  movie_genre)
VALUES (1, 'Bat man', '2022-05-10', 'bad', 2, 'horror');