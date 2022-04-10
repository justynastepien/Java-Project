# Wątki
Program komunikujący się między wątkami zawiera klasę reprezentującą czytelnika, klasę Pisarza oraz klasę biblioteki.
Cały program jest uruchamiany poprzez klasę Main. W klasie "Reader" znajduje się metoda run, która określa instrukcję postepowania dla danego wątku czytelnika.
W klasie "Writer" znajduje się metoda run, która określa instrukcję postępowania dla danego wątku pisarza.
Klasa "Library" znajdują się metody: addBook (służy do wypożyczenia ksiązki), returnBook(służąca do oddania książki), addBook (służąca do napisania książki przez pisarza).
Wszystkie te metody są jako synchronized, zatem są wykonywane jednocześnie tylko przez jeden wątek.
Klasa library jako jeden z atrybutów posiada mapę blocade, która odpowiada za blokowanie jednej książki i oznaczenie jej jako zajętej w danym momencie,
co uniemożliwia jej wypożyczenie przez inny wątek czytelnika.
Program wyświetla w konsoli, czym w danym momencie zajmuje się wątek o danym numerze id.
Metody zawierają testy jednostkowe. Jest to projekt typu Maven oraz posiada analizę SonarCube.
