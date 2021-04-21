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
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		//char c = '7'; // c holds the character 7 (55)
		//int i = c - '0'; // i holds the number 7 (55 - 48) 
		//println(i);
	}

	public void loadScore(){
		char note;
		int dur = 0;
        for(int i = 0; i < score.length(); i++){
			note = score.charAt(i);
			if((score.length()-1!=i)){
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
		// for loop to print out notes and duration from Note notes within the noteList ArrayList
		for(Note notes : noteList){
			// if statement to check if duration is greater than 1
			// print out notes, duration and Crotchet otherwise
			// print out   ''       ''   and Quartet
			if(notes.getDuration() > 1){
				System.out.println(notes.getNote()+"\t"+notes.getDuration()+"\tCrotchet");
			}else{
				System.out.println(notes.getNote()+"\t"+notes.getDuration()+"\tQuartet");
			}
		}
	}

	public void drawStaves(){
		int staveLines = 5;
		int lineY = 70;
		for(int i = 0; i < staveLines; i++){
			strokeWeight(2);
			line(100, lineY, width - 100, lineY);
			lineY = lineY + 70;
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
		drawStaves();
		drawNotes();
	}

	void drawNotes(){

		line(150, 210, 150, 375);
		line(150, 210, 180, 250);
		if((mouseX >= 100 && mouseY >= 360) || (mouseX <= 130 && mouseY <= 375)){
			fill(255,0,0);
			ellipse(125, 375, 50, 50);
		}else{
			fill(0);
			ellipse(125, 375, 50, 50);
		}
	}
}
