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
        String input = st.nextToken();
        validate(input);

        for (Character c : input.toCharArray()) {
            balls.add(Integer.parseInt(c.toString()));
        }
    }

    private void reset() {
        this.balls = new ArrayList<>();
    }

    private void validate(String input) {
        if (!isValidSize(input)) throw new IllegalArgumentException("입력 값은 세자리 수여야 합니다.");
        if (!isNumeric(input)) throw new IllegalArgumentException("입력 값은 자연수여야 합니다.");
        if(isDuplicated(input)) throw new IllegalArgumentException("각 자리 수는 서로 다른 수여야 합니다.");
    }

    /**
     * 입력 값의 자리수 검증
     * @param input
     * @return true if input size is valid.
     */
    private boolean isValidSize(String input) {
        return input.length() == 3;
    }

    /**
     * 입력값이 자연수임을 검증
     * @param input
     * @return true if input is digit.
     */
    private boolean isNumeric(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * 각 자리 수는 서로 다른 수임을 검증
     * @param input
     * @return true if input's elements are duplicated each other.
     */
    private boolean isDuplicated(String input) {
        for(int i=0; i<input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(i) == input.charAt(j) && i != j) return true;
            }
        }
        return false;
    }
}
