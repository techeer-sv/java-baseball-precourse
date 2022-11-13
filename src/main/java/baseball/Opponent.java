package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
    private final List<Integer> balls;

    public Opponent() {
        this.balls = new ArrayList<>();

    }

    public List<Integer> getBalls() {
        return balls;
    }

    public void throwBall() {
        while (balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1,9);
            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
    }
}
