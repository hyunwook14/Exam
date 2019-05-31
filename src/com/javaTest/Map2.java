package com.javaTest;

import java.util.Scanner;


//김민정
public class Map2 {

	int[][] Map = {
			{1,1,1,1,1,1},
			{0,0,0,2,1,0},
			{0,1,1,0,1,0},
			{0,0,1,0,1,0},
			{1,0,0,0,0,0},
			{1,1,1,1,1,1},
	};
	
	int[] object = {3,0}; //y좌표 , x좌표
	int[] beforeo = {3,0}; //물체 움직이기전 좌표 순서대로 y, x
	boolean flag =true; //게임종료를 알림
	Scanner scan = new Scanner(System.in);
	
	public void map() {
		
		for(int y= 0; y<Map.length; y++) {
			for(int x=0; x<Map[y].length; x++) {
				if(object[0]== y && object[1] == x) {
					System.out.print(" ○ ");
				}else {
				if(Map[y][x]== 1) {
					System.out.print(" ■ ");
				}else {
					System.out.print(" □ ");
				}
				}
				
			}
			System.out.println();
		}
	}
	
	public void move() {
		map();
		
		switch(scan.next().toUpperCase()) {
		case "W": //위로이동
			object[0] -= 1;
			break;
		case "S": //아래로이동
			object[0] += 1;
			break;
		case "A": //오른쪽으로이동
			object[1] -= 1;
			break;
		case "D": //왼쪽으로이동
			object[1] += 1;
			break;
			
		default:
			System.out.println("다시입력해주세요");
			break;
		}
		if(Map[object[0]][object[1]] == 1) {
			object[0] =beforeo[0];
			object[1] =beforeo[1];
		}else {
			beforeo[0] =object[0];
			beforeo[1] =object[1];
		}
		
		if(object[0]==4 &&object[1] ==1) {
			object[0] = 3;
			object[1] = 0;
		}else if(Map[object[0]][object[1]]==2){
			
			object[0] +=2;
		}else if(object[0]==1 && object[1] ==5) {
			
			flag =false;
			System.out.println("게임종료");
		}
		
		
		map();
	}
	
	public void start() {
		while(flag) {
			move();
		}
		
		
	}
	
}
