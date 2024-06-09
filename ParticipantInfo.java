/**
 * Class Description: Formats the Participant information given in the URL into a class, includes the participantId, name, age, and sessions
 */

public class ParticipantInfo {
    private int participantId;
    private String name;
    private int age;
    private int[] sessions;

    /**
     * Description: Constructor
     * @param participantId: PArticipant Id
     * @param name: Participant name
     * @param age: Participant's age
     * @param sessions: array of session
     */
    public ParticipantInfo(int participantId, String name, int age, int[] sessions) {
        this.participantId = participantId;
        this.name = name;
        this.age = age;
        this.sessions = sessions;
    }

    /**
     * Description: Return the participant id
     * @return participant id
     */
    public int getParticipantId() {
        return participantId;
    }

    /**
     * Description: Return the participant name
     * @return participant name
     */
    public String getName() {
        return name;
    }

    /**
     * Description: Return the participant age
     * @return participant age
     */
    public int getAge() {
        return age;
    }

    /**
     * Description: Return the session
     * @return session
     */
    public int[] getSessions() {
        return sessions;
    }

}
