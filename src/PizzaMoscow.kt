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
            totalCheckPhoto++
            sumSale += 50
        } else {
            checkNotShown++
        }
    }
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }
}