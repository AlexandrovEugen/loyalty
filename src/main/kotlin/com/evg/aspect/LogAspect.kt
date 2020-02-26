package com.evg.aspect

import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Aspect
@Component
class LogAspect {

    @Around("@annotation(com.evg.aspect.Log)")
    fun logExecutionTime(joinPoint: ProceedingJoinPoint) {
        val start = System.currentTimeMillis()
        val signature = joinPoint.signature.toShortString()
        val result = try {
            with(StringBuilder("start -> Executing $signature, "), {
                appendParameters(joinPoint.args)
                logger.info(toString())
            })
            joinPoint.proceed()
        } catch (throwable: Throwable) {
            logger.error("*** Exception during executing $signature,", throwable)
            throw throwable
        }
        val duration = System.currentTimeMillis() - start
        logger.info("end -> Finished executing: $signature, returned: '$result', duration: $duration ms")
    }

    private fun StringBuilder.appendParameters(args: Array<Any>) {
        append("parameters: [")
        args.forEachIndexed { i, p ->
            append(p.javaClass.simpleName).append("(").append(p.toString()).append(")")
            if (i < args.size - 1) append(", ")
        }
        append("]")
    }
}