/**
 * Class Description: Formats the Rounds given in the URL into a class, includes the roundId, sessionId, score, start time, and end time
 */
public class Rounds {
    private int roundId;
    private int sessionId;
    private int score;
    private int startTime;
    private int endTime;

    /**
     * Description: Constructor
     * @param roundId: round id
     * @param sessionId: session id
     * @param score: score
     * @param startTime: start time
     * @param endTime: end time
     */
    public Rounds(int roundId, int sessionId, int score, int startTime, int endTime) {
        this.roundId = roundId;
        this.sessionId = sessionId;
        this.score = score;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Description: Return the round id
     * @return roundId
     */
    public int getRoundId() {
        return roundId;
    }

    /**
     * Description: Return the score
     * @return score
     */
    public int getScore()
    {
        return score;
    }
    /**
     * Description: Return the session id
     * @return sessionID
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * Description: Return the start time
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Description: Return the end time
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }
}
