public class Dart {
    private double score;

    public double shoot(double dartXcoordinate, double dartYcoordinate, Board board) {

    score=board.calculateScore(dartXcoordinate, dartYcoordinate);
    return score;
    }
}
