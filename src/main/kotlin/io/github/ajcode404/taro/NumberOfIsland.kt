package io.github.ajcode404.taro

/**
 *  [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 */
fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    for (i in 0..grid.size - 1) {
        for (j in 0..grid[i].size - 1) {
            if (grid[i][j] == '1') {
                count++
                markIslandAsZero(i, j, grid)
            }
        }
    }
    return count
}

fun markIslandAsZero(i: Int, j: Int, grid: Array<CharArray>) {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == '0') {
        return
    }
    // traverse in all direction
    grid[i][j] = '0'
    markIslandAsZero(i + 1, j, grid)
    markIslandAsZero(i - 1, j, grid)
    markIslandAsZero(i, j + 1, grid)
    markIslandAsZero(i, j - 1, grid)
}
