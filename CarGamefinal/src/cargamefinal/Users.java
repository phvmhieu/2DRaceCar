/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

/**
 *
 * @author hieu
 */
public class Users {
    private String name;
    private String points;
    public Users(String name, String points){
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    public String toString (){
        return name + "         " + points;
    }
}
