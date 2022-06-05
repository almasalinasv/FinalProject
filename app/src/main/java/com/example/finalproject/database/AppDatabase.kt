package com.example.finalproject.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABSE_VERSION = 1
const val  TABLE_PRODUCTS ="products"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [ProductEntity::class],
    version = DATABSE_VERSION
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun ProductDao():ProductDao
}