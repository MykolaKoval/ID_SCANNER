---- Server Fine tuning
---- my.ini  [mysqld] section
---- # this adds 35% speed increase
---- innodb_flush_log_at_trx_commit=2
---- # To store big blobs
---- max_allowed_packet=200M
---- transaction-isolation = READ-COMMITTED

-- initialization
DROP USER 'idscanner';
CREATE USER 'idscanner' IDENTIFIED BY 'idscanner';
DROP DATABASE idscanner;
CREATE DATABASE idscanner DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
-- GRANT ALL PRIVILEGES ON idscanner.* TO 'idscanner'@'%';
GRANT ALL PRIVILEGES ON idscanner.* TO idscanner@localhost IDENTIFIED BY 'idscanner' WITH GRANT OPTION;

--  if you get error:
--  ERROR 1396 (HY000) at line 3: Operation CREATE USER failed for 'idscanner'@'%'
--  then run the following commands:
-- DROP USER 'idscanner'@'localhost'
-- delete from mysql.user where user='idscanner';
-- delete from mysql.db where user='idscanner';
-- FLUSH PRIVILEGES;
