package butacas.validator

class ButacaValidator {

    fun esValidaButaca(id: String): Boolean {
        val regex = Regex("[A-F][1-7]")
        return regex.matches(id)
    }

}