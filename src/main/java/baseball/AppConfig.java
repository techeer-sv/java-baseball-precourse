package baseball;

public class AppConfig {
    public BaseBallGame of() {
        Opponent opponent = new Opponent();
        Hitter hitter = new Hitter();

        return new BaseBallGame(opponent, hitter);
    }
}
