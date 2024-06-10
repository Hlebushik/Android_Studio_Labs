package vehicle

class Motorcycle(speed: Double, power: Int, val type: String) : Vehicle(speed, power) {

    override fun type() {
        println("Це Мотоцикл $type")
    }

    override fun info() {
        println("Швидкість: $speed, Потужність: $power, Тип: $type")
    }

}