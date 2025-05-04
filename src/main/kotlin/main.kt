import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    println(commissn(1500))

}

fun commissn(transfer: Int, previous: Int = 0, typeCard: String = "Mir"): Int {
    val monthlyLimit = 600_000
    val dayLimit = 150_000
    val minVisaCommissn = 35
    val percentVisaCommissn = 0.0075
    val visaCommissn = max(minVisaCommissn, (transfer * percentVisaCommissn).toInt())
    val freePayMastercard = 75_000
    val percentMastercardCommissn = 0.0006
    val masterCardCommissn = when {
        (previous + transfer) < freePayMastercard && (previous + transfer) > 0 -> 0
        previous > freePayMastercard -> (transfer * percentMastercardCommissn).toInt()
        previous + transfer > freePayMastercard -> (((previous + transfer) - freePayMastercard) * percentMastercardCommissn).toInt()
        else -> ERROR_LIMIT
    }
    val mirCommissn = 0

    if (transfer > dayLimit || (transfer + previous) > monthlyLimit) return ERROR_LIMIT

    return when (typeCard) {
        "Visa" -> visaCommissn
        "Mastercard" -> masterCardCommissn
        "Mir" -> mirCommissn
        else -> ERROR_TYPE
    }
}