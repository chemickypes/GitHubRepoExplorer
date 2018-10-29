package com.angelomoroni.githubrepoexplorer.datalayer

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.angelomoroni.githubrepoexplorer.UserEntity


@Database(entities = [UserEntity::class],version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}


@Dao
abstract class UserDao{
    @Insert(onConflict = REPLACE)
    abstract fun save(user: UserEntity)

    @Query("SELECT * FROM users WHERE login = :userName")
    abstract fun load(userName: String): LiveData<UserEntity>?

}