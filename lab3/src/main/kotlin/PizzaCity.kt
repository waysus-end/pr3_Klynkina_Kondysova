abstract class PizzaCity(
    protected val neapolitanPizzaPrice: Double, // Пункт 7: protected видимость
    protected val romanPizzaPrice: Double,
    protected val sicilianPizzaPrice: Double,
    protected val tyroleanPizzaPrice: Double
) {
    protected var neapolitanPizzaCount = 0
    protected var romanPizzaCount = 0
    protected var sicilianPizzaCount = 0
    protected var tyroleanPizzaCount = 0

    // Пункт 1: Статистика скидок по чекам
    protected var totalDiscount = 0.0
    // Пункт 2: Статистика по кофе
    protected var totalCoffeeRevenue = 0.0
    // Пункт 9: Статистика по соусам
    protected var totalSauceRevenue = 0.0
    // Пункт 4: Статистика показов чеков
    protected var checkPhotosShown = 0
    protected var checkPhotosNotShown = 0
    // Пункт 5: Статистика по кофе
    protected var coffeeSold = 0
    protected var coffeeRefused = 0
    // Пункт 6: Статистика кофе по видам пиццы
    protected var coffeeWithNeapolitan = 0
    protected var coffeeWithRoman = 0
    protected var coffeeWithSicilian = 0
    protected var coffeeWithTyrolean = 0
    // Пункт 9: Статистика по соусам
    protected var ketchupSold = 0
    protected var garlicSauceSold = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    open fun showStatistics() {
        println("\n=== СТАТИСТИКА ПИЦЦЕРИИ ===")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val pizzaRevenue = neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice

        // Пункт 3: Выручка с учетом скидок и кофе
        val totalRevenue = pizzaRevenue + totalCoffeeRevenue + totalSauceRevenue - totalDiscount

        println("\nВЫРУЧКА:")
        println("За пиццу: $pizzaRevenue руб.")
        // Пункт 10: Показываем только доступные услуги
        if (this is Drink) {
            println("За кофе: $totalCoffeeRevenue руб.")
        }
        if (this is Sauce) {
            println("За соусы: $totalSauceRevenue руб.")
        }
        if (this is CheckPhoto) {
            println("Предоставленные скидки: -$totalDiscount руб.")
        }
        println("ИТОГО: $totalRevenue руб.")

        // Статистика по дополнительным услугам
        showAdditionalStatistics()
    }

    protected open fun showAdditionalStatistics() {
        // Пункт 4: Статистика чеков (только для пиццерий с CheckPhoto)
        if (this is CheckPhoto) {
            val totalChecks = checkPhotosShown + checkPhotosNotShown
            if (totalChecks > 0) {
                val percentageShown = (checkPhotosShown.toDouble() / totalChecks * 100).toInt()
                val percentageNotShown = (checkPhotosNotShown.toDouble() / totalChecks * 100).toInt()
                println("\nСТАТИСТИКА ЧЕКОВ:")
                println("Показали чек: $checkPhotosShown ($percentageShown%)")
                println("Не показали чек: $checkPhotosNotShown ($percentageNotShown%)")
            }
        }

        // Пункт 5: Статистика кофе (только для пиццерий с Drink)
        if (this is Drink) {
            val totalCoffeeOffers = coffeeSold + coffeeRefused
            if (totalCoffeeOffers > 0) {
                val percentageSold = (coffeeSold.toDouble() / totalCoffeeOffers * 100).toInt()
                val percentageRefused = (coffeeRefused.toDouble() / totalCoffeeOffers * 100).toInt()
                println("\nСТАТИСТИКА КОФЕ:")
                println("Купили кофе: $coffeeSold ($percentageSold%)")
                println("Отказались от кофе: $coffeeRefused ($percentageRefused%)")
            }

            // Пункт 6: Статистика кофе по видам пиццы
            showCoffeePizzaStatistics()
        }

        // Пункт 9: Статистика соусов (только для пиццерий с Sauce)
        if (this is Sauce) {
            showSauceStatistics()
        }
    }

    // Пункт 6: Статистика кофе по видам пиццы
    protected fun showCoffeePizzaStatistics() {
        val totalCoffeeWithPizza = coffeeWithNeapolitan + coffeeWithRoman + coffeeWithSicilian + coffeeWithTyrolean
        if (totalCoffeeWithPizza > 0) {
            println("\nКОФЕ К ПИЦЦЕ:")
            println("К неаполитанской: $coffeeWithNeapolitan (${(coffeeWithNeapolitan.toDouble() / totalCoffeeWithPizza * 100).toInt()}%)")
            println("К римской: $coffeeWithRoman (${(coffeeWithRoman.toDouble() / totalCoffeeWithPizza * 100).toInt()}%)")
            println("К сицилийской: $coffeeWithSicilian (${(coffeeWithSicilian.toDouble() / totalCoffeeWithPizza * 100).toInt()}%)")
            println("К тирольской: $coffeeWithTyrolean (${(coffeeWithTyrolean.toDouble() / totalCoffeeWithPizza * 100).toInt()}%)")
        }
    }

    // Пункт 9: Статистика соусов
    protected fun showSauceStatistics() {
        val totalSauces = ketchupSold + garlicSauceSold
        if (totalSauces > 0) {
            println("\nСТАТИСТИКА СОУСОВ:")
            println("Кетчуп: $ketchupSold (${(ketchupSold.toDouble() / totalSauces * 100).toInt()}%)")
            println("Чесночный: $garlicSauceSold (${(garlicSauceSold.toDouble() / totalSauces * 100).toInt()}%)")
        }
    }

    // Методы для обновления статистики
    protected fun updateCoffeeStatistics(pizzaType: String, sold: Boolean) {
        if (sold) {
            coffeeSold++
            when (pizzaType) {
                "neapolitan" -> coffeeWithNeapolitan++
                "roman" -> coffeeWithRoman++
                "sicilian" -> coffeeWithSicilian++
                "tyrolean" -> coffeeWithTyrolean++
            }
        } else {
            coffeeRefused++
        }
    }

    protected fun updateCheckPhotoStatistics(shown: Boolean) {
        if (shown) {
            checkPhotosShown++
        } else {
            checkPhotosNotShown++
        }
    }
}