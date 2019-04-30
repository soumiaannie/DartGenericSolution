import java.util.Scanner;

public class Main {

    static Board board;
    public static void main(String[] args)
    {
        double radius=0.0, score=0.0;
        double pointsEarned;
        board=new Board(3,10);
        System.out.println(board.getNoOfCircles());
        System.out.println(board.getRadius());
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i <= board.getNoOfCircles()-1; i++)
        {

            do {
                System.out.println("Enter  " + i +"  th Circle radius. Press Enter to continue");
                radius=scanner.nextDouble();
            } while(!(validateRadius(radius,i)));
            System.out.println("Enter  " + i +"  th Circle score. Press Enter to continue");
            score=scanner.nextDouble();
            board.addCircle(radius, score);
            System.out.println("Circle sent for creation." + "  Radius = " +radius + "  Score =" +score);
        }

        Dart dart=new Dart();
        pointsEarned=dart.shoot(4.0, 5.0, board);
        System.out.println("Points Earned = " +pointsEarned);


    }

    private static boolean validateRadius(double radius, int circlePosition) {
        if (radius <= 0) {
            System.out.println("Invalid Radius");
            return false;
        }

        else if (radius > board.getRadius()) {
            System.out.println("Radius of circle cannot be greater than Board radius");
            return false;
        }

        else if (circlePosition > 0) {
            if (radius <= board.getBoardCircles().get(circlePosition - 1).getRadius()) {
                System.out.println("Currrent Circle radius cannot be lesser than or equal to the previous circle radius.");
                System.out.println("prev radius" + board.getBoardCircles().get(circlePosition - 1).getRadius());
                System.out.println(radius);
                return false;

            }
            else {
                return true;

            }
        }
        return true;
    }

    /*private static boolean validateScore(double score, int circlePosition) {
        if (score <= 0) {
            System.out.println("Invalid Radius");
            return false;
        } else if (score > board.getRadius()) {
            System.out.println("Radius of circle cannot be greater than Board radius");
            return false;

        } else if (circlePosition > 0) {
            if (score <= board.getBoardCircles().get(circlePosition - 1).getRadius()) {
                System.out.println("Currrent Circle radius cannot be lesser than or equal to the previous circle radius.");
                System.out.println("prev radius" + board.getBoardCircles().get(circlePosition - 1).getRadius());
                System.out.println(score);
                return false;


            } else {
                return true;
                }


        }

        return true;
    }*/


}
