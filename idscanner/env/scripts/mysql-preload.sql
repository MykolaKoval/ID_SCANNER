DROP DATABASE idscanner;
CREATE DATABASE idscanner DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

USE idscanner;

CREATE TABLE persons (
	id BIGINT NOT NULL AUTO_INCREMENT,
	code VARCHAR(32) NULL DEFAULT NULL,
	name VARCHAR(32) NULL DEFAULT NULL,
	surname VARCHAR(32) NULL DEFAULT NULL,
	country VARCHAR(32) NULL DEFAULT NULL,
	is_director TINYINT(1) NULL DEFAULT NULL,
	img_blob LONGTEXT NULL DEFAULT NULL,
	PRIMARY KEY (id)
);

-- preload configuration data
-- INSERT INTO persons(code, name, surname, country) VALUES ('JJGG', 'John', 'Smith', 'USA');