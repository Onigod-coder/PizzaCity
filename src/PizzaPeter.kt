class PizzaPeter (
     neapolitanPizzaPrice: Double,  romanPizzaPrice: Double,
     sicilianPizzaPrice: Double,  tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
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



    override fun neapolitanPizzaSale() {
        incrementNeapolitanPizzaCount()
        setCurrentPizzaType(0)
        setCurrentOrderPizzaPrice(neapolitanPizzaPrice)
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        incrementRomanPizzaCount()
        setCurrentPizzaType(1)
        setCurrentOrderPizzaPrice(romanPizzaPrice)
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        incrementSicilianPizzaCount()
        setCurrentPizzaType(2)
        setCurrentOrderPizzaPrice(sicilianPizzaPrice)
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        incrementTyroleanPizzaCount()
        setCurrentPizzaType(3)
        setCurrentOrderPizzaPrice(tyroleanPizzaPrice)
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}