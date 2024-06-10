package com.example.lab10

import com.google.gson.annotations.SerializedName

data class AddTasksResponse (
    @SerializedName("id")
    var id: Int
)