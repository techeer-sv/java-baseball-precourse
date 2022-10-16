package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Hitter {
    private List<Integer> balls;

    public Hitter() {
        this.balls = new ArrayList<>();
    }

    public List<Integer> getBalls() {
        return balls;
    }

    public void hitBall() {
        if (this.balls.size() != 0) reset();

        StringTokenizer st = new StringTokenizer(Console.readLine());

        String ball = st.nextToken();
        for (Character c : ball.toCharArray()) {
            balls.add(Integer.parseInt(c.toString()));
        }
    }

    private void reset() {
        this.balls = new ArrayList<>();
    }
}
