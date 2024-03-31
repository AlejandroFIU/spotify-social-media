# Database Setup

## Setup

### Run in terminal

```bash
# mysql -u root -p

# password: ""
```

### Open the setupSSMDB.sql file

Copy each line up until the ending semicolon - [;]

#### Run in terminal

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
