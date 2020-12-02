class LazyProperty(val initializer: () -> Int) {
    /* TODO */
    var value: Int? = null
    val lazy: Int
        get() {
           if (value == null) {
               value = initializer()
           }
            return value!!
        }
}
