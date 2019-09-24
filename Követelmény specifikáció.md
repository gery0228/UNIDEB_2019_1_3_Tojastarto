**1. Alkalmazással kapcsolatos követelmények**

Kereskedelmi szoftverről lévén szó, a legfontosabb elvárás a megbízhatóság, az adatok biztoságos tárolása, illetve a bizalmasság. A felhasználók adatainak és érdekeinek védelme éppoly létfontosságű, mint a felhasználó cég érdekeié. Ennek érdekében a szoftvert fel kell készíteni az ismert támadási formák ellen, a biztonság tovább fokozható a felhasználó oldalán tett megkötésekkel (például könnyű jelszavak tiltása), (alapvető felhasználónevek visszaszorítása) de ez nem mehet a többi aspektus rovására.

Kiemelt fontosságú a szoftver felületének kezelhetősége, áttekinthetősége, ugyanakkor meg kell felelnie a lehető legtöbb kényelmi elvárásnak is. Fontos továbbá, hogy a hozzá nem értő felhasználó is könnyen boldoguljon, és mindez a bankautomata kezelhetőségétől a lehető legkevésbé függjön. Természetesen ez vonatkozik az adminisztrátorok által használt kezelőfelületre, funkciókra is.

Fontos a rendszer jó teljesítménye, jó válaszideje, mely lehetővé teszi a gyors ügyintézést, és használhatóvá teszi az alkalmazást nagyobb pénzmennyiség esetén is.

A szolgáltatás lehető legnagyobb rendelkezésre állása alapkövetelmény - bár ezt nagyban befolyásolja a felhasználó illetve az bankautomata alatt futó szoftver, az azzal létesített kapcsolat és annak karbantartása.

**2. A válaszidő minimális függése az adatok mennyiségétől**

A Bank Automata forgalmának növekedésével ezen kérdés jelentősége egyenes arányban növekszik. Fontos tehát, hogy a rendszer rugalmasan kezeljen nagyobb pénzmennyiséget is, ne okozzon gondot több felhasználó kezelése sem. Pénz feltöltése és levétele a pénz nagyságától függetlenül ugyan olyan gyorsan történjen meg, ne kelljen sok időt várni rá.

**3. Minél gyorsabb válaszidő**

A JSON file-ban való adattárolás nem tartozik bele az alkalmazásba, de szoros kapcsolatban áll azzal. Tehát fontos a különböző JSON fileok nagyfokú és rugalmas támogatása, hogy a válaszidő csak a felhasználó és a JSON file kapcsolatának sebességétől függjön. Ugyanakkor a Bank Automata üzemeltetőjére, karbantartójára is nagyobb rész hárul ebben a pontban.

**4. Rendelkezésre állás**

A kész rendszert minden tekintetben mentesíteni kell a hibáktól. Ez kitartó tesztelést és esetleges javítások implementálását jelenti. Ugyanakkor az üzembehelyezett Bank Automata karbantartójától is igényel közreműködést, visszajelzéseket. A rendelkezésre állást nagyban befolyásolja az üzemeltető cég körültekintése is.

**5. Felhasználói felület áttekinthetősége**

Nagyon fontos lehet egy Bank Automata sikerességében annak kinézete, felülete, melynek megfelelő egyensúlyt kell teremtenie a dizájn és funkcionalitás között, ez persze részben függ a rendszert üzembe helyező cégtől is. Szükséges, hogy az alapok nagyon jól legyenek megtervezve, ezt annak érdekében, hogy a rendszer üzemeltetőjének utólagos munkája leegyszerűsödjön. Másik nagyon fontos dolog, hogy nem szabad a rendszert a saját képességeinkre tervezni, gondoskodni kell arról, hogy a rendszer könnyen használható legyen bárki számára.
 
**6. Biztonság, bizalmasság, letagadhatatlanság és az alapvető működési funkciók**

A gyakorlatban ezt azt jelenti, hogy egy adott számlához, azon lévő adatokhoz és egyenleghez csak az juthasson hozzá, akinek ehhez joga van. Továbbá kiemelten fontos a jogtalan hozzáférések kiszűrése, és egyéb visszaélési kísérletek megelőzése. A felhasználó megfelelő azonosítása hiányában ne lehessen illetéktelenül hozzáférni az adatokhoz, illetve az adott felhasználóhoz tartozó számlához. Még ha be is jelentkeztek a számlába a megfelelő adatok megadásával, autentikáció nélkül ne lehessen a számlán lévő egyenleget mozgatni.

Alapvető funkciók alatt értjük a számla megtekintését, egyenleg megtekintését, egyenleg feltöltését és egyenleg felvétele. Illetve a felhasználó menedzsmentet, amelyek a regisztráció, és a bejelentkezés. Bármely további funkció a kényelmesség érdekét szolgálja.

 
**7. Követelménylista**

| ID |	Név | Kifejtés |

| --- | --- | --- |

| K1 | Bejelentkező ablak | Elindításkor az első ablak, amit a felhasználó meglát. Felhasználónév mező, jelszó mező, Bejelentkezés gomb.|

K2	Felhasználónév mező	
Felhasználónak ide írja be a felhasználónevét. Helytelen adat esetén figyelmeztetést kap a felhasználó.

K3	Jelszó mező	
Felhasználónak ide írja be a felhasználónevét. Helytelen adat esetén figyelmeztetést kap a felhasználó.

K4	Bejelentkezés gomb	
Megnyomásakor a rendszer leellenőrzi a felhasz. adatait.

K5 	Főmenü ablak	
Sikeres bejelentkezés esetén felugró ablak. Egyenleg megtekintése, feltöltése, felvétele menüpontokat tartalmaz. Kilépés gomb.

K6	Egyenleg ablak	
Egyenleg menüpont aktiválásával férhet hozzá a felhasz. Számlán lévő egyenleg összegének lekérdezése.

K7	E. feltöltés ablak	
Feladata az egyenleg feltöltés igényének kielégítése. A feltöltéshez először meg kell adni a kívánt pénzösszeget, majd a megfelelő jelszó megadásával az összeg felkerül a számlára. Helytelen jelszó esetén a folyamat nem megy végbe és a program helytelen jelszó hibát ad vissza.
		
K8 E. felvétel ablak 
Feladata az egyenleg felvétel igényének kielégítése. A pénzfelvételhez először meg kell adni a kívánt pénzösszeget, majd a megfelelő jelszó megadásával az összeg lekerül a számláról. Helytelen jelszó esetén a folyamat nem megy végbe és a program helytelen jelszó hibát ad vissza. Helytelen érték esetén pedig helytelen pénzösszeg hibát ad vissza.

K9 Kilépés gomb	
Főmenüben található. Rákattintva bezárja az alkalmazást.
