package com.craftinginterpreters.lox

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    when {
        args.size > 1 -> {
            println("Usage: klox [script]")
            exitProcess((64))
        }
        args.size == 1 -> runFile(args[0])
        else -> runPrompt()
    }
}

private fun runFile(path: String) = runSource(File(path).readText())

private fun runPrompt() {
    while (true) {
        print("> ")
        val line = readLine() ?: break
        runSource(line)
    }
}

private fun runSource(source: String) {
    source.split(Regex("\\s+")).filter { it.isNotEmpty() }.forEach(::println)
}