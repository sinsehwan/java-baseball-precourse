package model;

public class GameAnswerType {
    private final int strikeCount;
    private final int ballCount;

    public GameAnswerType() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public GameAnswerType(int strikeCount, int ballCount){
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getAnswer() {
        if (strikeCount + ballCount == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            sb.append(strikeCount);
            sb.append("스트라이크 ");
        }

        if (ballCount > 0) {
            sb.append(ballCount);
            sb.append("볼");
        }

        return sb.toString();
    }
}
