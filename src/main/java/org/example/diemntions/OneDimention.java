package org.example.diemntions;

import org.example.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class OneDimention {
    public ArrayList<Point> points = new ArrayList<Point>();
    private int width;
    private int height;
    public OneDimention(double accuracy,int width,int height){
        this.width = width;
        this.height = height;
        int[] heights = getRandomDimentions();
        points.add(new Point(0,heights[0]));
        points.add(new Point(width,heights[1]));
        generatePoins(accuracy,new Point(0,heights[0]),new Point(width,heights[1]));
        System.out.println(Arrays.toString(points.toArray()));

    }

    private int[] getRandomDimentions(){
        int x = (int)(Math.random()*width);
        int y = (int)(Math.random()*height);
        return new int[]{x,y};
    }


    public void generatePoins(double accuracy,Point pointL,Point pointR){
        int midX = (pointL.x+pointR.x)/2;
        int y = (int)(Math.random()*height);
        Point midPoint = new Point(midX,y);
        System.out.println("Point: "+midPoint.x+" "+midPoint.y);
        points.add(midPoint);
        if(pointL.x+accuracy <pointR.x){
            generatePoins(accuracy,pointL,midPoint);
            generatePoins(accuracy,midPoint,pointR);
        }

    }
}
