package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model

/**
 * Main class
 * Here we create the order, add the topics and calculate the total amount
 */
class Order (
    val size: PizzaSize,
    val toppings: MutableList<Topping>
        ) {
    fun addTopping(topping: Topping){
        this.toppings.add(topping)
    }
    fun calculateTotal(): Int {
        /**
         * Using reduce here is a little complicated:
         * it requires the same object, so we need to create new Topping everytime
         */
        val sumOfToppingsPrice = this.toppings.reduce { acc, topping ->
            // here we call the constructor of the topping, but we are adding the prices
            Topping(acc.name,acc.price + topping.price, acc.isSelected.value)
        }.price
        return this.size.price + sumOfToppingsPrice
    }
}