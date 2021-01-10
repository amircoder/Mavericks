package com.multithread.dindinntest

import org.junit.Test
import java.lang.StringBuilder

class CharacterReplace {

    private val characterToStepMap by lazy {
        createCharacterToStepList()
    }
    private val stepToCharacterMap by lazy {
        createStepToCharacterList()
    }

    @Test
    fun replaceCharacters() {
        println(applyTransformation("abs", 26))
        println(applyTransformation("abs", -26))
        println("\n")
        println(applyTransformation("abc", 2))
        println(applyTransformation("cde", -2))
        println("\n")
        println(applyTransformation("abc", 28))
        println(applyTransformation("cde", -28))
        println("\n")
        println(applyTransformation("isuf", 4))
        println(applyTransformation("mwyj", -4))
        println("\n")
        println(applyTransformation("ioksi", 11))
        println(applyTransformation("tzvt", -11))
        println("\n")
        println(applyTransformation("lola", 82763))
        println(applyTransformation("qtqf", -82763))


    }

    /**
     * Finds the nth character after the current one, the complexity is o(1) due to usage of [Map]
     * to search the replacing character. btw using ASCII value will increase search time, because
     * complexity of search/lookup in [Array] is o(n)
     */
    private fun applyTransformation(input: String, step: Int): String {
        val characterStore = StringBuilder()
        input.forEach {
            (characterToStepMap[it.toString()]!!).let {index ->
                characterStore.append(stepToCharacterMap[index % 26])
            }
        }
        return characterStore.toString()
    }


    private fun createStepToCharacterList() = hashMapOf<Int, String>().apply {
        characterToStepMap.entries.forEach {
            put(it.value, it.key)
        }
    }

    private fun createCharacterToStepList(): HashMap<String, Int> =
            HashMap<String, Int>().apply {
                // Creates the range of desired characters.
                ("a".toByteArray()[0].toInt().."z".toByteArray()[0].toInt()).forEach {
                    put(
                            it.toChar().toString(), it - 97
                    )
                }
            }

}