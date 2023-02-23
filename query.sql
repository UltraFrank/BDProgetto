use unisa3;

-- Una selezione ordinata su un attributo di una tabella con condizioni AND e OR;
-- Seleziona un aereo nazionale "Airbus A320" o "Boeing 777"
select Prefisso_Nazionale, Codice_Aereo
from Aereo
where TipoVolo = 'nazionale' and (Modello = 'Airbus A320' or Modello = 'Boeing 777')
order by Modello;

-- Una selezione su due o più tabelle con condizioni;
-- Elenca gli aerei della compagnia aerea Ryanair
select a.Codice_Aereo
from Aereo a, Possesso p, Compagnia_Area ca
where a.Codice_Aereo = p.Codice_Aereo and p.Nome = ca.Nome and ca.Nome = 'Ryanair';

-- Una selezione aggregata su tutti i valori (es. somma di tutti gli stipendi)
-- Numero di aerei totali di tutte le compagnie aeree
select sum(NAerei)
from Compagnia_Aerea;

-- Una selezione aggregata su raggruppamenti (es. somma stipendi per dipartimenti)
-- Elenca il numero di aerei per ogni compagnia aerea
select ca.Nome, count(*) NumeroAerei
from Compagnia_Aerea ca, Possesso p
where ca.Nome = a.Nome
group by ca.Nome;

-- Una selezione aggregata su raggruppamenti con condizioni (es. dipartimenti la cui somma degli stipendi dei dipendenti è > 100k)
-- Elenca gli aerei che hanno venduto più di 100 biglietti
select a.Codice_Aereo, count(*) NumeroBiglietti
from Aereo a, Prenotazione p
where p.Codice_Aereo = a.Codice_Aereo
group by a.Codice_Aereo
having NumeroBiglietti > 100;

-- Una selezione aggregata su raggruppamenti con condizioni che includano un’altra funzione di raggruppamento (es. dipartimenti la cui somma degli stipendi è la più alta)
-- Elenca l'aereo con il biglietto più costoso
drop view if exists NumeroBiglietti;
create view NumeroBiglietti as
select a.Codice_Aereo, count(*) as costo_biglietto
from Aereo a, Prenotazione p, Biglietto b
where p.Codice_Aereo = a.Codice_Aereo
group by a.Codice_Aereo;

select * from NumeroBiglietti
where costo_biglietto = (select max(costo_biglietto) from NumeroBiglietti);

-- Una selezione con operazioni sugli insiemi (IN oppure NOT IN)
--

-- Una selezione con l’uso appropriato del doppio not Exists
-- Elenca i clienti che hanno comprato tutti i biglietti dell'aereo "Boeing 777"
select c.CF
from Clienti c
where not exists(
  select *
  from Biglietto b
  where not exists(
    select *
    from Necessità n
    where c.CF = n.CF and b.Aereo_di_Riferimento = n.Aereo_di_Riferimento and b.Aereo_di_Riferimento = "Boeing 777"));