/**
 * Class Description: Formats the Sessions given in the URL into a class, includes the participantId, sessionId, language, rounds, start time, and end time
 */
public class Sessions {
    private int participantId;
    private int sessionID;
    private String language;
    private int[] rounds;
    private int startTime;
    private int endTime;


    /**
     * Description: Constructor
     * @param participantId: Participant id
     * @param sessionID: Session id
     * @param language: language
     * @param rounds: array of rounds
     * @param startTime: start time
     * @param endTime: End time
     */
    public Sessions(int participantId, int sessionID, String language, int[] rounds, int startTime, int endTime) {
        this.participantId = participantId;
        this.sessionID = sessionID;
        this.language = language;
        this.rounds = rounds;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Description: Return the participant id
     * @return participantId
     */
    public int getParticipantId() {
        return participantId;
    }

    /**
     * Description: Return the session id
     * @return sessionID
     */
    public int getSessionID() {
        return sessionID;
    }

    /**
     * Description: Return the language
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Description: Return the rounds
     * @return rounds
     */
    public int[] getRounds() {
        return rounds;
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
