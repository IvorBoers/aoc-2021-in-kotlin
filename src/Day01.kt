fun main() {
    fun part1(input: List<Long>): Int {
        var countLarger = 0
        for ((index, item) in input.withIndex()) {
            if (index > 0 && item >input[index - 1]) {
                countLarger++
            }
        }
        return countLarger
    }

    fun part2(input: List<Long>): Int {
        val segments = ArrayList<Long>()
        for ((index, item) in input.withIndex()) {
            if (index > 1) {
                val count = input[index - 2] + input[index - 1] + item
                segments.add(count)
            }
        }

        return part1(segments)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map { it.toLong()}
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01").map { it.toLong()}
    println(part1(input))
    println(part2(input))
}
