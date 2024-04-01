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
