/**
 * Class Description: Class used to format/organize each of the participant's statistics
 */
public  class  Output <T> {
    private int id;
    private String name;
    private Language[] languages;
    private T averageRoundScore;
    private T averageSessionDuration;

    /**
     * Description: Constructor
     * @param id: Participant id
     * @param name: Participant name
     * @param language: language
     * @param avgRoundScore: Average Round Score
     * @param averageSessionDuration: Average Session Duration
     */
    public Output(int id, String name, Language[] language, T  avgRoundScore, T averageSessionDuration) {
        this.id = id;
        this.name = name;
        this.languages = language;
        this.averageRoundScore = avgRoundScore;
        this.averageSessionDuration = averageSessionDuration;
    }

    /**
     * Description: Return the participant id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Description: Sets the participant id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Description: Returns the participant name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Description: Sets the participants name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description: Returns the languages
     * @return languages
     */
    public Language[] getLanguage() {
        return languages;
    }

    /**
     * Description: Sets the language
     */
    public void setlanguage(Language[] language) {
        this.languages = language;
    }

    /**
     * Description: Returns the averageRoundScore
     * @return averageRoundScore
     */
    public T getAvgRoundScore() {
        return averageRoundScore;
    }

    /**
     * Description: Sets the AvgRoundScore
     */
    public void setAvgRoundScore(T avgRoundScore) {
        this.averageRoundScore = avgRoundScore;
    }

    /**
     * Description: Returns the averageSessionDuration
     * @return averageSessionDuration
     */
    public T getAverageSessionDuration() {
        return averageSessionDuration;
    }
    /**
     * Description: Sets the averageSessionDuration
     */
    public void setAverageSessionDuration(T averageSessionDuration) {
        this.averageSessionDuration = averageSessionDuration;
    }


}
