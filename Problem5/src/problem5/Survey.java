/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class representing a completed survey
 * Also contains utilities to save survey
 * @author manxboy
 */
public class Survey {
    
    private static int numberCompleted;
    
    //question one
    private final boolean[] genres;
    
    //question two
    private final int hoursAWeek;
    
    //question three
    private final String currentGames;
    
    /**
     * Construct a new Survey, with the given answers
     * 
     * @param genres a Boolean array containing the answers to the first question,
     * ordered as [Shooters, Fighters, Platformers, Strategy, RPG, Puzzle, Arcade, Sports, Other]
     * 
     * @param hoursAWeek the number of hours a weak the answerer plays videogames,
     * NOTE: this value is the ordinal from the JComboBox, i.e. 0 = "Less than 5 hours" and so on
     * 
     * @param currentGames An array of Strings each of which is a game the answerer plays
     */
    public Survey(boolean[] genres, int hoursAWeek, String currentGames) {
        this.genres = genres;
        this.hoursAWeek = hoursAWeek;
        this.currentGames = currentGames;
    }
    
    /**
     * Saves the survey
     * @param survey the survey to append
     * @throws IOException if the file cannot be created / read
     */
    public static void SaveSurvey(Survey survey) {
            try{
                File results = new File("results.txt");
                
                boolean exists = results.exists();
                String contents = "";
                if (exists) contents = Files.readString(results.toPath());
                
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(results, false))) {
                    
                    if (exists) {
                        
                        String[] lines = contents.split("\n");
                        
                        //copy all of the original lines to this new array
                        String[] new_lines = lines.clone();
                        
                        //get the number of completed survays
                        
                        String[] first_line_split = lines[0].split(": ");
                        numberCompleted = Integer.parseInt(first_line_split[1]);
                        
                        //increment the number of completed surveys and write it back
                        
                        numberCompleted++;
                        
                        new_lines[0] = first_line_split[0] + ": " + numberCompleted;
                        
                        //loop over all of the parts of the first answer
                        for (int i = 0; i < 9; i++) {
                            
                            //check if the current survey checked this part
                            if (survey.genres[i]) {
                                
                                //if so, get the associated line and split over the - chacrater, incuding spaces
                                String[] lineSplit = lines[i + 3].split(" - ");
                                
                                //convert the number of checks to int
                                int numberOfChecks = Integer.parseInt(lineSplit[1]);
                                
                                //increase
                                numberOfChecks++;
                                
                                //write the change back to the new array
                                new_lines[i + 3] = lineSplit[0] + " - " + numberOfChecks;
                            }
                        }
                        
                        //second question
                        
                        //get the offset of the second question by adding together
                        //to offset of the last question(plus one) and the answer to
                        //the question, which lines up with the line to update
                        int second_question_offset  = 14 + survey.hoursAWeek;
                        
                        //split the line over the - chacater, incuding spaces
                        String[] second_qestion_line_split = lines[second_question_offset].split(" - ");
                        
                        //get the number of answers
                        int second_question_number_of_answers = Integer.parseInt(second_qestion_line_split[1]);
                        
                        //increase the number of answers
                        second_question_number_of_answers++;
                        
                        //write the changes back to the new array
                        new_lines[second_question_offset] = second_qestion_line_split[0] + " - " + second_question_number_of_answers;
                        
                        //write each line to the file
                        for (String line : new_lines) {
                            bw.write(line + "\n");
                        }
                    } else {
                        
                        //write a new File
                        
                        bw.write("Number of surveys completed: 1\n\n");
                        bw.write("Question 1:\n");
                        
                        bw.write("Shooters - "    + booleanToNumber(survey.genres[0]) + "\n");
                        bw.write("Fighters - "    + booleanToNumber(survey.genres[1]) + "\n");
                        bw.write("Platformers - " + booleanToNumber(survey.genres[2]) + "\n");
                        bw.write("Strategy - "    + booleanToNumber(survey.genres[3]) + "\n");
                        bw.write("RPG - "         + booleanToNumber(survey.genres[4]) + "\n");
                        bw.write("Puzzle - "      + booleanToNumber(survey.genres[5]) + "\n");
                        bw.write("Arcade - "      + booleanToNumber(survey.genres[6]) + "\n");
                        bw.write("Sports - "      + booleanToNumber(survey.genres[7]) + "\n");
                        bw.write("Other - "       + booleanToNumber(survey.genres[8]) + "\n\n");
                        
                        bw.write("Question 2:\n");
                        bw.write("< 5 hours - "  + booleanToNumber(survey.hoursAWeek == 0) + "\n");
                        bw.write("< 10 hours - " + booleanToNumber(survey.hoursAWeek == 1) + "\n");
                        bw.write("< 15 hours - " + booleanToNumber(survey.hoursAWeek == 2) + "\n");
                        bw.write("15+ hours - "  + booleanToNumber(survey.hoursAWeek == 3) + "\n\n");
                        
                        bw.write("Question 3:\n");
                        
                        
                        
                    }
                    
                    //both new and old files need this same step for the last question, appending the games choice
                    bw.write(survey.currentGames);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } catch (IOException ex) {
            Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
    /**
     * Convert a Boolean into either a 1, or a 0
     * @param b the Boolean to convert
     * @return an int, either 1 or 0
     */
    public static int booleanToNumber(boolean b) {
        return b? 1 : 0;
    }
    
}
