package com.appbrewery.incubyte


fun add(input: String): Int {
    var result = 0
    var numArr: MutableList<String> = mutableListOf()
        if (containsDelimiter((input))) {
            val delimiter = getDelimiter(input)
            val numStr = getNumStr(input)
            if (isValidInput(numStr)) {
                numArr = numStr.split(delimiter).toMutableList()
            }

        } else {
            if (isValidInput(input)) {
                numArr = input.split("[,\\n]".toRegex()).toMutableList()
            }
        }
    if (containsNegative(numArr)) {
        throw Exception("negatives not allowed")
    }
    result = numArr.sumOf {
        it.toInt()
    }

    return result
}

fun String.toInt(): Int {
    return try {
        Integer.parseInt(this)
    } catch (ex: NumberFormatException) {
        0
    }
}

fun isValidInput(input: String): Boolean {
    val containsInvalidDelimiter = input.contains("[,\\n]{2,}".toRegex())
    return !containsInvalidDelimiter
}

fun containsDelimiter(input: String): Boolean {
    return input.contains("[/]{2,}(.*)\\n".toRegex())
}

fun getDelimiter(input: String): String {
    if (containsDelimiter(input)) {
        return input.substringBefore("\n").substringAfter("//")
    }
    return ""
}

fun getNumStr(input: String): String {
    if (containsDelimiter(input)) {
        return input.substringAfter("\n")
    }
    return input
}

fun containsNegative(inputArr: List<String>): Boolean {
    var containsNegative = false
        inputArr.forEach {
                if(it.toInt() < 0) {
                    containsNegative = true
                    println("$it --> negatives not allowed")
                }

        }
    return containsNegative
}