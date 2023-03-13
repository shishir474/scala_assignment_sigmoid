case class Player(val year:Int, val playerName:String, val country:String, val matches:Int, val runs:Int, val wickets:Int)

class Solve{
    val players = Seq( Player(2021, "Sam", "India", 23, 1700, 32),
        Player(2021, "Tom", "England", 34, 2600, 2),
        Player(2020, "Virat", "India", 56, 4566, 4),
        Player(2021, "Bratt", "Australia", 46, 3500, 90),
        Player(2021, "Ashwin", "India", 47, 1800, 195),
        Player(2020, "Lee", "Austraila", 122, 2234, 255),
        Player(2019, "Ponting", "Australia", 180, 11989, 120),
        Player(2019, "Peeks", "West Indies", 170, 9989, 220),
        Player(2019, "Rooks", "West Indies", 155, 3445, 140),
        Player(2022, "Jack", "Pakistan", 89, 4578, 234),
        Player(2013, "Rock", "USA", 19, 879, 78))

    
    def printPlayer(player: Player): Unit = {
        println(
        s"""
            |Name :${player.playerName}
            |Year :${player.year}
            |Matches :${player.matches}
            |Runs: ${player.runs}
            |Wickets: ${player.wickets}
            |""".stripMargin)
    }

    def highestRuns(): Unit = {
        var highestRun: Player = players(0)
        for (player <- players) {
        highestRun = if (highestRun.runs < player.runs) player else highestRun
        }
        printPlayer(highestRun)
    }

    def top5Runs(): Unit = {
        val topRuns = players.sortWith(_.runs > _.runs)
        for(i<- 0 to 4){
        printPlayer(topRuns(i))
        }
    }

    def top5Wickets(): Unit = {
        val topWickets=players.sortWith(_.wickets > _.wickets)
        for (i <- 0 to 4) {
        printPlayer(topWickets(i))
        }
    }

    def rankPlayers(): Unit = {
        val rankPlayer=players.sortWith((p1,p2)=> 500*p1.wickets+5*p1.runs > 500*p2.wickets+5*p2.runs)
        var i=0;
        for(player <- rankPlayer){
        print(s"--- ${i+1} --- ")
        printPlayer(player)
        i=i+1;
        }
    }


 }

object Solution{
     def main(args:Array[String]):Unit = {
        val obj = new Solve()
         println("""
        |1. Player with highest run scored
        |2. Top 5 players by run scored
        |3. Top 5 players by wickets taken
        |4. Rank player
        |
        |Enter your choice
        |""".stripMargin)

    
        val ch=scala.io.StdIn.readInt()

        ch match {
        case 1 => obj.highestRuns()
        case 2 => obj.top5Runs()
        case 3 => obj.top5Wickets()
        case 4 => obj.rankPlayers()
        case exp => println("Wrong Choice")
        }

    }
}
