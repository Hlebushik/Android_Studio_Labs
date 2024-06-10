package vehicle

class Bicycle(speed: Double, power: Int, var bell: Boolean) : Vehicle(speed,power) {

    override fun type() {
        println("Це Велосипед")
    }

    override fun info() {
        println("Швидкість: $speed, Потужність: $power")
        if (bell) {
            println("У велосипеда є дзвіночок")
        }
        else {
            println("У велосипеда немає дзвіночка")
        }
    }

}