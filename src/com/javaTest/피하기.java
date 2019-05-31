package com.javaTest;

import java.util.Scanner;

public class 피하기 {
	
	Scanner scan = new Scanner(System.in);
	
	int[][] Map = {
			{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1},
	};
	
	
	 
	int[] bhurdle =  {1,8};
	int[] hurdle2 = {1,4};
	int[] hurdle3 = {1,1};
	
	public void create() {
		
		int ox=0; int oy=0;
		int bx=0; int by=0;
	
	}
	
	
	int num =0; int num2=0;
	int px = 4; int py =8; //움직이는물체
	
	int[] hurdlex = {0,1,2,3,4,0,8,9,8,7};
	int[] hurdley = {0,1,2,3,4,5,6,7,2,2}; 
	//장애물


	public void map() {
		
		for(int y = 0; y<Map.length; y++) {
			for(int x = 0; x<Map[y].length; x++) {
				
				if( Map[y][x]==1) {
					System.out.print(" ■ ");
				}else if(y==py && x==px){
					System.out.print(" ♠ ");
				}else if(   hurdlex[num2]==x && hurdley[num] ==y ) {
					System.out.print(" ● ");
				}else if(Map[y][x] ==0){
					System.out.print(" □ ");
				}
				System.out.print(hurdley[num]+","+hurdlex[num2]+" ");
				 num2++;
				if(num ==10) num =0;
				if(num2 ==10) {
					num2 =0;
					num++;
				}
				
				
			}
			System.out.println();
		}
	}
	
	public void move() {
		map();
		switch(scan.next().toUpperCase()) {
		case "A": //왼쪽
			px -= 1;
			break;
		case "D": //오른쪽
			px += 1;
			break;
			
		default:
			System.out.println(" a, d 둘 중의 하나 다시 입력해주세요.");
			break;
		}
		
		for(int y=0; y<hurdley.length; y++) {
			hurdley[y] += 1;
			
			
		}
		map();
	}
	
	public void start() {
		
		move();
		
	}
}
