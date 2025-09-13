class PizzaMoscow (
     neapolitanPizzaPrice: Double,  romanPizzaPrice: Double,
     sicilianPizzaPrice: Double,  tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
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
        }
    }
    override fun neapolitanPizzaSale() {
        incrementNeapolitanPizzaCount()
        setCurrentPizzaType(0)
        setCurrentOrderPizzaPrice(neapolitanPizzaPrice)
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        incrementRomanPizzaCount()
        setCurrentPizzaType(1)
        setCurrentOrderPizzaPrice(romanPizzaPrice)
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        incrementSicilianPizzaCount()
        setCurrentPizzaType(2)
        setCurrentOrderPizzaPrice(sicilianPizzaPrice)
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        incrementTyroleanPizzaCount()
        setCurrentPizzaType(3)
        setCurrentOrderPizzaPrice(tyroleanPizzaPrice)
        println("Спасибо за покупку тирольской пиццы в Москве")
    }
}