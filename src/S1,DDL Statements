ALTER TABLE medewerkers2 ADD geslacht VARCHAR(1) CONSTRAINT M_OR_V CHECK (geslacht = 'M' OR geslacht = 'V');
INSERT INTO medewerkers2 VALUES (2500, 'BOEIE', 'RU', 'CHEF', 9899, '22-04-2016', 9999, 2000, 13, 'M');

CREATE SEQUENCE anr START WITH 50 INCREMENT BY 10;
SELECT anr.nextval, anr.currval FROM dual;
INSERT INTO afdelingen VALUES (anr.nextval, 'blablablabla', 'Rotterdam', '1');

CREATE TABLE historische_adressentabel
( postcode VARCHAR(6) NOT NULL CHECK ( postcode LIKE '^[0-9]{4}[A-Z]{2}'),
huisnummer NUMBER,
ingangsdatum DATE NOT NULL,
einddatum DATE CONSTRAINT ha_e_chk CHECK (einddatum > begindatum),
telefoon NUMBER (8) UNIQUE,
med_mnr NUMBER CONSTRAINT ha_mnr_nn NOT NULL,
CONSTRAINT pr_key PRIMARY KEY ("postcode", "huisnummer", "ingangsdatum"),
CONSTRAINT ha_mnr_nn FOREIGN KEY (med_mnr) REFERENCES medewerkers ("MNR")
);

CONSTRAINT m_verk_chk CHECK (LNNVL(functie = 'verkoper') = LNNVL(comm NOT NULL));
