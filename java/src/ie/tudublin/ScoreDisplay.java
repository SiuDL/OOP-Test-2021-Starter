package ie.tudublin;

// Student ID: C19401596
// Name: Siu Dzoen Lee
// Course Code: DT228/TU856

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	ArrayList<Note> noteList = new ArrayList<Note>();
	//String score = "DEFGABcd";
	String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void loadScore(){
		char note;
		int dur = 0;
        for(int i = 0; i < score.length(); i++){
			note = score.charAt(i);
			if((score.length()-1>i)){
				if(Character.isLetter(note)){
					if(Character.isDigit(score.charAt(i+1))){
						dur = score.charAt(i+1) - '0';
					}else{
						dur = 1;
					}
					Note notes = new Note(note, dur);
					noteList.add(notes);

					// for testing:
					// System.out.println(note +" and "+ dur);
				}
			}
        }
    }

	public void printScores(){
		for(Note notes : noteList){
			System.out.println(notes);
		}
	}

	public void setup() 
	{
		loadScore();
		printScores();
	}

	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
