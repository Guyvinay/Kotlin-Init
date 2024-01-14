package com.app.UserRegistrationKotlin.exception

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ExceptionDef(

    @JsonProperty("time_Stamp")
    val timestamp: LocalDateTime,
    @JsonProperty("Message")
    val message: String?,
    @JsonProperty("Description")
    val description: String?
)
