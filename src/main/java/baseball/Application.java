package baseball;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BaseBallGame baseBallGame = appConfig.initBaseBallGame();
        baseBallGame.play();
    }
}
