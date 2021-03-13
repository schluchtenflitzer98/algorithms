#include <iostream>
#include <math.h>

using namespace std;

int findIndex(int *arr, int value, int range)
{
    int search = 0;
    for (int i = 0; i < range; i++)
    {
        if (arr[i] == value)
        {
            search = i;
            break;
        }
    }
    return search;
}

int main()
{
    //Einlesen
    int range = 0;
    std::cout << "Reichweite (Start = 2) bis zu welchen Ermittel werden sollen: ";
    std::cin >> range;

    int *arr = new int[range]; //Speicherplatz reservieren

    //Initialisieren
    for (int i = 0; i < range; i++)
    {
        arr[i] = i + 1;
    }

    // Erste Ausgabe in 10er Blöcke
    std::cout << "Zahlen: " << std::endl;
    for (int i = 0; i < range; i++)
    {
        std::cout << "\t" << arr[i];
        if (arr[i] % 10 == 0)
        {
            std::cout << std::endl;
        }
    }

    //Berechnung
    int multiplier = 2;
    int index = 0;
    int index_range = 1; // 1 überspringen weil

    arr[0] = NULL; // 1 ist keine Primzahl

    while (index_range != 0 && arr[index_range] <= sqrt(range)) //Verarbeitung bis zur Wurzel(range), weiter nicht nötig
    {
        multiplier = 2;
        while ((arr[index_range] * multiplier) <= range) // Multipliziere aktuelle Zahl auf bis Range überschritten
        {
            arr[findIndex(arr, arr[index_range] * multiplier, range)] = NULL; //Hole (falls vorhanden) Index der zustreichenden Zahl und streich diese
            multiplier++;
        }

        do // index_range muss über Schleife hochgezogen werden, da nachfolge NULL sein kann und gültiger Wert benötigt wird
        {
            if (index_range == range)
            {
                index_range = 0; //Ende der Verarbeitung, da Range aufgebraucht
            }
            else
            {
                index_range++;
            }
        } while (arr[index_range] == NULL);
    }

    //Ausgabe in 10er Blöcke
    std::cout << std::endl
              << std::endl
              << "Primzahlen: " << std::endl;

    for (int i = 0; i < range; i++)
    {
        if (arr[i] == NULL)
        {
            std::cout << "\t"
                      << "NULL";
        }
        else
        {
            std::cout << "\t" << arr[i];
        }
        if ((i + 1) % 10 == 0)
        {
            std::cout << std::endl;
        }
    }

    std::cout << std::endl;

    return 0;
}
