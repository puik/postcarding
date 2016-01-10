# Postcarding ehk postkaartide sorteerija
Projekt [õppeaines I200: *Programmeerimise algkursus Java baasil*](http://i200.itcollege.ee/), sügissemester 2015, IT arenduse eriala, kaugõpe

## Andmed:
Rahvusraamatukogus on digiteeritud üle 7000 ajaloolise postkaardi ([postkaartide otsing RRi andmebaasis Digar](http://goo.gl/NxMyZz)).

## Eesmärk:
Koguda *crowdsourcingu* põhimõttel (sarnaselt rakendustele [Ajapaik.ee](http://ajapaik.ee) ja [Sift.pics](http://sift.pics)) postkaartide ja ennekõike kaartide tagumise (st tekstikülje, mitte pildipoole) kohta lisainfot, mis on praegu postkaartide juures kirjeldamata.

Allpool loend ja näited erineva infoga postkaartidest. Tulevikus oleks vaja teha rakendus veebirakenduseks ja lisada järjest eri funktsioone, alustuseks üks konkreetne ülesanne: saadetud, st tekstiga postkaartide välja sorteerimine.

## Idee esialgsest rakendusest:
Kasutajale kuvatakse täisekraanil üks postkaart, kasutaja hiireklikk keerab postkaardi ringi, st kuvab tagakülje. Kui postkaardi tagaküljel on tekst, märgib kasutaja selle tühikuklahvi vajutamisega, mille peale saab järgmise postkaardi, kui teksti pole, siis hiireklikk annab samuti järgmise postkaardi.
SQLite andmebaasi logitakse vaadatud pildid ja tekstiga postkaardid tähistatakse.

## Edasiarendused, lisavõimalused:
* Veebirakenduse loomine
* Margiga postkaartide tähistamine
* Dateeringute sisestamine: postkaardi teksti dateering, postitemplite dateeringud
* Saatmiskoha ja saaja koha sisestamine
* Postkaarditekstide humanOCR ehk kasutajad sisestavad postkaartide teksti
