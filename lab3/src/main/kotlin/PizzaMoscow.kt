class PizzaMoscow(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto {

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
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }
}