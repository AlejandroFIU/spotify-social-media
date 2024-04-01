-- Make sure to use the SSMDB database
use ssmdb;

-- Delete tables if they exist
DROP TABLE IF EXISTS spotifysongcodes;
DROP TABLE IF EXISTS spotifyalbumcodes;
DROP TABLE IF EXISTS spotifyartistcodes;
DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users;

-- Create tables if they don't exist
CREATE TABLE IF NOT EXISTS users(
    userID INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    isSilenced BIT DEFAULT 0,
    isMod BIT DEFAULT 0,
    CONSTRAINT usersPK
        PRIMARY KEY (userID),
    CONSTRAINT usersSK
        unique(userID, username, email)
);

CREATE TABLE IF NOT EXISTS posts(
    postID INT NOT NULL,
    userID INT NOT NULL,
    postText VARCHAR(255) NOT NULL,
    likes INT DEFAULT 0,
    dislikes INT DEFAULT 0,
    artist VARCHAR(50),
    album VARCHAR(50),
    song VARCHAR(50),
    createdOn DATE,
    updateOn DATE,
    CONSTRAINT postsPK
        PRIMARY KEY (postID),
    CONSTRAINT postsFK
        FOREIGN KEY (userID) REFERENCES users(userID),
    CONSTRAINT postsSK
        unique(postID)
);

CREATE TABLE IF NOT EXISTS replies(
    replyID INT NOT NULL,
    postID INT NOT NULL,
    userID INT NOT NULL,
    replyText VARCHAR(255) NOT NULL,
    likes INT DEFAULT 0,
    dislikes INT DEFAULT 0,
    createdOn DATE,
    updateOn DATE,
    CONSTRAINT repliesPK
        PRIMARY KEY (replyID),
    CONSTRAINT repliesuserFK
        FOREIGN KEY (userID) REFERENCES users(userID),
    CONSTRAINT repliespostFK
        FOREIGN KEY (postID) REFERENCES posts(postID),
    CONSTRAINT repliesSK
        unique(replyID)
);

CREATE TABLE IF NOT EXISTS spotifyartistcodes(
    artist VARCHAR(50) NOT NULL,
    artistcode VARCHAR(100) NOT NULL,
    artistcovercode VARCHAR(100) NOT NULL,
    CONSTRAINT artistPK
        PRIMARY KEY (artist),
    CONSTRAINT artistSK
        unique(artist, artistcode, artistcovercode)
);

CREATE TABLE IF NOT EXISTS spotifyalbumcodes(
    artist VARCHAR(50) NOT NULL,
    album VARCHAR(50) NOT NULL,
    albumcode VARCHAR(100) NOT NULL,
    albumcovercode VARCHAR(100) NOT NULL,
    CONSTRAINT albumPK
        PRIMARY KEY (artist, album),
    CONSTRAINT albumSK
        unique(album, albumcode, albumcovercode)
);

CREATE TABLE IF NOT EXISTS spotifysongcodes(
    artist VARCHAR(50) NOT NULL,
    album VARCHAR(50) NOT NULL,
    song VARCHAR(50) NOT NULL,
    songcode VARCHAR(100) NOT NULL,
    songcovercode VARCHAR(100) NOT NULL,
    CONSTRAINT songPK
        PRIMARY KEY (artist, album, song),
    CONSTRAINT songSK
        unique(song, songcode, songcovercode)
);

-- Insert values into the tables
INSERT INTO users VALUES(
    '1', 'Peter Clarke', 'clarkep@fiu.edu', 'clarkep', 'clarkep1234', '0', '0'
);
INSERT INTO users VALUES(
    '2', 'Kevin Johnson', 'kjohns1972@gmail.com', 'kevinj72', 'kevinj1234', '0', '0'
);
INSERT INTO users VALUES(
    '3', 'Kennedy Smith', 'swiftiefan1989@gmail.edu', 'swiftie', 'swiftie1234', '0', '1'
);
INSERT INTO users VALUES(
    '4', 'Himothy Himersville', 'himothyh@gmail.com.edu', 'iamhim', 'iamhim1234', '0', '1'
);
INSERT INTO users VALUES(
    '5', 'Sarah Caldwell', 'scaldwell@fiu.edu', 'scaldwell', 'scaldwell1234', '0', '0'
);