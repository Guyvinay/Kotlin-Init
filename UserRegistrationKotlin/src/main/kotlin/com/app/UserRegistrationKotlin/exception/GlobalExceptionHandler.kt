package com.app.UserRegistrationKotlin.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(ex:Exception, desc:WebRequest):ResponseEntity<ExceptionDef>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ExceptionDef(
            LocalDateTime.now(),
                ex.message,
                desc.getDescription(false)
        )
        )
    }
    @ExceptionHandler(NotFoundException::class)
    fun notFoundExceptionHandler(ex: NotFoundException, desc: WebRequest): ResponseEntity<ExceptionDef> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ExceptionDef(
                LocalDateTime.now(),
                ex.message,
                desc.getDescription(false)
            )
        )
    }
}