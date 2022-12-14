import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pracownik {

    public String imie;
    public String nazwisko;
    private String plec;
    private Integer placa;
    private Integer dzial;

    public Pracownik(String imie, String nazwisko, String plec, Integer placa, Integer dzial){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.placa = placa;
        this.dzial = dzial;
    }

    public static List<Pracownik> wczytajZPliku(String nazwaPliku, List<Pracownik> pracownicy) throws FileNotFoundException {
        File file = new File(nazwaPliku);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] liniaPracownik = line.split(" ");
            List<String> pracownik = Arrays.asList(line.split(" "));
            Pracownik nowy = new Pracownik(pracownik.get(0), pracownik.get(1),
                    pracownik.get(2), Integer.valueOf(pracownik.get(3)), Integer.valueOf(pracownik.get(4)));
            pracownicy.add(nowy);
        }
        return pracownicy;
    }

    public static Integer srednieZarobki (List<Pracownik> pracownicy, String plec, Integer dzial){
        Integer liczba = 0;
        Integer suma = 0;
        for (Pracownik pracownik: pracownicy) {
            if (pracownik.plec.equals(plec) && pracownik.dzial.equals(dzial)){
                liczba++;
                suma += pracownik.placa;
            }
        }
        Integer srednia = suma/liczba;
        return srednia;
    }

    public static void zapisDoPliku(String nazwaPliku, List<Pracownik> pracownicy) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(nazwaPliku);
        for (Pracownik pracownik: pracownicy) {
            zapis.println(pracownik.imie + " " + pracownik.nazwisko + " "
                    + pracownik.plec + " " + pracownik.placa + " " + pracownik.dzial);
        }
        zapis.close();
    }
    @Override
    public String toString() {
        String message = "Pracownik: " + this.imie + " " + this.nazwisko + "\n"
                + "Plec: " + this.plec + "\n"
                + "Zarobki: " + this.placa + "\n"
                + "Dzial: " + this.dzial;
        return message;
    }

    public Boolean czyPracujeWDziale(Integer dzial) {
        if (this.dzial.equals(dzial)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}




//PRACOWNICY
//
//        Napisa?? program do zarz??dzania danymi pracownik??w. W tym celu nale??y utworzy?? klas??
//        Pracownik z nast??puj??cymi polami:
//        imi?? ??? typu String;
//        nazwisko ??? typu String;
//        placa ??? typu Integer;
//        plec ??? typu String;
//        dzial ??? typu Integer;
//        1. Klas?? t?? wyposa??y?? w konstruktor, kt??rego parametry umo??liwi?? przypisanie warto??ci
//        wszystkim polom klasy.
//        2. W klasie Pracownik stworzy?? statyczn?? funkcj?? wczytajZPlikuTekstowego, kt??rej zadaniem
//        jest odczytanie danych pracownik??w zapisanych w pliku tekstowym i utworzenie dla nich
//        obiekt??w klasy Pracownik. Dane zapisane s?? w formacie:
//        Imi?? Nazwisko P??aca P??e?? Nr dzia??u
//        Przyk??ad
//        Jan Kowalski 2010 M 3
//        Agnieszka Cuber 2900 K 3
//        Adam Nowak 1100 M 4
//        Sylwia Zych 2100 K 3
//        Beata Dudek 1900 K 4
//        Metoda wczytajZPlikuTekstowego przyjmuje 2 parametry:
//        ??? nazw?? pliku tekstowego z danymi pracownik??w,
//        ??? Liste do przechowywania wczytanych obiekt??w klasy Pracownik
//        Metoda powinna zwrocic Liste pracownikow odczytanych. (Integer) (List.size())
//        3. Napisa?? metod?? statyczn?? o nazwie srednieZarobki, kt??rej parametrem jest tablica
//        pracownik??w, numer dzia??u oraz p??e??, a wynikiem ??rednia p??aca os??b pracuj??cych w dziale
//        o podanym numerze oraz o podanej p??ci
//        Przyk??adowo wynikiem metody srednieZarobki dla kobiet z dzia??u 3 w podanym
//        przyk??adzie powinna by?? warto???? 2500.
//        4. Napisa?? statyczn?? metod?? zapiszDoPliku, kt??rej zadaniem b??dzie zapisanie obiekt??w
//        (serializacja) typu pracownik do pliku o nazwie podanej jako pierwszy parametr. Drugim
//        parametrem jest tablica obiekt??w typu Pracownik, kt??re powinny zapisane do pliku.
//        5. Napisa?? statyczn?? metod?? odczytZPliku, kt??rej zadaniem b??dzie wczytanie tablicy
//        obiekt??w z pliku (zapisanych metod?? zapiszDoPliku).
//        String.split(" ")
//        6. Napisac metod?? toString (nadpisanie metody z klasy Object), kt??ra zwraca ??a??cuch zawieraj??cy dane
//        pracownika;
//        7. Napisac metod?? czyPracujeWDziale, kt??ra zwraca true, je??eli pracownik pracuje w dziale o
//        podanym numerze