class PizzaPeter(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink {

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

    private var currentPizzaType = ""

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        currentPizzaType = "neapolitan"
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        currentPizzaType = "roman"
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        currentPizzaType = "sicilian"
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        currentPizzaType = "tyrolean"
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}
