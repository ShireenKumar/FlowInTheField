/**
 * Class Description: Processes each participant to calculate and organize each of their statistics into an output class
 */

import java.util.*;

public class processParticipants {

    // Initial data that is given: list of Sessions, Rounds, and ParticipantInfo
    private Initial getInitial;

    /**
     * Description: Constructor that sets getInitial with the given data through the URL
     * @param getInitial The initial data that was given through the URL
     */
    public processParticipants(Initial getInitial) {
        this.getInitial = getInitial;
    }

    /**
     * Description: Calculates the average score of a specific participant using round ids
     * @param roundId: A list of roundIds within a specific Language and participantId
     * @return avg: returns average score of all the rounds given with the roundId
     */
    public Double averageScore(List<Integer> roundId)
    {
        int count = roundId.size();
        double add = 0.0;
        double avg = 0.0;
        for(int round : roundId)
        {
            for(Rounds rounds : getInitial.getRounds())
            {
                if(rounds.getRoundId() == round)
                {
                    add += rounds.getScore();
                }
            }

        }
        avg = add/count;
        double decimalAvg = Math.floor(avg* 100) / 100;
        return decimalAvg;
    }

    /**
     * Description: Calculate the total score of a specific participant and language, this is used when sorting the languages list with the total score of each language
     * @param roundId: A list of roundIds within a specific Language and participantId
     * @return add: The sum of the scores given a specific participant and language
     */
    public double totalScore(List<Integer> roundId)
    {
        double add = 0.0;
        for(int round : roundId)
        {
            for(Rounds rounds : getInitial.getRounds())
            {
                if(rounds.getRoundId() == round)
                {
                    add += rounds.getScore();
                }
            }
        }
        return add;
    }


    /**
     * Description: Calculates the total average round duration using all the session start and end times of all the languages
     * @param id: The id of a specific participant
     * @return avg: The average of all the sessions durations
     */
    public double totalAvgRoundDuration(int id)
    {
        double avg = 0.0;
        double count = 0;
        for(Sessions session : getInitial.getSessions())
        {
            if(session.getParticipantId() == id)
            {
                avg += (session.getEndTime()-session.getStartTime());
                count ++;
            }
        }
        avg = avg/count;

        return avg;
    }

