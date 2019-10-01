**Bevezetés**

Munkánk végcélja egy ATM bankautomata rendszer megalkotása. A rendszer célja, hogy biztosítson egy a felhasználó igényinek megfelelő általános regisztrációs és bejelentkezési felületet, illetve képes legyen az általános pénzügyi tranzakciók kezelésére, amelyeket más bank automaták is tudnak.

**1. Fizikai környezet:**

Ezen dokumentumrész célja, hogy ismertesse az alaklmazásunk futtatáshoz szükséges hardveres és szoftveres követelményeket, valamint betekintést nyújt az általunk legfontosabbnak tartott fejlesztői eszközökbe illetve az általunk használt keretrendszer működésébe. 

**1.1 Hardveres követelmények:**

Az alkalmazás futtatásához olyan hardverre van szükség, amely képes a lentebb tárgyalt szoftverek futtatására, alkalmas nagy mennyiségű kérés kiszolgálására, valamint kellően nagy tárhelyen rendelkezik az adatok tárolásához. Jelen állapotban a szoftverünk futtatásához elegendőnek látjuk az 266MHz-es órajelű processzorral, 124 MB memóriával illetve 500 MB tárhellyel rendelkező számítógépet/autómatát. További információkért forduljon az alább bemutatandó szoftverek gyártóihoz!

**1.2 Szoftveres követelmények**

A továbbiakban részletesebben tárgyaljuk az alkalmazásunk futtatásához elengedhetetlen szoftvertveres komponenseket.


**1.2.1 Java 11**

Mivel az alaklmazásunk elsősorban fizikai rendszereken-en keresztül érhető el, ezért elegedhetetlen egy Java virtuális környezet futtatása. Esetünkben a JAVA 11 verziszámú SDK változatát használjuk.

Az új Java 11 egyik talán legérdekesebb újítása, hogy lehetővé teszi a Java kvázi szkriptnyelvként történő használatát is. A platform új fejlesztésének köszönhetően ugyanis a java parancssori eszköz már közvetlenül forrásból, nyilvánvaló fordítási fázis nélkül, közvetlenül tudja is futtatni a Java kódokat. Annyira, hogy a források első soraként megengedi az ún. "shebang" használatát is, aminek révén a *nix rendszerek legelterjedtebb shelljei kvázi közvetlenül is képessé válnak a szóban forgó Java szkriptfájlok futtatására, illetve mostantól shell szkriptfájlok is írhatók lesznek Java-ban.

Az új verzió egy másik érdekes fejlesztése a ZGC nevű kísérleti szemétgyűjtő megjelenése, ami rendkívül gyors (<10 ms-nál kevesebb időt felemésztő) takarítást ígér még nagyméretű heap esetén is, valamint az immár nyílt forrású Flight Recorder nevű adatgyűjtő, ami a Java alkalmazások és a HotSpot VM minimális költséggel történő monitorozását teszi lehetővé hibakeresés és teljesítményoptimalizálás céljára.

A Fejlesztési környezet kiválasztásánál fontosnak tartottuk a szoftverünk biztonságát és gyorsaságát. 

**1.2.2 JavaFX 11**

Szoftverünk megjelenítésének létrehozásához a JavaFX 11-es verzióját válásztottuk. Mivel Java programozási nyelvet használtunk ezért volt fontos és nélkülözhetetlen a JavaFX használata programunk megjelenítésének megalkotásához. 

**1.2.3 JSON**

Szoftverünk a regisztráció során megadott információkat illetve a felhasználói fiókakban szereplő pénzösszegekkel kapcsolatos adatokat JSON fájlban tárolja el. Használatát azért tartottuk előnyösnek mivel az emberek számára is olvasható–írható, programozottan pedig könnyen feldolgozható és előállítható adatcsere-formátum illetve nem elhanyagolható az sem,hogy a  banki autómaták többnyire a pénzösszegeket egy szám adattípusban tárolják és ez a JSON alap adattípusaihoz tartozik. Illetve nem elhanyagolható az adatok értelmezésére, egyszerű és gyors mivoltára nyújtott megoldásai sem.


**1.2.4 Operációs rendszer**

Az alkalmazás futtatásához olyan operációs rendszer érdemes választani, amely képes az előzőekben megfogalmazott szoftverek futtatására. A fenti termékek elérhetőek mind Windows mind UNIX, illetve Linux rendszerekre. A szoftver megvalósítása során választásunk a Windows 10 disztribúcióra esett.

**1.2.5 IntelliJ**

A programunk fejlesztéséhez az IntelliJ integrált fejlesztői környezetet alkalmaztuk.

**2. Architekturális terv**

