package vehicle

open class Vehicle (val speed: Double, val power: Int ) {

    open fun type() {
        println("Цей транспортний засіб не має типу")
    }
    open fun info() {
        println("Швидкість: $speed, Потужність: $power")
    }
}