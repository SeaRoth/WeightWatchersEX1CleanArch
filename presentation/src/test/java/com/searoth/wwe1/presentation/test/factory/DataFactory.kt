package com.searoth.wwe1.presentation.test.factory

/**
 * Factory class for data instances
 */
class DataFactory {

    companion object Factory {

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }

    }

}