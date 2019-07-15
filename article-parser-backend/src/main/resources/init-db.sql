CREATE TABLE site (
	str_id 	VARCHAR(10) PRIMARY KEY NOT NULL,
	url	TEXT NOT NULL,
	last_updated	TEXT NOT NULL
);

CREATE TABLE article (
	id	INTEGER PRIMARY KEY,
	site_id	VARCHAR(10) NOT NULL,
	url	TEXT NOT NULL UNIQUE,
	title	TEXT NOT NULL,
	data	TEXT NOT NULL,
	date	TEXT NOT NULL,
	FOREIGN KEY (site_id) REFERENCES site(str_id)
);

INSERT INTO site (str_id, url, last_updated)
VALUES ('NHKEASY', 'https://www3.nhk.or.jp/news/easy/', '1900-01-01T00:00');