# SQLite3 einbinden
package require sqlite3
# Datenbank eröffnen
sqlite3 meinedatenbank ./meinedatenbank.sqlite
# Variable zum Referenzieren
set var 3
# Tabelle erzeugen, Fehlermeldung ignorieren
meinedatenbank eval {CREATE TABLE tabelle1 (id int, spalteA char(20))}
# Daten in Tabelle schreiben
meinedatenbank eval {INSERT INTO tabelle1 (id, spalteA) VALUES (1, 'foo'), (2, 'bar'), (3, 'ßülz')}
# Daten abfragen
meinedatenbank eval {SELECT * FROM tabelle1 WHERE id = :var} ergebnis {
   puts "id = $ergebnis(id), spalteA = $ergebnis(spalteA)"
}
# Alle Daten löschen
meinedatenbank eval {DELETE FROM tabelle1}
# Tabelle löschen
meinedatenbank eval {DROP TABLE tabelle1}
# Datenbank schließen
meinedatenbank close