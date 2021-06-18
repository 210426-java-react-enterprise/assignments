package com.revature.solardoomsday;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/test.txt"));
			String input = bf.readLine();
			Result rs = new Result();
			while(input != null) {
				System.out.println(rs.calculateDoomsday(Integer.parseInt(input)));
				input = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	static class Result {

		public static List<Integer> calculateDoomsday(int area) {

		}
	}
}


