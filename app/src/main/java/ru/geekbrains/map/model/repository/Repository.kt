package ru.geekbrains.map.model.repository

import ru.geekbrains.map.model.data.DataModel

interface Repository<T> {
    suspend fun getData(): List<DataModel>?
    suspend fun saveData(place: DataModel) {}
    suspend fun removeData(position: Int)
    suspend fun editData(position: Int, name: String?, annotation: String?) {}
}