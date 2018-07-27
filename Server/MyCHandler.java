package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.security.*;


public class MyCHandler implements ClientHandler {
	
	public MyCHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient) {
		
		BufferedWriter outTC = new BufferedWriter(new OutputStreamWriter(outToClient)); // will contain to solution
		BufferedReader inFClient = new BufferedReader(new InputStreamReader(inFromClient));
		
		
		String test = "";
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			while(!test.equals("done")) 
			{
				test = inFClient.readLine();
				list.add(test);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
		
		/*		

		int row = list.size() - 1;
		int col = list.get(0).length();
		
		char tmp;
		
		
		String[] normalMat = new String[row] ;
		int[][] moveMat = new int[row][col];
	//normalized class	
		for(int i = 0; i < row; i++) {
			normalMat[i]="";
			for(int j = 0; j < col; j++) {

				
				tmp = list.get(i).charAt(j);
				if(tmp == '-') {
					moveMat[i][j] = 0;
					normalMat[i] = normalMat[i] + "-"; 
				}
				else if(tmp == '|') {
					moveMat[i][j] = 1;
					normalMat[i] = normalMat[i] + "-";
				}
				else if(tmp == 'L') {
					moveMat[i][j] = 0; 
					normalMat[i] = normalMat[i] + "L";
				}
				else if(tmp == 'J') {
					moveMat[i][j] = 1;
					normalMat[i] = normalMat[i] + "L";
				}
				else if(tmp == '7') {
					moveMat[i][j] = 2;
					normalMat[i] = normalMat[i] + "L";
				}
				else if(tmp == 'F') {
					moveMat[i][j] = 3;
					normalMat[i] = normalMat[i] + "L";
				}
				else if(tmp == 's' || tmp == 'S') {
					moveMat[i][j] = 0; 
					normalMat[i] = normalMat[i] + "s";
				}
				else if(tmp == 'g' || tmp == 'G') {
					moveMat[i][j] = 0; 
					normalMat[i] = normalMat[i] + "s";
				}
				else {
					moveMat[i][j] = 0; 
					normalMat[i] = normalMat[i] + "0";
				}
			}
		}*/
		
		/*
		Integer hash = 0;
		for(String s: normalMat) {
			hash += s.hashCode();
		}
		*/
		
		File cm = new File();
		String _Solution = cm.checkForSolve(hash);
		System.out.println(_Solution);//chek
		if(!_Solution.equals(null)) {
		String FixedSol = "";
		Integer rowSol=0,colSol=0,turns=0,rotation=0;

		
		for(int i = 0; i < _Solution.length()-5; i += 6) {
			rowSol = Character.getNumericValue(_Solution.charAt(i));
			colSol = Character.getNumericValue(_Solution.charAt(i+2));
			turns = Character.getNumericValue(_Solution.charAt(i+4));
						//in normalizer
			if(normalMat[rowSol].charAt(colSol) == 'L') {
				rotation = ((turns.intValue() + moveMat[rowSol][colSol]) % 4);
			}
			else if(normalMat[rowSol].charAt(colSol) == '-') {
				rotation = ((turns.intValue() + moveMat[rowSol][colSol]) % 2);
			}
			else {
				rotation = 0;
			}
			
			FixedSol = (rowSol.toString() + "," + colSol.toString() + "," + rotation.toString());
			
			try {
				outTC.write(FixedSol);
				outTC.newLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
		}

		try {
			outTC.write("done");
			outTC.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}
	}
}
