package pe.edu.cibertec.ct01_herreravillacorta_cesarhumberto.model

class Order (
    val size: PizzaSize,
    val toppings: MutableList<Topping>
        ) {
    fun addTopping(topping: Topping){
        this.toppings.add(topping)
    }
    fun calculateTotal(): Int {
        val sumOfToppingsPrice = this.toppings.reduce { acc, topping ->
            Topping("tmpTopping",acc.price + topping.price)
        }.price
        return this.size.price + sumOfToppingsPrice
    }
}