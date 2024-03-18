package tolls

fun getUserInput(message: String): String {
    print(message)
    return readLine() ?: ""
}