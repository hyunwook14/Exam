package com.javaTest;

import java.util.Scanner;

public class 밀기 {

	int[][] Map = {
			{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,2,0,2,0,0,1},
			{1,0,0,2,0,2,2,0,0,1},
			{1,0,0,0,0,2,2,0,0,1},
			{1,0,0,2,0,2,2,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1},
	};
	
	Scanner scan = new Scanner(System.in);
	
	int ox=1; int oy=1; int obx =1 ; int oby =1;
	
	//움직이는 물체좌표
	int bpx =4;  int bpy =2;
	int bpx2 =7; int bpy2 =2;
	int bpx3 =2; int bpy3 =5;
	int bpx4 =2; int bpy4 =6;
	int bpx5 =4; int bpy5 =7;
	int bpx6 =7; int bpy6 =7;
	
	public void mapPrint() {
		
		for(int y=0; y<Map.length; y++) {
			for(int x=0; x<Map[y].length; x++) {
				if(Map[y][x]==1) System.out.print(" ■ ");
				else if(Map[y][x] ==2) System.out.print(" □ ");
				else if(ox == x && oy ==y) System.out.print(" ㉿  ");
				else if(bpx2==x &&bpy2 ==y) System.out.print(" ● ");
				else if(bpx==x && bpy ==y) System.out.print(" ● ");
				else if(bpx3==x &&bpy3 ==y) System.out.print(" ● ");
				else if(bpx4==x &&bpy4 ==y) System.out.print(" ● ");
				else if(bpx5==x &&bpy5 ==y) System.out.print(" ● ");
				else if(bpx6==x &&bpy6 ==y) System.out.print(" ● ");
				else System.out.print(" ○ ");
				
			}
			System.out.println();
		}
		
	}
	int help =0;
	
	public void move() {
		mapPrint();
		obx= ox; oby =oy;
		switch(scan.next().toUpperCase()) {
		case "W": //위
			oy--;
			help =0;
			break;
			
		case "S": //아래
			oy++;
			help =1;
			break;
			
		case "A": //왼쪽
			ox--;
			help =2;
			break;
			
		case "D": //오른쪽
			ox++;
			help =3;
			break;
		default:
			System.out.println(" w, s, a, d 키를 눌러주세요");
			break;
		}
		
		if(Map[oy][ox] == 1) {
			ox = obx; oy = oby;
		}else if(Map[oy][ox]==2) {
			ox =obx; oy =oby;
		}else if((oy == bpy && ox ==bpx)||(oy == bpy2 && ox ==bpx2)||(oy == bpy3 && ox ==bpx3)||
				(oy == bpy4 && ox ==bpx4)||(oy == bpy5 && ox ==bpx5)||(oy == bpy6 && ox ==bpx6)) {
			push(bpy, bpx);
		}
			
		
		
		mapPrint();
	}
	boolean start =true;
	
	public void start() {
		int count =0;
		while(start) {
			move();
			count++;
			if(count >150) start = false;
		}
	}
	
	public void push(int bpy, int bpx) {
		int moving = 0;
		switch(help) {
		
		case 0://위
			if(Map[bpy+1][bpx]==0) 
					
					bpy++;
			
			break;
			
		case 1://아래
			if(Map[bpy-1][bpx]==0) bpy--;
			
			break;
			
		case 2://왼쪽
			if(Map[bpy][bpx-1] ==0) bpx--;
			
			break;
			
		case 3://오른쪽
			if(Map[bpy][bpx+1]==0) { 
					System.out.println(bpx);
				bpx++;
			}
			break;
		}
		
		
	}
	
	public int pushx(int y, int x) {
		boolean result =false;
		int moving=0;
	
			if((ox -obx)==1) {
				if(Map[y][x+1]==0)
					{
					moving =1;
					}

			}
			else if((ox- obx)==-1) {
				if(Map[y][x-1] ==0) {
					moving =-1;
				}
			}
			else moving =0;
	
			
			return moving;
		
	}
	
	public int pushy(int y, int x) {
		int moving=0;
		
		if((oy-oby)==1) {
			if(Map[y+1][x]==0)
				{
				moving =1;
				}
		}else if((oy-oby)==-1) {
			if(Map[y-1][x]==0) {
				moving =-1;
			}
		}else {
			moving =0;
		}
		
		
		return moving;
	}
	
}
