// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.filter { it.isDelivered }.flatMap(Order::products).maxBy(Product::price)
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap(Customer::orders).flatMap(Order::products).count{it == product}
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap(Order::products)
