    package antonio20028.iiitd.ac.in;

    import antonio20028.iiitd.ac.in.models.*;
    import antonio20028.iiitd.ac.in.models.Record;

    import java.util.ArrayList;
    import java.util.Scanner;

    public class Main {
        static int N_FLOORS = 14;
        static int EMPTY_FLOOR = 1;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            NormalFloor floor0 = new NormalFloor(0, EMPTY_FLOOR);
            NormalFloor floor1 = new NormalFloor(1, EMPTY_FLOOR);
            NormalFloor floor3 = new NormalFloor(3, EMPTY_FLOOR);
            NormalFloor floor4 = new NormalFloor(4, EMPTY_FLOOR);
            NormalFloor floor6 = new NormalFloor(6, EMPTY_FLOOR);
            NormalFloor floor7 = new NormalFloor(7, EMPTY_FLOOR);
            NormalFloor floor9 = new NormalFloor(9, EMPTY_FLOOR);
            NormalFloor floor10 = new NormalFloor(10, EMPTY_FLOOR);
            NormalFloor floor12 = new NormalFloor(12, EMPTY_FLOOR);
            NormalFloor floor13 = new NormalFloor(13, EMPTY_FLOOR);

            NormalSnake normalSnake = new NormalSnake(5);
            KingCobra kingCobra = new KingCobra(11);
            NormalLadder ladder = new NormalLadder(8);
            Elevator elevator = new Elevator(2);
            ArrayList<Record> records = new ArrayList<Record>();

            Dice dice = new Dice(2);
            String option = "y";
            StopWatch stopWatch = new StopWatch();
            int auxPlayerHasMoved = 0;

            while (option.equals("y") || option.equals("Y")) {

                System.out.println("Enter the player name: ");
                String _playerName = getString();
                Player player = new Player(_playerName);
                System.out.println("The game setup is ready");

                int _currentFace = rollDice(player, scanner, dice);

                //starting the game
                while (_currentFace != 1) {
                    System.out.println("The dice gave " + String.valueOf(_currentFace));
                    System.out.println("Game Cannot start until you get 1\n");

                    rollDice(player, scanner, dice);
                    _currentFace = dice.getCurrentFace();
                }
                stopWatch.startCount();
                while (player.getPosition() <= N_FLOORS -1) {
                    System.out.println("Dice gave " + String.valueOf(_currentFace));
                    System.out.println("Player position Floor-" + player.getPosition());
                    auxPlayerHasMoved = player.getPosition();
                    if (player.getPosition() == floor0.getPosition()) {
                        floor0.increasePlayerPoint(player);
                        floor0.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor1.getPosition()) {
                        floor1.increasePlayerPoint(player);
                        floor1.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor3.getPosition()) {
                        floor3.increasePlayerPoint(player);
                        floor3.showPlayerPosition(player, "empty");
                    } else if (player.getPosition()  == floor4.getPosition()) {
                        floor4.increasePlayerPoint(player);
                        floor4.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor6.getPosition()) {
                        floor6.increasePlayerPoint(player);
                        floor6.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor7.getPosition()) {
                        floor7.increasePlayerPoint(player);
                        floor7.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor9.getPosition()) {
                        floor9.increasePlayerPoint(player);
                        floor9.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor10.getPosition()) {
                        floor10.increasePlayerPoint(player);
                        floor10.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor12.getPosition()) {
                        if (auxPlayerHasMoved < player.getPosition()) {
                            floor12.increasePlayerPoint(player);
                        }
                        floor12.showPlayerPosition(player, "empty");
                    } else if (player.getPosition() == floor13.getPosition()){
                        floor13.increasePlayerPoint(player);
                        floor13.showPlayerPosition(player, "empty");
                        System.out.println("Game Over");
                        System.out.println(player.getName() + " accumulated " + player.getPoint() + " points");
                        stopWatch.stopCount();
                        records.add(new Record(player.getName(), player.getPoint(), stopWatch.getTotalTime()));
                        System.out.println("Game Time: " + stopWatch.getTotalTime());
                        break;
                    } else if (player.getPosition() == normalSnake.getPosition()) {
                        player.losePoint(normalSnake);
                        normalSnake.showPlayerPosition(player, "snake");
                    } else if (player.getPosition() == kingCobra.getPosition()) {
                        player.losePoint(kingCobra);
                        kingCobra.showPlayerPosition(player, "king cobra");
                    } else if (player.getPosition() == elevator.getPosition()) {
                        elevator.increasePlayerPosition(player);
                        elevator.increasePlayerPoint(player);
                        elevator.showPlayerPosition(player, "elevator");
                    } else if (player.getPosition() == ladder.getPosition()) {
                        ladder.increasePlayerPoint(player);
                        ladder.increasePlayerPosition(player);
                        ladder.showPlayerPosition(player, "ladder");
                    } else {
                        System.out.println("Do you wanna play again?");
                    }
                    System.out.println("Total Point: " + player.getPoint());
                    _currentFace = rollDice(player, scanner, dice);

                    if (player.canMove(player.getPosition(), _currentFace)) {
                        player.increasePosition(_currentFace);
                        auxPlayerHasMoved++;
                    } else {
                        System.out.println("Dice Gave " + _currentFace);
                        System.out.println("Player cannot move");
                        _currentFace = rollDice(player, scanner, dice);
                    }
                }
                stopWatch.reset();
                System.out.println("Would you like to play again ? (Y/y) - (N-n): ");
                option = scanner.next();
                if (option.equals("n") || option.equals("N")) {
                    System.out.println("The Game has Finish!");
                    System.out.println("=========== Records ============");
                    for (Record record : records) {
                        System.out.println("Player Name: " + record.getPlayer());
                        System.out.println("Point: " + record.getPoint());
                        System.out.println("Time: " + record.getTime());
                    }
                }
            }
        }

    static String getString() {
            return new Scanner(System.in).nextLine().strip();
    }
    static int rollDice(Player player, Scanner scanner, Dice dice) {
        System.out.println("Hit enter to roll the dice");
        scanner.nextLine();
        player.rollDice(dice);
        return dice.getCurrentFace();
    }
    }
