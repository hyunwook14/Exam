package com.javaTest;

import java.util.Scanner;
//염종찬
public class Map {
	int[][] Map = {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,1,0,0},
			{0,1,1,1,0},
			{0,0,1,0,0},
			{0,0,0,0,0}
			
	};
	
	boolean flag = true; //게임 끝날때까지 돌아가시오
	Scanner scan = new Scanner(System.in); // 이동키 입력 또는 특정데이터 입력
	int[] aim = {0,4}; // y좌표 , x좌표
	
	public void map() {
		for(int y=0; y<Map.length; y++) {
			for(int x=0; x<Map[y].length; x++) {
				
				if(y==aim[0] && x==aim[1]) {
					System.out.print(" ㉿  ");
				}else {
				if(Map[y][x] == 0) {
					System.out.print(" □ ");
				}else if(Map[y][x] == 1)
				{
					System.out.print(" ■ ");
				} 
				}
				
				
			}
			System.out.println();
		}
	}
	
	public void move() {
		map();
		String position = scan.next(); //이동키 입력
		switch(position.toUpperCase()) {
		
			case "W": //위로이동
				aim[0] -= 1;	
			break;
			case "S": //아래로이동
				aim[0] += 1;	
			break;
			case "A": //왼쪽으로이동
				aim[1] -= 1;	
			break;
			case "D": //오른쪽으로이동
				aim[1] += 1;	
			break;
			default:
			break;
		}
	}
	
	public void start() {
		int count =0;
		while(flag) {
			move();
			count++;
			if(aim[0]==3 && aim[1] ==2) {
				map();
				System.out.println("정답을 입력하세요");
				String test = scan.next();
				flag = false;
				System.out.println("명중");
				
			}
		}
	}
}
