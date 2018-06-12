package com.searoth.wwe1.cache.db

/**
 * This class defines the tables found within the application Database. All table
 * definitions should contain column names and a sequence for creating the table.
 */
object Db {

    object BufferooTable {
        const val TABLE_NAME = "bufferroos"

        const val BUFFEROO_ID = "bufferoo_id"
        const val FILTER = "filter"
        const val TITLE = "title"
        const val IMAGE = "image"

        const val CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        BUFFEROO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        FILTER + " TEXT NOT NULL," +
                        TITLE + " TEXT," +
                        IMAGE + " TEXT" +
                        "); "
    }

}