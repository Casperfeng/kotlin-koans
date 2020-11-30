class DateRange(val start: MyDate, val end: MyDate):Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var now = start

            override fun hasNext(): Boolean {
                return now <= end
            }

            override fun next(): MyDate {
                val res = now
                if (hasNext()) now = now.followingDate() else throw NoSuchElementException()
                return res
            }

        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}