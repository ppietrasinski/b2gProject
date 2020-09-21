Treść zadania do wykonania:

Poniżej kroki do zadania z zakresu automatyzacji z wykorzystaniem Selenium oraz języka Java:
 
1.	wchodzimy na strone www.allegro.pl
2.	wpisujemy w wyszukiwarke Iphone 11
3.	wybieramy kolor czarny
4.	zliczamy ilość wyświetlonych telefonów na pierwszej stronie wyników i ilość prezentujemy w consoli
5.	szukamy największej ceny na liście i wyświetlamy w konsoli
6.	do największej ceny dodajemy 23% 

Jak będzie miał Pan/Pani gotowy skrypt, to proszę go wyexportować lub wrzucić gdzieś do Gita i podać linka


Co musimy mieć zainstalowane, aby skrypt działał prawidłowo

1.	Język programowania java
2.	maven

Struktura skryptu

W pliku src/main/resources/configuration.properties znajduje się konfiguracja testu, kiedy zmienimy wartość local.browser na FIREFOX, testy włączą się w przeglądarce Firefox

W pliku src/main/resources/log4j2.xml znajduje się konfiguracja loggera

W katalogu src/test/java znajduje się główna część projektu podzielona na paczki i klasy.
- w paczce configuration znajdują się klasy odpowiedzialne na pobieranie danych z pliku configuration.properties
- w paczce driver znajdują się klasy odpowiedzialne za zarządzanie WebDriverem oraz za dobór przeglądarki 
- w paczce navigation znajduje się klasa odpowiedzialna za przechowywanie adresów URL. Jako że w naszym teście aktualnie korzystamy tylko z jednego adresu, pobierany on jest z pliku configuration.properties . W razie potrzeby rozwinięcia testów, można w tym pliku dodawać kolejne adresy przez dodawanie nowych danych do adresu np: 
public static final String PRODUCT_PAGE_URL = APPLICATION_URL + "/product";

- w paczce page.objects znajdują się obiekty stron (page objety) wykorzystywane podczas testów. Każdy page object składa się z konstruktora z metodą PageFactory inicjującą wzorzec Page Factory, z webelementów inicjowanych przez PageFactory znalezionych przy pomocy adnotacji @FindBy, oraz metody testowe wykorzystywanych w testach. Dzięki temu że niektóre metody zwracają obiekty innych klas możlwie jest wykorzystanie w teście Fluent interface’u
W tej paczce jest też klasa TestHelper w które znajdują się metody pomocnicze do edycji i konwersji list i zmiennych używane w teście.
- w paczce test znajdują się pliki z właściwym testem AllegroSearchTest, klasa TestBase która zawiera w sobie metody Before Class, Before Method oraz After Method które włączają się odpowiednio przed praz po teście oraz klasa TestHelper która zawiera w sobie metody pomocnicze, edytujące listy, zmienne liczbowe i Stringi. Klasa AllegroSearchTest jest rozszerzana przez klasę BaseTest, dzięki czemu to, co jest w klasie BaseTest zostanie wykonane przed oraz po metodzie testowej z klasy AllegroSearchTest.
- w paczce WaitForElement znajdują się metody służące do oczekiwania na WebElementy, Tych metod używa się do „czekania” przez test aż element będzie widoczny lub możliwy do kliknięcia. Używa się ich w metodach z klasy page.object
- w paczce resources znajduje się plik .xml który ma za zadanie wskazać jakie klasy testowe zostaną wykonane po wpisaniu komendy „mnv clean test” w terminalu. To ten plik jest wskazany na sztywno w pliku pom.xml przez co nie ma potrzeby wpisywania ścieżki to pliku z test suit’em. Oczywiście w pliku pom.xml można to zmienić i ustawić możliwość wyboru pliku konfiguracyjnego jednak na potrzeby tego testu nie ma takiej potrzeby


O teście

Test zapisany jest w paczce src/test/java/tests/AllegroSearchTest.java w tej klasie znajduje się skrypt który, przy pomocy klas page.object’ów oraz metod z klasy TestHelper wykonuje zadanie.
Test można było podzielić na mniejsze testy, ale nie zostało to zrobione, aby uniknąć włączania się WebDrivera po raz kolejny tylko po to, aby mogły zostać wykonane potrzebne obliczenia. Zazwyczaj testy powinny być jak najmniejsze, sprawdzające jedną specyficzną funkcjonalność ale w tym konkretnym przypadku mogło by to wydłużyć czas egzekucji testu co nie jest pożądane. Aby test był testem dodano też trzy nadprogramowe asercje do których wykorzystano bibliotekę assertj.

Pliki chromedriver oraz geckodriver

Znajdują się w folderze tools i są zapisane w repozytorium. W pliku configuration.properties znajduje się odniesienie bezpośrednio do tego folderu, przez co test powinien działać bez przeszkód. Wersja chromedrivera wspiera przeglądarkę Chrome w wersji 85
Geckodriver wspiera przeglądarkę Firefox w wersji 80.0

Aktualnie skrypt działa tak, że:

- włącza się webdriver i następuje jego konfiguracja
- włącza się strona https://allegro.pl/
- wyszukiwany jest produkt iPhone 11
- włączany jest filtr czarnego koloru
- pobierana jest lista cen wszystkich konkretnych elementów widocznych na stronie
- dane te są przetwarzane przez metody z klasy TestHelper
- dane są wyświetlane w konsoli 

output w konsoli powinien wyglądać tak:

http://prntscr.com/ulasah 
na czerwono zaznaczone wymagane w zadaniu dane które powinny być wyświetlone w konsoli.


O lokatorach

Strona allegro posiada bardzo dziwne lokatory. Są to bardzo złożone klasy i dlatego też głównymi lokatorami użytymi do znajdowania elementów są xpath’y wyszukujące klasy. Generalnie najbardziej pożądanymi lokatorami są id, name, xpath oraz CSSselector ale akurat w tym przypadku najłatwiej było korzystać z xpath’ów


Włączenie skryptu:
konsola -> będąc w konsoli przechodzimy do folderu, w którym znajduje się plik pom.xml naszego projektu i wpisujemy komendę „mvn clean test”
