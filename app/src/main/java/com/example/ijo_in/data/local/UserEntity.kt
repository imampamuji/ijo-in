package com.example.ijo_in.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String ,
    val email: String ,
    val password: String ,
)