**2.1 Architekturális tervezési minta**

A program a modell-néző-vezérlő szerkezeti minta alapján van felépítve. Az MVC mellett található egy main fájl is ahol a program main függvénye található, továbbá ez tartalmazza azt a függvényt, amely a bejelentkezés ablakot jeleníti meg. Ebben a függvényben van meghatározva az ablak címsora, felbontása és átméretezhetősége. A vezérlő fájl eseményeket, jellemzően felhasználói műveleteket dolgozza fel és válaszol rájuk, illetve a modellben történő változásokat is kiválthat. Ebben a fájlban található a program irányításáért felelő kódrész. A kontrollerben vannak inicializva a javafx által használt komponensek (pl.: gombok, textfield-ek, stb.), illetve a logger plugin, amely a logolásért, illetve a logfájlok elkészítésért felel. A logfájlt a rendszer egy külön az helyre menti, amihez csak az admin fér hozzá. Továbbá itt található javafx által használt függvények, illetve egyéb kódrészletek, amelyek a program egyes részeinek irányításáért felelnek.

A model az alkalmazás által kezelt információk tartomány-specifikus ábrázolása. Ebben a részben található az a kód, amely összeköti a rendszert az adatok tárolására szolgáló json fájlal.

A nézet rész pedig FXMLfájlok, amelyek az ablakok kinézetét tárolják kód formában. Ezek a fájlok egy külön resorces nevű mappában helyezkednek el. 

**2.2 Maven framework használata**

Az alkalmazás használja a Maven keretrendszer támogatást, amely lehetővé teszi azt hogy hozzáadjunk a projectünkhöz egy pom fájlt. A POM egy buildelendő projektet ír le és annak függőségeit. A pomba a program működéséhez elengedhetetlen függőségeket és pluginokat adhatjuk meg. Ezek közül a fontosabbak a javafx függőségei, amely az ablakok vizuális megjelenítését teszi lehetővé illetve annak funkcióit biztosítja, a json, amely az adatok tárolásához szükséges, a logback függőség, amely a logolást teszi lehetővé. Pluginok közül a maven compiler plugin, amely a program futtatásához elengedhetetlen, a maven checkstyle plugin, amely a program felépítésének a struktúráját határozza meg.

**3. Funkcionalitás a fejlesztők szemszögéből**

**3.1 Bejelntkező ablak**

A program indításkor először a main fájlt futattja. A main fájlban található a bejelentkező ablakot aktiváló függvény. Az ablak felépítését tartalmazó FXML fájl betöltéséért az FXMLLoader felel, amely azt a resorces könyvtárban találja meg. Majd a main-ben lévő launch utasítás indítja el a programot.

**3.2 Főmenü ablak**

A bejelentkezési adatok megadása és a bejelentkezés gomb megnyomása után a program egy controllerben lévő actioneventet fogja elővenni, amely megnézi, hogy beírt adatok megfelelnek a json fájlban eltároltakkal, ha nem akkor visszadob egy hibaüzenetet, ha egyeznek, akkor betölti a következő fxml fájlt a resources könyvtárból, amely ugye a főmenü. AZ itt található gombok mindegyikéhez van kapcsolva egy újabb actionevent amelyek a gombok megnevezésének megfelelő ablakot fogják behozni.

**3.3 Pénzfelvétel, pénzfeltöltés, egyenleg**

Vegyük például a Pénzfelvétel ablakot. A megfelelő fxml fájl beolvasása mellett a json fájlból is beolvassa a benne lévő összeg mennyiségét. Ha pénzt vonunk le, akkor a következőkre kell figyelni: van-e megadva levenni kívánt pénzösszeg, a megadott összeg nagyobb-e a számlán lévő összegnél, mivel a számlán lévő összeg nem mehet át negatívba, van-e megadva jelszó, helyes-e a megadott jelszó. Amennyiben a fent említette problémák valamelyike fennáll a program egy annak megfelelő hibaüzenetet dob vissza és nem fogja végrehajtani a pénzfelvételt. Megfelelő adatok esetén végrehajtódik. A pénzfeltöltés is hasonló módon működik, kivéve hogy ott nem kell törődni azzal, hogy mennyi pénzt töltünk fel. Az egyenleg megtekintése szimplán csak lekéri a json file-ból a számlán lévő pénzösszeget.

**3.4 Jelszó megváltoztatása**

Jelszó megváltoztatása lekéri a jelszót a json file-ból, összehasonlítja beírt jelszóval, és ha egyezik, akkor kicseréli az újonnan beírtra.

**3.5 Kilépés**

A főmenüben még található egy kilépés gomb, amely a Platform.exit() sorral bezárja az egész programot. 




