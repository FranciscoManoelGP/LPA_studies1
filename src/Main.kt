//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import business.Phonebook
import tolls.getUserInput

fun main() {
    val phonebook = Phonebook()
    var option: Int

    do {
        println("\nSelect an option:")
        println("1. Add Contact")
        println("2. List Contacts")
        println("3. Edit Contact")
        println("4. Delete Contact")
        println("5. Exit")
        print("Option: ")
        option = getUserInput("").toIntOrNull() ?: 5

        when (option) {
            1 -> {
                val name = getUserInput("Name: ")
                val phone = getUserInput("Phone: ")
                phonebook.addContact(name, phone)
            }
            2 -> phonebook.listContacts()
            3 -> {
                val contacts = phonebook.getContacts()
                val index = getUserInput("Index of the contact to be edited: ").toIntOrNull() ?: -1
                if (index - 1 in contacts.indices) {
                    val newName = getUserInput("New name: ")
                    val newPhone = getUserInput("New phone: ")
                    phonebook.editContact(index - 1, newName, newPhone)
                } else {
                    println("Invalid contact index.")
                }

            }
            4 -> {
                val index = getUserInput("Index of the contact to be deleted: ").toIntOrNull() ?: -1
                phonebook.deleteContact(index - 1)
            }
            5 -> println("Exiting...")
            else -> println("Invalid option!")
        }
    } while (option != 5)
}