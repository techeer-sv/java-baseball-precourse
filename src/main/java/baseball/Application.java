package baseball;

import java.util.Objects;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        while(true){
            BaseBallGame baseBallGame = appConfig.initBaseBallGame();
            baseBallGame.play();

            StringTokenizer st = new StringTokenizer(Console.readLine());
            String input = st.nextToken();
            if (Objects.equals(input, "2")) break;
        }
    }
}
