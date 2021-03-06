package com.example.smidig.database

import androidx.room.*

//the DAO is the way for the database to interact with our login entity
@Dao
interface LoginDao {
    @Insert
    fun addLogin(login: Login)

    @Update
    fun update(login: Login)

    @Delete
    fun delete(login: Login)

    @Query("SELECT * FROM login_table WHERE username = :username")
    fun getUser(username: String): Login

}