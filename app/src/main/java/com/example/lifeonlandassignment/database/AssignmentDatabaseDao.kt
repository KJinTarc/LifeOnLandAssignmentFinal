package com.example.lifeonlandassignment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AssignmentDatabaseDao {
    @Insert
    suspend fun insert(user: User)
    @Update
    fun update(user: User)
    @Query("SELECT * from user_table WHERE userId = :key")
    fun get(key:Long): User?
    @Query("DELETE FROM user_table")
    fun clear()
    @Query("SELECT * from user_table")
    fun getAllUser(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE username LIKE :username AND password LIKE :password")
    fun readAllData(username: String, password: String): LiveData<User>

    @Query("SELECT * FROM user_table WHERE username LIKE :username")
    suspend fun getUsername(username: String): User?
}