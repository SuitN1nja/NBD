import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    // 1
    val DniTygodnia = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

    // 1a
    println("Zadanie 1a")
    zad1a(DniTygodnia)

    // 1b
    println("Zadanie 1b")
    println(zad1b(DniTygodnia))

    // 1c
    println("Zadanie 1c")
    println(zad1c(DniTygodnia))

    // 2a
    println("Zadanie 2a")
    println(zad2a(DniTygodnia))
    // 2b
    println("Zadanie 2b")
    println(zad2b(DniTygodnia))

    // 3
    println("Zadanie 3")
    println(zad3(DniTygodnia))

    // 4a
    println("Zadanie 4a")
    println(zad4a(DniTygodnia))

    // 4b
    println("Zadanie 4b")
    println(zad4b(DniTygodnia))

    // 4c
    println("Zadanie 4c")
    println(zad4c(DniTygodnia))

    // 5
    println("Zadanie 5")
    val produkty = Map("Jajka" -> 2, "Chleb" -> 3, "Pomidory" -> 4)
    val SprzedazProduktow = produkty map { case (key, value) => (key, value * 1.1) }
    println(SprzedazProduktow)

    // 6
    println("Zadanie 6")
    zad6("Pan da Cztery", 4, DniTygodnia)

    // 7
    println("Zadanie 7")

    val CenaJajka = produkty.get("Jajka")
    println(CenaJajka)

    val CenaMasla = produkty.get("Maslo")
    println(CenaMasla)

    // 8
    println("Zadanie 8")
    val intList = List(1, 0, 3, -3, 0, 8, 0, 9, 1, 1, 0)
    println(zad8(intList))


    // 9
    println("Zadanie 9")
    println(zad9(intList))

    // 10
    println("Zadanie 10")
    val biggerIntList = List(-100, -6, -5, -3, 2, 0, 1, 2, 3, 4, 5, 6, 8, 15, 20, 300)
    println(zad10(biggerIntList))
  }

  def zad1a(DniTygodnia: List[String]) = {
    var polaczString = "";
    for (i <- 0 until DniTygodnia.length) {
      if (polaczString != "")
        polaczString += ", " + DniTygodnia.get(i)
      else
        polaczString += DniTygodnia.get(i)
    }
    println(polaczString)

  }

  def zad1b(DniTygodnia: List[String]) = {
    var polaczString = "";
    for (i <- 0 until DniTygodnia.length) {
      breakable {
        if (!DniTygodnia.get(i).startsWith("P")) break
        if (polaczString != "")
          polaczString += ", " + DniTygodnia.get(i)
        else
          polaczString += DniTygodnia.get(i)
      }


    }
    polaczString;
  }

  def zad1c(DniTygodnia: List[String]) = {
    var polaczString = ""
    var index = 0;
    while (index < DniTygodnia.length) {
      if (polaczString != "")
        polaczString += ", " + DniTygodnia.get(index)
      else
        polaczString += DniTygodnia.get(index)

      index = index + 1;
    }

    polaczString
  }

  def zad2a(DniTygodnia: List[String]) = {
    def DodajDzien(i: Int): String = {
      if (i == DniTygodnia.length) return ""

      val dzien = if (i == DniTygodnia.length - 1) DniTygodnia.get(i) else DniTygodnia.get(i) + ", "

      dzien + DodajDzien(i + 1)
    }

    DodajDzien(0);
  }

  def zad2b(DniTygodnia: List[String]): String = {
    def DodajDzien(i: Int): String = {
      if (i == -1) return ""

      val dzien = if (i == 0) DniTygodnia.get(i) else DniTygodnia.get(i) + ", "

      dzien + DodajDzien(i - 1)
    }

    DodajDzien(DniTygodnia.length - 1)
  }

  def zad3(DniTygodnia: List[String]) = {
    @tailrec
    def DodajDzien(i: Int, polaczString: String) : String = {
      if (i == DniTygodnia.length) return polaczString

      val dzien = if (i == DniTygodnia.length - 1) DniTygodnia.get(i) else DniTygodnia.get(i) + ", "

      DodajDzien(i + 1, polaczString + dzien)
    }
    DodajDzien(0, "")
  }

  def zad4a(DniTygodnia: List[String]) : String = {
    DniTygodnia.fold("") {(sum, curr) => {
      sum + curr + ", "
    }}.dropRight(2)
  }

  def zad4b(DniTygodnia: List[String]) : String = {
    DniTygodnia.foldRight("") {(sum, curr) => {
      sum + ", " + curr
    }}.dropRight(2)
  }

  def zad4c(DniTygodnia: List[String]) : String = {
    DniTygodnia.fold("") {(sum, curr) => {
      if (curr.startsWith("P"))
        sum + curr + ", "
      else sum

    }}.dropRight(2)
  }

  def zad6(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }

  def zad8(intList: List[Int]): List[Int] = {
    def iter(index: Int, currentList: List[Int]): List[Int] = {
      if (index >= currentList.length) return currentList;

      val (part1, part2) = currentList.splitAt(index)

      if (currentList.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, currentList)
    }


    iter(0, intList)
  }

  def zad9(intList: List[Int]): List[Int] = {
    intList map (el => el + 1)
  }

  def zad10(intList: List[Int]): List[Int] = {
    val filteredList = intList filter (el => el >= -5 && el <= 12)

    filteredList map (el => el.abs)
  }
}
