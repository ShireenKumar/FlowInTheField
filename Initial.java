/**
 * Class Description: Formats all the information given in the URL into a class, includes the list of sessions, list of rounds, and lists of participant information
 */

import java.util.List;
public class Initial {
    private List<Sessions> sessions;
    private List<Rounds> rounds;
    private List<ParticipantInfo> participantInfo;

    /**
     * Description: Constructor
     * @param sessions: List of Sessions
     * @param rounds: List of rounds
     * @param participantInfo: List of participantInfo
     */
    public Initial(List<Sessions> sessions, List<Rounds> rounds, List<ParticipantInfo> participantInfo) {
        this.sessions = sessions;
        this.rounds = rounds;
        this.participantInfo = participantInfo;
    }

    /**
     * Description: Return the list if sessions
     * @return sessions
     */
    public List<Sessions> getSessions() {
        return sessions;
    }

    /**
     * Description: Return the list if rounds
     * @return rounds
     */
    public List<Rounds> getRounds() {
        return rounds;
    }

    /**
     * Description: Return the list if participantInfo
     * @return participantInfo
     */
    public List<ParticipantInfo> getParticipantInfo() {
        return participantInfo;
    }

}
