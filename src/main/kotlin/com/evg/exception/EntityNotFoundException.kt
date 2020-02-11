package com.evg.exception

import org.springframework.context.MessageSourceResolvable


class EntityNotFoundException : RuntimeException, MessageSourceResolvable {

    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable) : super(message, cause)

    override fun getCodes(): Array<String>? = arrayOf("error.404")
}