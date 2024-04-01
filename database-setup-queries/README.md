# Database Setup

## Setup

### Run in terminal

```bash
# mysql -u root -p

# password: ""
```

### Open the setupSSMDB.sql file

Copy each line up until the ending semicolon - [;]

#### Check to see if the ssmdb database exists

```bash
# mysql> show databases;

# expected output:
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| ssmdb              |
| sys                |
+--------------------+
```

### Open the setupSSMDBTable.sql file

Copy each line/block up until the ending semicolon - [;]

**Important**

Make sure to run this before the create tables.

```bash
# mysql> use ssmdb;
```

#### Check to see if the tables exists in the ssmdb database

```bash
# mysql> show tables;

# expected output:
+--------------------+
| Tables_in_ssmdb    |
+--------------------+
| posts              |
| replies            |
| spotifyalbumcodes  |
| spotifyartistcodes |
| spotifysongcodes   |
| users              |
+--------------------+
```

#### Insert the values into each table

#### Check to see if the values exists in the users table

```bash
# mysql> select * from users;

# expected output:
+--------+---------------------+--------------------------+-----------+---------------+------------+-------+
| userID | name                | email                    | username  | password      | isSilenced | isMod |
+--------+---------------------+--------------------------+-----------+---------------+------------+-------+
|      1 | Peter Clarke        | clarkep@fiu.edu          | clarkep   | clarkep1234   |            |       |
|      2 | Kevin Johnson       | kjohns1972@gmail.com     | kevinj72  | kevinj1234    |            |       |
|      3 | Kennedy Smith       | swiftiefan1989@gmail.edu | swiftie   | swiftie1234   |            |      |
|      4 | Himothy Himersville | himothyh@gmail.com.edu   | iamhim    | iamhim1234    |            |      |
|      5 | Sarah Caldwell      | scaldwell@fiu.edu        | scaldwell | scaldwell1234 |            |       |
+--------+---------------------+--------------------------+-----------+---------------+------------+-------+
```

## See Also

- [Create Database](https://www.mysqltutorial.org/mysql-basics/mysql-create-database/)
- [Create Table](https://www.mysqltutorial.org/mysql-basics/mysql-create-table/)
- [Show Table/Columns](https://www.mysqltutorial.org/mysql-administration/mysql-show-columns/)
