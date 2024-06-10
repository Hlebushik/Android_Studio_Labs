import vehicle.Vehicle
import vehicle.Car
import vehicle.Motorcycle
import vehicle.Bicycle

fun main() {

    val veh = Vehicle(25.6, 10)
    val car = Car(235.8, 300, "Mazda")
    val moto = Motorcycle(210.3, 48, "Chopper")
    val bike = Bicycle(18.9, 2, false)

    veh.type()
    veh.info()
    println()
    car.type()
    car.info()
    println()
    moto.type()
    moto.info()
    println()
    bike.type()
    bike.info()

}