package com.evg.controller.exception

import com.evg.entity.error.ErrorResponseEntity.Companion.badRequest
import com.evg.exception.EntityNotFoundException
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler(val messageSource: MessageSource) {


    @ExceptionHandler(EntityNotFoundException::class)
    fun notFoundException(exception: EntityNotFoundException, locale: Locale) = badRequest(messageSource.getMessage(exception, locale))



}