import scala.annotation.tailrec
object Main extends App {

  // Zadanie 1
  def DniTygodnia(day: String): String = day match {
    case "sobota" | "niedziela"                                      => "weekend"
    case "poniedzialek" | "wtorek" | "sroda" | "Czwartek" | "piatek" => "praca"
    case _                                                          => "Taki dzien nie istnieje"
  }
  println(
    "poniedzialek to " + DniTygodnia("poniedzialek")
  )
  println(
    "sobota to " + DniTygodnia("sobota")
  )
  println(
    "Dzien w ktorym polski klub wygywa LM to " + DniTygodnia("Dzien w ktorym polski klub wygywa LM")
  )
  // Zadanie 2
  class KontoBankowe(private var balans: Int = 0) {
    def wplata(zmiana: Int): Unit = {
      balans += zmiana
    }
    def wyplata(zmiana: Int): Unit = {
      balans -= zmiana
    }
    def stanKonta(): Int = {
      balans
    }
  }


  // Zadanie 3
  case class Osoba(var name: String, var surname: String)
  val ja = new Osoba("Filip", "Dudkiewicz")
  val ziomekZalk = new Osoba("Michal", "Fortuna")
  val LadnaPani = new Osoba("Marta", "Zozol")
  def powitanie(someone: Osoba): String = someone match {
    case Osoba(name, "Fortuna") =>
      s"Witam Panie/Pani $name"
    case Osoba("Filip", "Dudkiewicz") => s"Yo Fifi"
    case Osoba("Marta", "Zozol")  => s"Hejka Zozolku"
  }
  println(powitanie(ja))
  println(powitanie(ziomekZalk))
  println(powitanie(LadnaPani))
  // Zadanie 4
  def trzykrotnosc(value: Int, liczonko: (Int) => Int): Int = {
    liczonko(liczonko(liczonko(value)))
  }
  println(trzykrotnosc(5, a => a + 1))
  println(trzykrotnosc(9, a => a * 2))
  // Zadanie 5
  trait student extends Osoba_2 { override def podatek = 0 }
  trait pracownik extends Osoba_2 {
    var _pensja: Integer = 0
    def pensja() {
      _pensja
    }
    def pensja_=(new_pensja: Integer): Unit = {
      _pensja = new_pensja
    }
    override def podatek: Double =
      0.2 * _pensja.toDouble
  }
  trait Nauczyciel extends pracownik {
    override def podatek = 0.1 * _pensja
  }

  abstract class Osoba_2(
                           val name: String,
                           val surname: String
                         ) {
    def podatek(): Double
  }
  var Osoba_1 = new Osoba_2("Pan", "Kracy") with student
  var Osoba_2 = new Osoba_2("Ziutek", "Ziutowski") with pracownik
  Osoba_2._pensja = 500
  var Osoba_3 = new Osoba_2("Stefan", "Podloga") with Nauczyciel
  var Osoba_4 = new Osoba_2("Horacy", "Hrwacy") with student with pracownik
  var Osoba_5 = new Osoba_2("Ireneusz", "Jelen") with pracownik with student
  Osoba_4._pensja = 5200
  Osoba_5._pensja = 4500

  def print_Osoba(Osoba: Osoba_2): Unit = {
    println(s"${Osoba.name} podatek : ${Osoba.podatek}")
  }
  print_Osoba(Osoba_4)
  print_Osoba(Osoba_5)
}
