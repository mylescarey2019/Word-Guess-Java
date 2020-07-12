# Word-Guess-Java

## Java version of Presidential themed name guess game

## Test Cases

Functionality Cases
0. Prompt for how many words to play
    1. entered < 1 or > 44
        1. message to select from 1 to 44
    2. entered non-numeric
        1. input not accepted by scanner
    3. number between 1 and 44 entered
        1. number words for game play is set to entered number
1. Letter entered 
    1. already used
        1. message displayed showing letters already used
        2. message displayed - showing puzzle state again
    2. letter not in word - guesses remain
        1. message displayed information miss / remaining guess count
        2. message displayed - showing puzzle state again
    3. letter not in word - no guesses remain
        1. message displayed information miss / game loss
        2. message displayed - showing puzzle solved
        3. prompt for next word - show end of game if all 44 names exhausted
        4. show next word - begin again     
    4. letter in word - puzzle not yet solved - letter appears once    
        1. message displayed information hit
        2. message displayed - showing puzzle state again
    5. letter in word - puzzle not yet solved - letter multiple times   
        1. message displayed information hits
        2. message displayed - showing puzzle state again    
    6. letter in word - puzzle solved
        1. message displayed information of win condition
        2. message displayed - showing puzzle state
        3. prompt for next word - show end of game if all 44 names exhausted
        4. show next word - begin again  
2. Edge Cases
    1. non-letter entered
    2. show message of mis-key
3. End of Game
    1. Ask whether to play again - yYNN not entered
        1. message to ask again
    2. yY entered
        1. present the prompt for number of words to play
    3. nN entered
        2. say good bye
        

Results:   

[see README for test results GIF ](README.md)

