INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('lp', '1', 'lpdis', '20', 'lptitle');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('lp', '2', 'lpdis', '30', 'lptitle2');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('game', '3', 'gamedis', '50', 'gametitle');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('game', '4', 'gamedis', '60', 'gametitle2');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('fiction', '5', 'fictiondis', '30', 'fictiontitle');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('fiction', '6', 'fictiondis', '23', 'fictiontitle2');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('nonfiction', '7', 'nondis', '345', 'nonfixtiontitle');

INSERT INTO `shopr`.`article` (`type`, `id`, `distributor`, `price`, `title`) VALUES ('nonfiction', '8', 'nondis', '6756', 'nonfixtitle2');

INSERT INTO `shopr`.`lp` (`artist`, `lp_genre_enum`, `id`) VALUES ('artist 1', 'METAL', '1');

INSERT INTO `shopr`.`lp` (`artist`, `lp_genre_enum`, `id`) VALUES ('artist 2', 'ROCK', '2');


INSERT INTO `shopr`.`game` (`age`, `game_genre_enum`, `studio`, `id`) VALUES ('12', 'FPS', 'studio1', '3');

INSERT INTO `shopr`.`game` (`age`, `game_genre_enum`, `studio`, `id`) VALUES ('18', 'RTS', 'studio2', '4');


INSERT INTO `shopr`.`book` (`author`, `isbn`, `nr_pages`, `id`) VALUES ('sdfsdf', 'hgjhgj', '290', '5');

INSERT INTO `shopr`.`book` (`author`, `isbn`, `nr_pages`, `id`) VALUES ('sdfsdfdf', 'ghjghjgh', '1234', '6');

INSERT INTO `shopr`.`book` (`author`, `isbn`, `nr_pages`, `id`) VALUES ('sdfsdf', 'fsdfsd', '45', '7');

INSERT INTO `shopr`.`book` (`author`, `isbn`, `nr_pages`, `id`) VALUES ('sdfsdf', 'sdfsdf', '34', '8');


INSERT INTO `shopr`.`fiction` (`fiction_genre_enum`, `id`) VALUES ('SCIENCEFICTION', '5');

INSERT INTO `shopr`.`fiction` (`fiction_genre_enum`, `id`) VALUES ('DETECTIVE', '6');


INSERT INTO `shopr`.`non_fiction` (`about`, `non_fiction_genre_enum`, `id`) VALUES ('xcvxcvxcvxcvxcv', 'FOOD', '7');

INSERT INTO `shopr`.`non_fiction` (`about`, `non_fiction_genre_enum`, `id`) VALUES ('xcvxcvxcvxcvxvf', 'RELIGION', '8');



INSERT INTO `shopr`.`user` (`id`, `first_name`, `last_name`, `user_role_enum`) VALUES ('5', 'koen', 'meyers', 'ADMIN');

INSERT INTO `shopr`.`user` (`id`, `first_name`, `last_name`, `user_role_enum`) VALUES ('2', 'indy', 'meyers', 'USER');

INSERT INTO `shopr`.`user` (`id`, `first_name`, `last_name`, `user_role_enum`) VALUES ('3', 'odin', 'meyers', 'USER');

INSERT INTO `shopr`.`user` (`id`, `first_name`, `last_name`, `user_role_enum`) VALUES ('4', 'dino', 'meyers', 'USER');