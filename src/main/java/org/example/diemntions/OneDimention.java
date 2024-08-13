package org.example.diemntions;

import org.example.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class OneDimention {
    private final ArrayList<Point> points = new ArrayList<Point>();
    private final int width;
    private final int height;
    public OneDimention(double accuracy,int width,int height){
        this.width = width;
        this.height = height;
        int[] heights = getRandomDimentions();
        points.add(new Point(0,heights[0]));
        points.add(new Point(width,heights[1]));
        generatePoins(accuracy,new Point(0,heights[0]),new Point(width,heights[1]));
        for(Point point:points){
            System.out.println(point.x+" "+point.y);
        }

    }

    private int[] getRandomDimentions(){
        int x = (int)(Math.random()*width);
        int y = (int)(Math.random()*height);
        return new int[]{x,y};
    }
  private int findInsertionIndex(Point newPoint) {
        int low = 0;
        int high = points.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (points.get(mid).x < newPoint.x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private void generatePoins(double accuracy,Point pointL,Point pointR){
        int midX = (pointL.x+pointR.x)/2;
        int midY = (pointL.y+pointR.y)/2;
        int y = (int)(Math.random()*20);
        midY+=y;
        Point midPoint = new Point(midX,midY);
        int insertionIndex = findInsertionIndex(midPoint);
        points.add(insertionIndex, midPoint);
        if(pointL.x+accuracy <pointR.x){
            generatePoins(accuracy,pointL,midPoint);
            generatePoins(accuracy,midPoint,pointR);
        }

    }
    public ArrayList<Point> getPoints(){
        return points;
    }
}
