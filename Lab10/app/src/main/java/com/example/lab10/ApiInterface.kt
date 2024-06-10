package com.example.lab10

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/tasks/1")
    suspend fun getTasks() : Response<ResponseTodos>

    @POST("/tasks/")
    suspend fun addTasks(@Body tasks: Tasks) : Response<AddTasksResponse>
}