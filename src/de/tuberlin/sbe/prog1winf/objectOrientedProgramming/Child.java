package de.tuberlin.sbe.prog1winf.objectOrientedProgramming;

public class Child extends Parent {

    public static void main(String[] args) {
        Child c = new Child();
        Parent p = c;
        System.out.println(p.getClass());
    }

    public Parent createCorrespondingParent(){
        Parent p = new Parent();
        //p.var1 = this.var1
        return p;
    }
}
