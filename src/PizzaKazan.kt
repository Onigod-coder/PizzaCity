class PizzaKazan (
    neapolitanPizzaPrice: Double,  romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,  tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto, Drink, Sauce {
    
    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да \n2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")
            incrementTotalCoffeeSold()
            addTotalCoffeeSoldRubles(200)
            setCurrentOrderCoffeePrice(200)
            if (getCurrentPizzaType() >= 0) {
                incrementCoffeeSales(getCurrentPizzaType())
            }
        } else {
            incrementCoffeeNotSold()
            println("Вы отказались от кофе.")
        }
    }
    
    override fun showCheckPhoto() {
        println("У вас есть фото чека?")
        println("1. Да \n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            incrementTotalCheckPhoto()
            addSumSale(50)
            setCurrentOrderDiscount(50)
        } else {
            incrementCheckNotShown()
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
                    addCheese(35)
                    incrementSauceCountCheese()
                    setCurrentOrderSaucePrice(35)
                    println("Вы выбрали сырный соус. Добавлено 35 рублей к вашему заказу.")
                }
                "2" -> {
                    addTomato(30)
                    incrementSauceCountTomato()
                    setCurrentOrderSaucePrice(30)
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
        incrementNeapolitanPizzaCount()
        setCurrentPizzaType(0)
        setCurrentOrderPizzaPrice(neapolitanPizzaPrice)
        println("Спасибо за покупку неаполитанской пиццы в Казани")
    }

    override fun romanPizzaSale() {
        incrementRomanPizzaCount()
        setCurrentPizzaType(1)
        setCurrentOrderPizzaPrice(romanPizzaPrice)
        println("Спасибо за покупку римской пиццы в Казани")
    }

    override fun sicilianPizzaSale() {
        incrementSicilianPizzaCount()
        setCurrentPizzaType(2)
        setCurrentOrderPizzaPrice(sicilianPizzaPrice)
        println("Спасибо за покупку сицилийской пиццы в Казани")
    }

    override fun tyroleanPizzaSale() {
        incrementTyroleanPizzaCount()
        setCurrentPizzaType(3)
        setCurrentOrderPizzaPrice(tyroleanPizzaPrice)
        println("Спасибо за покупку тирольской пиццы в Казани")
    }
}
