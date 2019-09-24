**1.0 Az alkalmazás funkciói:**

**1.1 Navigáció a menüpontok között:**

Az alkalmazás bárki által használható funkciója a bankautomata menüpontjai közötti navigáció.

A felhasználónak lehetősége van egy mindig látható menü segítségével a bankautomata menüpontjai
között navigálni kategóriákba sorolva. A megfelelő menüpontra kattintva megjelenik az adott 
kategóriához tartozó lehetőségek opciója.

A menüpont nevére való kattintással megjelenik a menü funkcionális adatlapja, amelyen 
megtalálhatóak a menüpont által nyújtott lehetőségek (ha elérhetőek). A menüpont leírása
alatt elérhetővé válik az adott kategórián belüli felhasználói regisztrációs lehetőség, 
pénzmennyiséget módosító opció illetve nem utolsó sorban az egyenleget lekérdezdő opció, 
illetve a bejelentkező felület menüpontja. A felhasználónak lehetősége van a menüpontokból 
való kilépésre is illetve magából a bankaoutómatából való kijelentkezére/kilépésre is. 

A felhasználónak lehetősége van a pénzmennyiségének módosítására illetve az egyenlegének 
lekérdezésére illetve a bankautomatába való regisztrációra egy erre szolgáló állandóan 
elérhető szövegmező használatával. Egy külön oldalon megjelennek azon beágyazott menüpontok 
amelyek csak a menük közötti navigáció álltal érhető el. Az autómata a felhasználó álltal 
bevitt pénzösszeget egy erre külön implementált JSON fájlban tárolja amelyhez magának a 
felhasználónak nincsen közvetlen (menüpontból) való hozzáférése. 

**2. Regisztráció:**

A felhasználók a Bank Automata használatának előfeltétele az előzetes regisztráció. 
A főbb és bizonyos egyéb funkciók is csak regisztráció után válnak elérhetővé. 
Erre egy külön ablakban (az első ablak) van lehetőség.
           
**Az űrlap tervezett mezői:**

(A csillaggal megjelölt mezők kitöltését kötelezővé tennénk)

Vezetéknév*, Keresztnév*, Cégnév, Telefon, Szállítási cím*, Számlázási cím, 
Felhasználónév*, Jelszó*, Jelszó mégegyszer*, Email cím*
A megadott adatok egy JSON fileban kerülneknének tárolásra.

**3. Bejelentkezés:**

A regisztráció során megadott felhasználó névvel és jelszóval lehetőség nyílik a 
bejelentkezésre, amely ugyancsak a Bank Automata valamint bizonyos funkciók elérésének 
feltétele. Ha a felhasználónév vagy a jelszó hibás, akkor kiírja, hogy helytelen felhasználónév 
vagy jelszó. Erre egy külön bejelentkező ablakban van lehetőség, amely két szövegmezőt tartalmaz:

- Felhasználónév
- Jelszó

A bejelentkezés után elérhető funkciók:

- A pénzfeltöltés 
- a pénz kivétele 
- az egyenleg lekérdezése és a kilépés. 

**4. Főmenü**

Amikor a főmenü felépítéséről beszélünk, azt mondhatjuk, hogy érthető és egyszerű. A rendszerhez 
napi szinten akár több akár 100 felhasználó fog hozzáférni ezért igazán fontosak az imént említett jellemzők. 
A sikeres bejelentkezést követően kerül a felhasználó elé a főmenü. A főmenü főként gombokat tartalmaz, 
a gombok erősebb körvonala és színe szembetűnőbbé teszi a háttérhez képest, illetve a gomb körvonala 
közrefog egy egyszavas kifejezést, amely a gomb funkciójára utal. A következő gombok találhatók a 
főmenü ablakán: Pénzfeltöltés, Pénzfelvétel, Egyenleg. A Pénzfeltöltés gomb funkciója, mint ahogy a 
nevéből is érthető, pénz feltöltése a felhasználó számlájára. A gombot megnyomva a felhasználó 
szembetalálja magát a Pénzfeltöltés ablakkal. Itt két egymás alatt elhelyezkedő szövegmező található, 
illetve egy alattuk lévő OK gomb és a jobb felső sarokban található az ablak bezárásra szolgáló kilépés 
gomb (x). Az felső szövegmező az, ahova a felhasználó beírhatja a feltölteni kívánt pénzösszeget. 
Funkcióját a mező fölött lévő „Kérem ide írja a pénzösszeget” szöveg is jelzi. Az alatta lévő mező 
a jelszó mező, feladata az autentikáció. A pénzfeltöltés esetén a felhasználónak a jelszavát is meg 
kell adni a pénzfeltöltés érdekében. Miután a felhasználó beírta a megfelelő adatokat az OK gomb 
megnyomásával teljesíthető a pénzfeltöltés. Helytelen jelszó esetén a pénzfeltöltés sikertelen lesz 
és pirossal kiírja azt, hogy: „Helytelen jelszó”.

A főmenüben lévő másik gomb megnevezése Pénzfelvétel. Mint ahogy a neve is sugallja, funkciója a 
pénzfelvétel. Megnyomása után megjelenik a Pénzfelvétel ablak. Felépítése hasonló a Pénzfeltöltés 
ablakhoz. Két egymás alatt elhelyezkedő szövegmező, a céljukat jelző fölöttük lévő pár szavas segédlet, 
alattuk lévő OK gomb és a jobb felső sarokban elhelyezkedő bezárás (x) gomb. A felvenni kívánt összeg 
és a jelszó beírása után az OK gombra kattintva teljesíthető a pénzfelvétel, azonban helytelen összeg 
beírása esetén, azaz ha a beírt összeg több mint számlán elérhető pénzösszeg, akkor „Helytelen érték” 
hibaüzenetet kapunk és nem megy végbe a
