
use unisa3;

insert into Amenità values
("Zara"),
("McDonald"),
("Mondadori"),
("Starbucks"),
("Apple");

insert into Tipologia values
("Profumeria"),
("Fast Food"),
("Gioielleria"),
("Cartolibreria"),
("Abbigliamento");

insert into Aeroporto values
("FCO","Fiumicino","Roma"),
("NAP","Capodichino","Napoli"),
("MXP","Malpensa","Milano"),
("LHR","Heathrow","Londra"),
("BER","Brandeburgo","Berlino");

insert into Direttore values
("MRCTNQ80A01H501F","Tranquillino","Marchesi","Via Brombeis"),
("NPLTLI80A01H501G","Italo","Napolitano","Via Roma"),
("TRVMSM80A01H501N","Massimo","Trevisan","Via Garibaldi"),
("NOIBLA80A41H501Y","Abela","Onio","Via Rossi"),
("BRGDNI80A01H501Z","Dino","Bergamaschi","Via Sarno");

insert into Compagnia_Aerea values
("Ryanair",12),
("Easyjet",15),
("Wizzair",10),
("VoloTea",20),
("Alitalia",2);

insert into Collocazione values
("FCO","Ryanair"),
("NAP","Easyjet"),
("MXP","Wizzair"),
("LHR","VoloTea"),
("BER","Alitalia");

insert into Gestione values
("FCO","MRCTNQ80A01H501F","022"),
("NAP","NPLTLI80A01H501G","040"),
("MXP","TRVMSM80A01H501N","052"),
("LHR","NOIBLA80A41H501Y","136"),
("BER","BRGDNI80A01H501Z","641");

insert into Clienti values
("MNCMND80A41H501L","Miranda","Mancini"),
("TRNRNT80A41H501V","Renata","Trentini"),
("ZTTGRD80A41H501N","Gerarda","Zettini"),
("FRRSNT80A41H501J","Ferri","Simonetta"),
("BTTFNC80A01H501W","Francesco","Botta");

insert into Biglietto values
("4840A393R33839",8,3,40),
("4530F393P65984",6,1,45),
("4531Y494495984",5,1,50),
("483T494C959846",11,3,60),
("484402Z39P3930",15,2,80);
