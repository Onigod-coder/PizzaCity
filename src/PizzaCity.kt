abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0
    var totalCoffeeSold = 0
    var totalCheckPhoto = 0
    var totalCoffeeSoldRubles = 0
    var checkNotShown = 0
    var sumSale = 0
    var coffeeSales = IntArray(4)
    var sauceCountTomato = 0
    var sauceCountCheese = 0
    var tomato = 0
    var cheese = 0





    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    open fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        val pizzaNames = arrayOf("Неаполитанская", "Римская", "Сицилийская", "Тирольская")
        val totalCount = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        val sauceSum= cheese + tomato
        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice +
                totalCoffeeSoldRubles - sumSale + sauceSum
        println("Всего заработано денег: $money")
        val coffeePercent = (totalCoffeeSold.toDouble() / totalCount.toDouble()) * 100
        if (totalCoffeeSold >0){
        println("Кофе продано: $totalCoffeeSold \nВыручка с кофе: $totalCoffeeSoldRubles")
            println("Процент купивших кофе: $coffeePercent ")
            println("Статистика продаж кофе: ")

            for (i in coffeeSales.indices) {
                val count = coffeeSales[i]
                val percentage = if (totalCount > 0) (count.toDouble() / totalCount * 100) else 0.0
                println("${pizzaNames[i]}:  Продано кофе: $count  (${String.format("%.2f", percentage)}%)")

            }
        }
        if (totalCheckPhoto>0){
        println("Скидок сделано: $totalCheckPhoto \nСкидок выдано на: $sumSale рублей")
        }


            val checkShow = (totalCheckPhoto.toDouble() / totalCount) * 100
            val totalCheckNotShown = (checkNotShown.toDouble() / totalCount) * 100
        if (checkShow >0){
            println("Процент показавших чек: $checkShow")
            println("Процент не показавших чек: $totalCheckNotShown")
            }




       if(sauceCountCheese > 0 || sauceCountTomato >0) {
           println("Купили Кетчупа: $sauceCountTomato \nСырного: $sauceCountCheese \nНа общую сумму: $sauceSum")
       }
    }

}