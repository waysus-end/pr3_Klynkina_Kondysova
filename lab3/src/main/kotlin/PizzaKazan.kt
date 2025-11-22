class PizzaKazan(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto, Drink, Sauce {

    private var currentPizzaType = ""
    private val ketchupPrice = 50.0
    private val garlicSaucePrice = 70.0

    // Пункт 1: Реализация скидки по чеку
    override fun showCheckPhoto(): Double {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        val choice = readln()
        val shown = choice == "1"
        updateCheckPhotoStatistics(shown)

        if (shown) {
            println("Вам будет скидка 50 рублей с покупки")
            totalDiscount += 50.0
            return 50.0
        }
        return 0.0
    }

    // Пункт 2: Реализация продажи кофе
    override fun drinkSale(): Double {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        val choice = readln()
        val sold = choice == "1"
        updateCoffeeStatistics(currentPizzaType, sold)

        if (sold) {
            println("С вас 200 рублей")
            totalCoffeeRevenue += 200.0
            return 200.0
        }
        return 0.0
    }

    // Пункт 8: Реализация предложения соусов
    override fun offerSauce(): Double {
        println("Выберите соус к пицце:")
        println("1. Кетчуп - 50 руб.\n2. Чесночный соус - 70 руб.\n3. Без соуса")
        return when (readln()) {
            "1" -> {
                ketchupSold++
                totalSauceRevenue += ketchupPrice
                println("Добавлен кетчуп")
                ketchupPrice
            }
            "2" -> {
                garlicSauceSold++
                totalSauceRevenue += garlicSaucePrice
                println("Добавлен чесночный соус")
                garlicSaucePrice
            }
            else -> {
                println("Без соуса")
                0.0
            }
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        currentPizzaType = "neapolitan"
        println("Спасибо за покупку неаполитанской пиццы в Казани")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        currentPizzaType = "roman"
        println("Спасибо за покупку римской пиццы в Казани")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        currentPizzaType = "sicilian"
        println("Спасибо за покупку сицилийской пиццы в Казани")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        currentPizzaType = "tyrolean"
        println("Спасибо за покупку тирольской пиццы в Казани")
    }
}
