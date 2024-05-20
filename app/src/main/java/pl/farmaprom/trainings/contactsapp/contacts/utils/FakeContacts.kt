package pl.farmaprom.trainings.contactsapp.contacts.utils

import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import kotlin.random.Random

fun generateFakeContactsList(count: Int) = mutableListOf<Contact>().apply {
    for (i in 1..count) {
        add(generateFakeContact(id = i.toLong()))
    }
}
fun generateRandomPhoneNumber(): String {
    val countryCode = "+48"
    val ndc = "52"
    val subscriberNumber = Random.nextInt(1000000, 9999999).toString().padStart(7, '0')

    return "$countryCode $ndc$subscriberNumber"
}
fun generateRandomEmail(): String {
    val localPartChars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val domainNameChars = ('a'..'z')

    val localPartLength = Random.nextInt(5, 11)
    val domainNameLength = Random.nextInt(5, 11)

    val localPart = (1..localPartLength).map { localPartChars.random() }.joinToString("")
    val domainName = (1..domainNameLength).map { domainNameChars.random() }.joinToString("")

    val domainExtension = ".com"

    return "$localPart@$domainName$domainExtension"
}
val firstNames = listOf("Jan", "Anna", "Piotr", "Maria", "Krzysztof", "Ewa", "Tomasz", "Beata", "Andrzej", "Zofia")
val lastNames = listOf("Nowak", "Kowalski", "Wiśniewski", "Zieliński", "Kowalczyk", "Wójcik", "Szymański", "Wojciechowski", "Kamiński", "Szczepaniak")

fun generateFakeContact(id: Long) = Contact(
    id = id,
    name = "${firstNames.random()} ${lastNames.random()}",
    additionalInfo = "additional",
    email = generateRandomEmail(),
    isFavourite = Random.nextBoolean(),
    phone = generateRandomPhoneNumber(),
    imageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/%20%20kamper.jpg"
)
