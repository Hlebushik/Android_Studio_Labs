package vehicle

class Car(speed: Double, power: Int, val model: String) : Vehicle(speed, power) {

    override fun type() {
        println("Це Автомобіль $model")
    }

    override fun info() {
        println("Швидкість: $speed, Потужність: $power, Модель: $model")
    }

}