DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) DEFAULT NULL,
  `password` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `blog_user` (username, password) VALUES ('admin', '123456');

DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(63) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `title` text DEFAULT NULL,
  `body` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `blog_article` (category, create_date, update_date, title, body) VALUES ('Hello world!', NOW(), NOW(), 'Hello world!', 'Hello world!');

DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `tag` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `blog_article_tag` (article_id, tag) VALUES ('1', 'Hello world!');

DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `blog_category` (category) VALUES ('Hello world!');

DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `blog_tag` (tag) VALUES ('Hello world!');
