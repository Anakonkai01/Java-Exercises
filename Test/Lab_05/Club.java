public class Club {
    // atributes
    private String name;
    private int wins;
    private int losses;
    private int draws;

    //constructor
    public Club(){
        this.name = "";
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }
    public Club(String name, int wins, int draws, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }
    public Club(Club club){
        this.name = club.name;
        this.wins = club.wins;
        this.losses = club.losses;
        this.draws = club.draws;
    }

    //getters and setters
    public int getDraws() {
        return draws;
    }
    public int getLosses() {
        return losses;
    }
    public String getName() {
        return name;
    }
    public int getWins() {
        return wins;
    }
    public void setDraws(int draws) {
        this.draws = draws;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }

    // other methods
    public int numMatches() {
        return wins + draws + losses;
    }
    public boolean isFinished() {
        return (numMatches() >= 10)? true : false;
    }
    public int getPoints(){
        return wins*3 + draws + losses*0;
    }

    @Override
    public String toString(){
        return name + " club: " + wins + "/" + draws + "/" +losses + " - "+getPoints();
    }
}
