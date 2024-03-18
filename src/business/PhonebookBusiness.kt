package business

import entity.Person

class Phonebook {
    private val contacts = mutableListOf<Person>()

    fun addContact(name: String, phone: String) {
        val person = Person(name, phone)
        contacts.add(person)
        println("Contact added successfully!")
    }

    fun listContacts() {
        if (contacts.isEmpty()) {
            println("No contacts found.")
        } else {
            println("List of contacts:")
            contacts.forEachIndexed { index, contact ->
                println("${index + 1}. Name: ${contact.name}, Phone: ${contact.phone}")
            }
        }
    }

    fun getContacts(): List<Person> {
        return contacts.toList()
    }

    fun editContact(index: Int, newName: String, newPhone: String) {
        contacts[index] = Person(newName, newPhone)
        println("Contact edited successfully!")
    }

    fun deleteContact(index: Int) {
        if (index in contacts.indices) {
            contacts.removeAt(index)
            println("Contact deleted successfully!")
        } else {
            println("Invalid contact index.")
        }
    }
}