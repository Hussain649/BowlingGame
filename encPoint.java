package org.acme.rest.json;

import java.util.ArrayList;
import java.util.List;

public class encPoint {
public String token;
public Point point;
public int NumberofAttempt;
public int getNumberofAttempt() {
	return NumberofAttempt;
}
public void setNumberofAttempt(int numberofAttempt) {
	NumberofAttempt = numberofAttempt;
}
public Point getPoint() {
	return point;
}
public void setPoint(Point point) {
	this.point = point;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}

public List<Point> points = new ArrayList<Point>();
public List<Point> getPoints() {
	return points;
}
public void setPoints(List<Point> points) {
	this.points = points;
}

public void addPoint(List<Point> e) {
	this.points.addAll(e);
}

public Integer sum(){
	List<Integer> frames = new ArrayList<Integer>();
	Integer sum = 0;
    for (int counter = 0; counter < points.size(); counter++) { 		      
       // System.out.println(arrlist.get(counter)); 	
    	Integer frame = points.get(counter).score + points.get(counter).second;
    	sum = frame + sum;
    	frames.add(frame);
    }
    return sum;
}
}
