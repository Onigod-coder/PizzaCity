class PizzaNovgorod (
    neapolitanPizzaPrice: Double,  romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,  tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), Drink, CheckPhoto, Sauce {
    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да \n2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")

            totalCoffeeSold++
            totalCoffeeSoldRubles += 200
        } else {
            println("Вы отказались от кофе.")
        }

    }
    override fun showCheckPhoto() {
        println("У вас есть фото чека?")
        println("1. Да \n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            totalCheckPhoto++
            sumSale += 50
        } else {
            checkNotShown++
            println("Вы отказались показать чек.")

        }
    }
    override fun giveSauce() {
        println("Желаете соус?")
        println("1. Да \n2. Нет")
        if (readln() == "1") {
            println("1. Сырный \n2. Кетчуп \n3. Отмена")
            when (readln()) {
                "1" -> {
                    cheese += 35
                    sauceCountCheese++
                    println("Вы выбрали сырный соус. Добавлено 35 рублей к вашему заказу.")
                }
                "2" -> {
                    tomato += 30
                    sauceCountTomato++
                    println("Вы выбрали кетчуп. Добавлено 30 рублей к вашему заказу.")
                }
                "3" -> {
                    println("Отмена")

                }
                else -> {
                    println("Неверный выбор. Возврат в меню выбора соуса.")
                }
            }
        } else {
            println("Вы отказались от соуса.")
            return
        }

    }



    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        coffeeSales[0]++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        coffeeSales[1]++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        coffeeSales[2]++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        coffeeSales[3]++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}