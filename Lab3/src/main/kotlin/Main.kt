class User(val name: String, val age: Int?, val email: String?, val address: String?)
{
    fun displayInfo() {
        println("Ім'я: $name")
        age?.let { println("Вік: $it") }
        email?.let { println("Email: $it") }
        address?.let { println("Адреса: $it") }
    }
}

fun main() {
    val user = User("Max", 24, "max2000@gmail.com", null)
    user.displayInfo()
}
