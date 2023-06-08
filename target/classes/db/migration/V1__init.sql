CREATE TABLE IF NOT EXISTS youtuber (

    id SERIAL,
    channel VARCHAR(100) NOT NULL,
    total_videos INT NOT NULL,
    monetize BOOLEAN FALSE,
    PRIMARY KEY (id)
    );