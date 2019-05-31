package com.javaTest;

import java.util.Scanner;
//김현정
public class Map3 {
	
	Scanner scan = new Scanner(System.in);

	int[][] Map = {
			{1,1,1,1,1,1,1},
			{0,0,0,0,0,0,1},
			{1,0,1,1,1,2,1},
			{1,0,1,3,0,1,1},
			{1,0,1,1,0,1,1},
			{1,0,0,0,0,0,0},
			{1,1,1,1,1,1,1}
	};
	int oy =5;  int ox = 2; //방해물의 위치
	int py = 1; int px = 0; //처음 물체의 위치
	int by = 1; int bx = 0; //움직이기전 물체의 위치
	boolean flag = true; //게임종료
	
	public void map() {
		
		for(int y=0; y<Map.length;y++) {
			for(int x=0; x<Map[y].length;x++) {
				if(py == y &&px ==x) {
					System.out.print(" ○ ");
				}else if(oy ==y && ox ==x) {
					System.out.print(" ● ");
				}
				else {
				if(Map[y][x]==1) {
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
		
		if(Map[py][px] ==0) {
			bx = px; by = py; //
		}
		
		switch(scan.next().toUpperCase()) {
		case "W": //위
			py -= 1;
			break;
		case "S": //아래
			py += 1;
			break;
		case "A": //왼쪽
			px -= 1;
			break;
		case "D": //오른쪽
			px += 1;
			break;
		default:
			break;
		}
		if(Map[py][px]==1) {
			px = bx; py =by; //물체를 만나면 그전위치로 돌아가라
		}else if(px == ox && py == oy) {
			px = bx; py = by;
		}
		
		
	}
	
	public void mission(int x, int y) {
		
		if(Map[y][x] ==2) {
			ox =8;
			oy =8;
		}else if(Map[y][x] ==3) {
			px =0;
			py =1;
		}
		
	}
	
	public void start() {
		
		while(flag) {
			map();
			move();
			mission(px,py);
			
			if(px==6 && py ==5) {
				flag =false;
				System.out.println("게임종료");
			}
			
		}
		
	}
	
}