    /**
     * Description: Takes in the array of roundIds, parses through the specific rounds with the matching id and
     * dds the difference of the end time and start time
     * @param arr: Array of roundId's
     * @return sum: The sum of end time - start time for all rounds indicated in the int array
     */
    public int parseRoundDuration(int [] arr)
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(Rounds rounds : getInitial.getRounds())
            {
                if(rounds.getRoundId() == arr[i])
                {
                    sum += (rounds.getEndTime() - rounds.getStartTime());
                }
            }
        }
        return sum;
    }

    /**
     * Description: Calculates the average round duration of each language
     * @param lang: The language that is matched to calculate the correct duration
     * @param id: The id that is used to correctly calculate the correct duration
     * @return avg: The average round duration
     */
    public double averageRoundDuration(String lang, int id)
    {
        double avg = 0.0;
        double count = 0.0;
        double add = 0.0;

            for(Sessions session : getInitial.getSessions())
            {
                if(session.getParticipantId() == id && lang.equals(session.getLanguage()))
                {
                    add += parseRoundDuration(session.getRounds());
                    count += session.getRounds().length;

                }
        }
        avg = add/count;
        double decimalAvg = Math.floor(avg* 100) / 100;
        return decimalAvg;


    }

    /**
     * Description: Takes in a set of languages and a participant id and returns a list of Languages in the correct order with all the
     * correct calculations set into each Language clas in the list
     * @param langList: A set of languages (string not class) that is used to match the correct information
     * @param id: The participant id used to calculate the correct numbers for each Language
     * @return language.reversed(): The list of languages in reversed or to match the correct format
     */
    public List<Language> allLanguages (Set<String> langList, int id)
    {
        int count = 0;
        int add = 0;
        int avg = 0;
        List<Integer> roundId = new ArrayList<>();
        List<Double> averageScore = new ArrayList<>();
        List<Language> language = new ArrayList<>();

        // TreeMap sorts values using the keys
        Map<Double, Language> map = new TreeMap<>();

        for(String lang : langList)
        {
            Language newLan = new Language();
            for(Sessions session : getInitial.getSessions())
            {
                if(session.getLanguage().equals(lang) && id == session.getParticipantId())
                {
                    count ++;
                    add += session.getEndTime() - session.getStartTime();
                    List<Integer> list = convert(session.getRounds());
                    roundId.addAll(list);
                }
            }

            newLan.setLanguage(lang);
            avg = add/count;
            newLan.setAvgRoundDuration(averageRoundDuration(lang,id));
            newLan.setAvgScore(averageScore(roundId));
            map.put(totalScore(roundId), newLan);

            roundId.clear();
            count = 0;
            add = 0;

        }

        // Sorts the Languages in ascending order using map
        for (Map.Entry<Double, Language> entry : map.entrySet()) {
            language.add(entry.getValue());
        }
        return language.reversed();
    }

    /**
     * Description: Converts an array of integers to a list of integers used to add the roundIds into a list
     * @param arr: The array of roundIds
     * @return list: The list of roundIDs
     */
    public List<Integer> convert(int[] arr)
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * Description: Uses the given participant id to add all the languages that participant practiced into a List
     * @param id: participant id
     * @return lang: A set of languages
     */
    public Set<String> listOfLan(int id)
    {
        Set<String> lang = new TreeSet<>();

        for(Sessions session : getInitial.getSessions())
        {
            if(session.getParticipantId() == id)
            {
                lang.add(session.getLanguage());
            }
        }
        return lang;
    }

    /**
     * Description: Parses through the Participants and adds all the ids to a set
     * @return id: the set of ids
     */
    public Set<Integer> listOfId()
    {
        Set<Integer> id = new TreeSet<>();
        for(ParticipantInfo participant : getInitial.getParticipantInfo())
        {
            id.add(participant.getParticipantId());
        }
        return id;
    }

    /**
     * Description: Creates a deep copy of the list of languages into an array of Languages
     * @param langList: The given list of Languages
     * @return array: The array version of the given list of Languages
     */
    public Language[] deepCopy(List<Language> langList)
    {
        Language[] array = new Language[langList.size()];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = langList.get(i);
        }
        return array;
    }

    /**
     * Description: Parses though the arrays of roundIds and adds up all the scores given the roundID
     * @param arr: array of roundIds
     * @return sum: Sum of the scores for rounds of a specific session
     */
    public double parseRoundScore(int[] arr)
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(Rounds rounds : getInitial.getRounds())
            {
                if(rounds.getRoundId() == arr[i])
                {
                    sum += rounds.getScore();
                }
            }
        }
        return sum;
    }

    /**
     * Description: Calculates the average round score of a specific participant
     * @param id: id used to identify the participant to calculate the average round for
     * @return avg: The average round score
     */
    public double averageRoundScore(int id)
    {
        double avg = 0.0;
        double count = 0.0;
        double add = 0.0;

        for(Sessions session : getInitial.getSessions())
        {
            if(session.getParticipantId() == id)
            {
                add += parseRoundScore(session.getRounds());
                count += session.getRounds().length;

            }
        }
        avg = add/count;

        return avg;
    }


    /**
     * Description: Sorts all the names of the participants in alphabetical order
     * @return ArrayList<>(sortNames): An array list of the set of sorted names
     */
    public List<String> sortedNames()
    {
        Set<String> sortNames = new TreeSet<>();
        for(ParticipantInfo participant : getInitial.getParticipantInfo())
        {
            sortNames.add(participant.getName());
        }
        return new ArrayList<>(sortNames);
    }


    /**
     * Description: Parses through ids and then each participant to accumulate each individual's information which is organized into the Output class
     * @return sortedOutputList: The list of participant statistics sorted and formatted correctly
     */
    public List<Output> process() {
        List<Integer> Id = new ArrayList<>(listOfId());
        Set<Integer> setOfId = listOfId();
        List<Output> outputList = new ArrayList<>();
        List<Output> sortedOutputList = new ArrayList<>();
        for(Integer id : setOfId){
            for (ParticipantInfo participant : getInitial.getParticipantInfo())
            {
                int participantId = participant.getParticipantId();
                if(participantId == id)
                {
                    List<Language> list = allLanguages(listOfLan(participantId),participantId);
                    Language[] array = deepCopy(list);
                    double scoreAvg = Math.floor(averageRoundScore(participantId)* 100) / 100;
                    double roundDurationAvg = Math.floor(totalAvgRoundDuration(participantId)* 100) / 100;

                    if(array.length == 0)
                    {

                        Output opt = new Output(participantId, participant.getName(), array, "N/A", "N/A");
                        outputList.add(opt);
                    }
                    else
                    {
                        Output opt = new Output(participantId, participant.getName(), array, scoreAvg, roundDurationAvg);
                        outputList.add(opt);
                    }
                }
            }



        }
        for(String names: sortedNames())
        {
            for(Output opt : outputList)
            {
                if(opt.getName().equals(names))
                {
                    sortedOutputList.add(opt);
                }
            }
        }
        return sortedOutputList;
    }
}
