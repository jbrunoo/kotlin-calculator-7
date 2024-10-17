package calculator

class Parser(private val input: String) {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    private fun findCustomDelimiter(): Boolean {
        val inputPrefix = input.take(CUSTOM_DELIMITER_FORMAT_LEN)
        val customDelimiterPattern = CUSTOM_DELIMITER_FORMAT_REGEX.toRegex()
        val isMatch = customDelimiterPattern.matches(inputPrefix)
        return isMatch
    }

    private fun updateDelimiters() {
        if (findCustomDelimiter()) delimiters.add(input[CUSTOM_DELIMITER_INDEX])
    }
}

private const val DEFAULT_DELIMITER_COMMA = ','
private const val DEFAULT_DELIMITER_COLON = ':'

private const val CUSTOM_DELIMITER_FORMAT_LEN = 5
private const val CUSTOM_DELIMITER_INDEX = 2
private const val CUSTOM_DELIMITER_FORMAT_REGEX = """//([^\d\s])\\n"""