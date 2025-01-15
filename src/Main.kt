import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaPeter(
        neapolitanPizzaPrice = 175.0, romanPizzaPrice = 241.5,
        sicilianPizzaPrice = 167.5, tyroleanPizzaPrice = 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        neapolitanPizzaPrice = 215.0, romanPizzaPrice = 250.5,
        sicilianPizzaPrice = 180.5, tyroleanPizzaPrice = 240.0
    )
    val pizzaNovgorod = PizzaNovgorod(neapolitanPizzaPrice = 300.0, romanPizzaPrice = 300.5,
        sicilianPizzaPrice = 600.5, tyroleanPizzaPrice = 700.0)
    var currentPizzaCity:PizzaCity


    while (true) {
        println("Добрый день! Выберете город")
        println("1. Москва \n2. Санкт-Петербург \n3. Нижний Новгород \n4. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaNovgorod
            "4" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("Выберете пиццу:")
        println("1. Неаполитанская \n2. Римская \n3. Сицилийская \n4. Тирольская\n\n 0. Показать статистику")

        selectPizza(currentPizzaCity)

    }
}
fun selectAddService(currentPizzaCity: PizzaCity) {
    if (currentPizzaCity is CheckPhoto) {
        currentPizzaCity.showCheckPhoto()
    }


    if (currentPizzaCity is Drink) {
        currentPizzaCity.drinkSale()
    }


    if (currentPizzaCity is Sauce) {
        currentPizzaCity.giveSauce()

    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)


        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()

        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}