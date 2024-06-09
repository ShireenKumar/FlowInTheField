/**
 * Class Description: Formats the list of Languages that are needed to output the statistics of each language for each participant
 * includes the language, average score, and average round duration
 */
public class Language {
    private String language;
    private double averageScore;
    private double averageRoundDuration;

    /**
     * Description: Sets the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Description: Sets the averageScore
     */
    public void setAvgScore(double avgScore) {
        this.averageScore = avgScore;
    }

    /**
     * Description: Sets the averageRoundDuration
     */
    public void setAvgRoundDuration(double avgRoundDuration) {
        this.averageRoundDuration = avgRoundDuration;
    }

}
