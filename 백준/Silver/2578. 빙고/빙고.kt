import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val board = Array(5) { Array(5) { 0 } }
    val visited = Array(5) { Array(5) { false } }
    var turn = 0
    val rowCol = Array(2) {Array(5) {false} }
    val diagonal = Array(2) { false }

    for (i in 0..4) {
        val token = StringTokenizer(readLine())

        for (j in 0..4) {
            board[i][j] = token.nextToken().toInt()
        }
    }

    for (i in 0..4) {
        val token = StringTokenizer(readLine())

        for (j in 0..4) {
            turn ++
            if (check(token.nextToken().toInt(), board, visited, diagonal, rowCol)) {
                if (count(diagonal, rowCol) >= 3) {
                    println(turn)
                    return
                }
            }
         }
    }


}

fun count(diagonal: Array<Boolean>, rowCol: Array<Array<Boolean>>) : Int {
    var count = 0

    for (i in diagonal) {
        if (i) {
           count++
        }
    }

    for (i in rowCol) {
        for (j in i) {
            if (j) {
                count++
            }
        }
    }

    return count
}

fun check(num : Int, board : Array<Array<Int>>, visited : Array<Array<Boolean>>, diagonal: Array<Boolean>, rowCol: Array<Array<Boolean>>) : Boolean {
    for (i in 0 .. 4) {
        for (j in 0 .. 4) {
            if (board[i][j] == num) {
                visited[i][j] = true;
                return bingoCheck(i, j, visited, diagonal, rowCol)
            }
        }
    }
    return false
}

fun bingoCheck(x : Int, y : Int, visited : Array<Array<Boolean>>, diagonal : Array<Boolean>, rowCol : Array<Array<Boolean>>) : Boolean {

    var result = false

     for (i in 0 .. 4) {
         if (!visited[i][y]) {
             break;
         }
         if (i == 4) {
             rowCol[0][y] = true
             result = true;
         }
     }

    for (i in 0 .. 4) {
        if (!visited[x][i]) {
            break;
        }
        if (i == 4) {
            rowCol[1][x] = true
            result = true;
        }
    }

    if (!diagonal[0]) {
        for (i in 0 .. 4) {
            if (!visited[i][i]) {
                break;
            }
            if (i == 4) {
                diagonal[0] = true
                result = true;
            }
        }
    }

    if (!diagonal[1]) {
        for (i in 0 .. 4) {
            if (!visited[4 - i][i]) {
                break;
            }
            if (i == 4) {
                diagonal[1] = true
                result = true
            }
        }
    }
    return result
}