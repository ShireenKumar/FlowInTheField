# FlowInTheField
This code was created for a coding challenge by Sandbox. Introduced to APIs and JSONs

- How to run your solution
This program is run through the Main.java class where the code implements the data given through the URL. There the class processParticipants
is called to calculate and format each participant's statistics. Once called, the list of statistics is then converted into a JSON file.
Then the code calls a POST request to send back the list of participant statistics. The code then prints out a response code and body.

- Your thought process/how you designed your solution
It was clear that the way the data was organized using classes were the best way to represent the Sessions, Rounds, Language, Participant information,
the initial data, and finally the output statistics. There was also a lot of parsing through the initial data to acquire certain
information, therefore, for each loop was used numerous times. Additionally when creating lists of round ids, names, languages, and participant ids the use of sets (TreeSets)
were vital in sorting and removing duplicate data. Maps (TreeMaps) were also used to help get two values from a function rather than one. It was specifically used to sort the list of
Languages with their total scores, the key was the total score and the value was the Language class associated with that Language. It was specifically a TreeMap, so the
values were sorted based on the keys.

Within processParticipants it was organized so that every calculation had a helper function, including helper functions for each of those calculations. Organizing
the code into different functions made the code easier to read and spot errors.

- The primary technical problems you ran into while implementing this challenge
Understanding how to code the GET and POST requests and from their inputting that data into the Initial class. Another problem was returning two values in a function.
It was a bit of a challenge to find a solution to that, which ended up being solved with a tree map data structure.

- Approximate time it took you to complete this project
This project was started on Tuesday and Finished on Friday and 1-2 hours were spent on it per day. In total 7-8 hours
