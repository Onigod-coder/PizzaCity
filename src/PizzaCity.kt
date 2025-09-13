abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    private var neapolitanPizzaCount = 0
    private var romanPizzaCount = 0
    private var sicilianPizzaCount = 0
    private var tyroleanPizzaCount = 0
    private var totalCoffeeSold = 0
    private var totalCheckPhoto = 0
    private var totalCoffeeSoldRubles = 0
    private var checkNotShown = 0
    private var coffeeNotSold = 0
    private var sumSale = 0
    private var coffeeSales = IntArray(4)
    private var sauceCountTomato = 0
    private var sauceCountCheese = 0
    private var tomato = 0
    private var cheese = 0
    private var currentPizzaType = -1 // 0-неаполитанская, 1-римская, 2-сицилийская, 3-тирольская
    
    // Поля для отслеживания текущего заказа
    private var currentOrderPizzaPrice = 0.0
    private var currentOrderCoffeePrice = 0
    private var currentOrderSaucePrice = 0
    private var currentOrderDiscount = 0
    
    // Геттеры для доступа к приватным полям
    protected fun getNeapolitanPizzaCount() = neapolitanPizzaCount
    protected fun getRomanPizzaCount() = romanPizzaCount
    protected fun getSicilianPizzaCount() = sicilianPizzaCount
    protected fun getTyroleanPizzaCount() = tyroleanPizzaCount
    protected fun getTotalCoffeeSold() = totalCoffeeSold
    protected fun getTotalCheckPhoto() = totalCheckPhoto
    protected fun getTotalCoffeeSoldRubles() = totalCoffeeSoldRubles
    protected fun getCheckNotShown() = checkNotShown
    protected fun getCoffeeNotSold() = coffeeNotSold
    protected fun getSumSale() = sumSale
    protected fun getCoffeeSales() = coffeeSales
    protected fun getSauceCountTomato() = sauceCountTomato
    protected fun getSauceCountCheese() = sauceCountCheese
    protected fun getTomato() = tomato
    protected fun getCheese() = cheese
    protected fun getCurrentPizzaType() = currentPizzaType
    protected fun getCurrentOrderPizzaPrice() = currentOrderPizzaPrice
    protected fun getCurrentOrderCoffeePrice() = currentOrderCoffeePrice
    protected fun getCurrentOrderSaucePrice() = currentOrderSaucePrice
    protected fun getCurrentOrderDiscount() = currentOrderDiscount
    
    // Сеттеры для изменения приватных полей
    protected fun incrementNeapolitanPizzaCount() { neapolitanPizzaCount++ }
    protected fun incrementRomanPizzaCount() { romanPizzaCount++ }
    protected fun incrementSicilianPizzaCount() { sicilianPizzaCount++ }
    protected fun incrementTyroleanPizzaCount() { tyroleanPizzaCount++ }
    protected fun incrementTotalCoffeeSold() { totalCoffeeSold++ }
    protected fun incrementTotalCheckPhoto() { totalCheckPhoto++ }
    protected fun addTotalCoffeeSoldRubles(amount: Int) { totalCoffeeSoldRubles += amount }
    protected fun incrementCheckNotShown() { checkNotShown++ }
    protected fun incrementCoffeeNotSold() { coffeeNotSold++ }
    protected fun addSumSale(amount: Int) { sumSale += amount }
    protected fun incrementCoffeeSales(index: Int) { coffeeSales[index]++ }
    protected fun incrementSauceCountTomato() { sauceCountTomato++ }
    protected fun incrementSauceCountCheese() { sauceCountCheese++ }
    protected fun addTomato(amount: Int) { tomato += amount }
    protected fun addCheese(amount: Int) { cheese += amount }
    protected fun setCurrentOrderPizzaPrice(price: Double) { currentOrderPizzaPrice = price }
    protected fun setCurrentOrderCoffeePrice(price: Int) { currentOrderCoffeePrice = price }
    protected fun setCurrentOrderSaucePrice(price: Int) { currentOrderSaucePrice = price }
    protected fun setCurrentOrderDiscount(discount: Int) { currentOrderDiscount = discount }
    fun resetCurrentOrder() {
        currentOrderPizzaPrice = 0.0
        currentOrderCoffeePrice = 0
        currentOrderSaucePrice = 0
        currentOrderDiscount = 0
    }





    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()
    
    protected fun setCurrentPizzaType(type: Int) {
        currentPizzaType = type
    }
    
    // Метод для расчета общей суммы заказа
    fun calculateOrderTotal(): Double {
        return getCurrentOrderPizzaPrice() + getCurrentOrderCoffeePrice() + getCurrentOrderSaucePrice() - getCurrentOrderDiscount()
    }
    
    // Метод для отображения итоговой суммы заказа
    fun showOrderSummary() {
        println("\n=== ИТОГИ ЗАКАЗА ===")
        println("Пицца: ${getCurrentOrderPizzaPrice()} руб.")
        if (getCurrentOrderCoffeePrice() > 0) {
            println("Кофе: ${getCurrentOrderCoffeePrice()} руб.")
        }
        if (getCurrentOrderSaucePrice() > 0) {
            println("Соус: ${getCurrentOrderSaucePrice()} руб.")
        }
        if (getCurrentOrderDiscount() > 0) {
            println("Скидка: -${getCurrentOrderDiscount()} руб.")
        }
        val total = calculateOrderTotal()
        println("ИТОГО К ОПЛАТЕ: ${String.format("%.2f", total)} руб.")
        println("==================\n")
    }

    open fun showStatistics() {
        println("Продано сицилийской пиццы: ${getSicilianPizzaCount()}")
        println("Продано неаполитанской пиццы: ${getNeapolitanPizzaCount()}")
        println("Продано римской пиццы: ${getRomanPizzaCount()}")
        println("Продано тирольской пиццы: ${getTyroleanPizzaCount()}")
        val pizzaNames = arrayOf("Неаполитанская", "Римская", "Сицилийская", "Тирольская")
        val totalCount = getNeapolitanPizzaCount() + getRomanPizzaCount() + getSicilianPizzaCount() + getTyroleanPizzaCount()
        val sauceSum = getCheese() + getTomato()
        val money = getNeapolitanPizzaCount() * neapolitanPizzaPrice + getRomanPizzaCount() * romanPizzaPrice +
                getSicilianPizzaCount() * sicilianPizzaPrice + getTyroleanPizzaCount() * tyroleanPizzaPrice +
                getTotalCoffeeSoldRubles() - getSumSale() + sauceSum
        println("Всего заработано денег: $money")
        
        if (getTotalCoffeeSold() > 0 || getCoffeeNotSold() > 0) {
            val totalCoffeeOffers = getTotalCoffeeSold() + getCoffeeNotSold()
            val coffeePercent = if (totalCoffeeOffers > 0) (getTotalCoffeeSold().toDouble() / totalCoffeeOffers.toDouble()) * 100 else 0.0
            val coffeeRefusalPercent = if (totalCoffeeOffers > 0) (getCoffeeNotSold().toDouble() / totalCoffeeOffers.toDouble()) * 100 else 0.0
            
            println("Кофе продано: ${getTotalCoffeeSold()} \nВыручка с кофе: ${getTotalCoffeeSoldRubles()}")
            println("Процент купивших кофе: ${String.format("%.2f", coffeePercent)}%")
            println("Процент отказавшихся от кофе: ${String.format("%.2f", coffeeRefusalPercent)}%")
            
            if (getTotalCoffeeSold() > 0) {
                println("Статистика продаж кофе: ")
                for (i in getCoffeeSales().indices) {
                    val count = getCoffeeSales()[i]
                    val percentage = if (getTotalCoffeeSold() > 0) (count.toDouble() / getTotalCoffeeSold() * 100) else 0.0
                    println("${pizzaNames[i]}:  Продано кофе: $count  (${String.format("%.2f", percentage)}%)")
                }
            }
        }
        if (getTotalCheckPhoto() > 0 || getCheckNotShown() > 0) {
            val totalCheckOffers = getTotalCheckPhoto() + getCheckNotShown()
            val checkShowPercent = if (totalCheckOffers > 0) (getTotalCheckPhoto().toDouble() / totalCheckOffers.toDouble()) * 100 else 0.0
            val checkNotShownPercent = if (totalCheckOffers > 0) (getCheckNotShown().toDouble() / totalCheckOffers.toDouble()) * 100 else 0.0
            
            println("Скидок сделано: ${getTotalCheckPhoto()} \nСкидок выдано на: ${getSumSale()} рублей")
            println("Процент показавших чек: ${String.format("%.2f", checkShowPercent)}%")
            println("Процент не показавших чек: ${String.format("%.2f", checkNotShownPercent)}%")
        }




        if (getSauceCountCheese() > 0 || getSauceCountTomato() > 0) {
            println("Купили Кетчупа: ${getSauceCountTomato()} \nСырного: ${getSauceCountCheese()} \nНа общую сумму: $sauceSum")
        }
    }

}