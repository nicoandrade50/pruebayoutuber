CREATE TABLE IF NOT EXISTS video  (

    id SERIAL,
    title VARCHAR (50) NOT NULL ,
    duration INT NOT NULL ,
    youtuber_id INT NOT NULL ,
    PRIMARY KEY (id) ,
    FOREIGN KEY (youtuber_id) REFERENCES youtuber (id)

);