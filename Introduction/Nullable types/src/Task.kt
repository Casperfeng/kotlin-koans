fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    if (client != null && mailer != null) client?.personalInfo?.email?.let {
        if (message != null) {
            mailer.sendMessage(it, message)
        }
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
