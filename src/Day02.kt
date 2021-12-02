fun main() {
    open class Submarine {
        var depth = 0
        var horizontal = 0


        open fun move(command: String) {
            val split = command.split(" ")
            if (split.size == 2) {
                val value = split[1].toInt()
                when (split[0]) {
                    "forward" -> horizontal += value
                    "down" -> depth += value
                    "up" -> depth -= value

                    else -> println("Unknown command: " + split[0])
                }
            } else {
                println("Illegal Command:$command")
            }
        }

        override fun toString(): String {
            return "Submarine(depth=$depth, horizontal=$horizontal)"
        }

    }

    class Submarine2: Submarine() {
        var aim = 0

        override fun move(command: String) {
            val split = command.split(" ")
            if (split.size == 2) {
                val value = split[1].toInt()
                when (split[0]) {
                    "forward" -> {
                        horizontal += value
                        depth += aim * value
                    }
                    "down" -> aim += value
                    "up" -> aim -= value
                    else -> println("Unknown command: " + split[0])
                }
            } else {
                println("Illegal Command:$command")
            }
        }

        override fun toString(): String {
            return "Submarine(depth=$depth, horizontal=$horizontal, aim=$aim)"
        }
    }

    fun part1(input: List<String>): Int {
        val submarine = Submarine()
        input.forEach{submarine.move(it)}
        println("Submarine: $submarine")
        return submarine.depth * submarine.horizontal
    }

    fun part2(input: List<String>): Int {
        val submarine = Submarine2()
        input.forEach{submarine.move(it)}
        println("Submarine: $submarine")

        return submarine.depth * submarine.horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println("Part 1 " + part1(input))
    println("Part 2: " + part2(input))
}
