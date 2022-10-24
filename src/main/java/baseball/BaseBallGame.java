package baseball;

import java.util.List;
import java.util.Objects;

public class BaseBallGame {
    private final Opponent opponent;
    private final Hitter hitter;

    public BaseBallGame(Opponent opponent, Hitter hitter) {
        this.opponent = opponent;
        this.hitter = hitter;
    }

    public void play() {
        opponent.throwBall();

        do {
            try {

                System.out.print("숫자를 입력하세요 : ");
                hitter.hitBall();

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }
        } while (!computeScore());
    }

    private boolean computeScore() {

        int strike = countStrike();
        int ball = countBall(strike);


        return result(ball, strike);
    }

    private boolean result(int ball, int strike){
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        } else if (strike == 0) {
            System.out.println(ball + "볼");
        }else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    private int countBall(int strike) {
        List<Integer> oBalls = opponent.getBalls();
        List<Integer> hBalls = hitter.getBalls();
        int ball = 0;

        for (int hBall : hBalls) {
            if (oBalls.contains(hBall)) {
                ball ++;
            }
        }
        ball -= strike;
        return ball;
    }

    private int countStrike() {
        List<Integer> oBalls = opponent.getBalls();
        List<Integer> hBalls = hitter.getBalls();
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(oBalls.get(i), hBalls.get(i))) strike ++;
        }
        return strike;
    }
}
