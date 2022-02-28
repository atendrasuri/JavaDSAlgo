package com.suri.catest;

import java.util.Objects;

public class TriangleArea {
    public static void main(String[] args) {

     Triangle triangle = new Triangle(new Point(3,2), new Point(2,-3), new Point(0,0));
        System.out.println(triangle.area());
        Triangle triangle1 = new Triangle(new Point(3,2), new Point(2,-3), new Point(0,0));
        System.out.println(triangle.equals(triangle1));
    }
}

class Point{
    private int x;
    private int y;
    Point(int x, int y){
        this.x=x;
        this.y =y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Triangle{
    private Point A;
    private Point B;
    private Point C;

    Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C= C;
    }


    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return A.equals(triangle.A) && B.equals(triangle.B) && C.equals(triangle.C);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C);
    }

    public float area(){
        float area = (A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX()  * (A.getY()  - B.getY())) / 2.0f;
        return Math.abs(area);

    }



}
