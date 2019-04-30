import java.util.ArrayList;

public class Board extends Circle {
    private double boardXcoordinate = 0;
    private double boardYcoordinate = 0;
    private double dartLocation;
    private double deltaX, deltaY;
    private int noOfCircles;
    private Circle circle;
    private ArrayList<Circle> boardCircles = new ArrayList<Circle>();

    Board(int noOfCircles, double radius) {
        this.noOfCircles = noOfCircles;
        this.radius = radius;
    }


    public int getNoOfCircles() {
        return noOfCircles;
    }

    public ArrayList<Circle> getBoardCircles() {
        return boardCircles;
    }

    public void addCircle(double radius, double score) {
        boardCircles.add(new Circle(radius, score));
    }

    public double calculateScore(double dartXcoordinate, double dartYcoordinate) {
        dartLocation = findDartLocationDistanceFromBoard(dartXcoordinate, dartYcoordinate);
        if (dartLocation == -1) {
            System.out.println("Invalid DartLocation");
        }
        System.out.println("Radius is" + radius);
        if (dartLocation > radius) {
            System.out.println("Dart is outside the Board.");
            return -2;
        } else {
            score = calculatePointsEarned(dartLocation);
            return score;
        }


    }

    private double calculatePointsEarned(double dartLocation) {

        for (int i = 0; i < noOfCircles; i++) {

            if (i < 1) {

                if (dartLocation >= 0 && dartLocation <= getBoardCircles().get(i).getRadius()) {
                    System.out.println("Dart is inside the " + (i+1) + "th circle.");
                    score= getBoardCircles().get(i).getScore();
                    break;
                }

            } else {
                if (dartLocation > getBoardCircles().get(i - 1).getRadius() && dartLocation <= getBoardCircles().get(i).getRadius()) {
                    System.out.println("Dart is inside the " + (i+1) + "th circle.");
                    score= getBoardCircles().get(i).getScore();
                    break;

                }

            }

        }
        return score;
    }

    private  double findDartLocationDistanceFromBoard(double dartXcoordinate, double dartYcoordinate) {
        if ((dartXcoordinate < boardXcoordinate) || (dartYcoordinate < boardYcoordinate)) {
            return -1;
        } else {

            deltaX = (dartXcoordinate - boardXcoordinate);
            deltaY = (dartYcoordinate - boardYcoordinate);
            dartLocation = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
            System.out.println("The location of the dart is " +dartLocation);
            return dartLocation;
        }

        }
    }





