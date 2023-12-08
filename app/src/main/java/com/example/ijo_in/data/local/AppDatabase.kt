package com.example.ijo_in.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ijo_in.data.local.dao.UserDao
import com.example.ijo_in.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}